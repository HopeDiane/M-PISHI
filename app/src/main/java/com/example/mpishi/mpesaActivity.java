package com.example.mpishi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mpishi.model.Access_token;
import com.example.mpishi.model.STK_push;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;
import static com.example.mpishi.Constants.BUSINESS_SHORT_CODE;
import static com.example.mpishi.Constants.CALLBACKURL;
import static com.example.mpishi.Constants.PARTYB;
import static com.example.mpishi.Constants.PASSKEY;
import static com.example.mpishi.Constants.TRANSACTION_TYPE;

public class mpesaActivity extends AppCompatActivity implements View.OnClickListener {

    private Daraja_Api_client mApiClient;
    private ProgressDialog mProgressDialog;

    @BindView(R.id.amount)
    EditText mAmount;
    @BindView(R.id.number)EditText mPhone;
    @BindView(R.id.pay)
    Button mPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mProgressDialog = new ProgressDialog(this);
        mApiClient = new Daraja_Api_client();
        mApiClient.setIsDebug(true); //Set True to enable logging, false to disable.

        mPay.setOnClickListener(this);

        getAccessToken();

    }

    public void getAccessToken() {
        mApiClient.setGetAccessToken(true);
        mApiClient.mpesaService().getAccessToken().enqueue(new Callback<Access_token>() {
            @Override
            public void onResponse(@NonNull Call<Access_token> call, @NonNull Response<Access_token> response) {

                if (response.isSuccessful()) {
                    mApiClient.setAuthToken(response.body().accessToken);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Access_token> call, @NonNull Throwable t) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view== mPay){
            String phone_number = mPhone.getText().toString();
            String amount = mAmount.getText().toString();
            performSTKPush(phone_number,amount);
        }
    }


    public void performSTKPush(String phone_number,String amount) {
        mProgressDialog.setMessage("Processing your request");
        mProgressDialog.setTitle("Please Wait...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        String timestamp = utils.getTimestamp();
        STK_push stkPush = new STK_push(
                BUSINESS_SHORT_CODE,
                utils.getPassword(BUSINESS_SHORT_CODE, PASSKEY, timestamp),
                timestamp,
                TRANSACTION_TYPE,
                Integer.valueOf(amount),
                utils.sanitizePhoneNumber(phone_number),
                PARTYB,
                utils.sanitizePhoneNumber(phone_number),
                CALLBACKURL,
                "MPESA Android Test", //Account reference
                "Testing"  //Transaction description
        );

        mApiClient.setGetAccessToken(false);

        //Sending the data to the Mpesa API, remember to remove the logging when in production.
        mApiClient.mpesaService().sendPush(stkPush).enqueue(new Callback<STK_push>() {
            @Override
            public void onResponse(@NonNull Call<STK_push> call, @NonNull Response<STK_push> response) {
                mProgressDialog.dismiss();
                try {
                    if (response.isSuccessful()) {
                        Timber.d("post submitted to API. %s", response.body());
                    } else {
                        Timber.e("Response %s", response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<STK_push> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Timber.e(t);
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}