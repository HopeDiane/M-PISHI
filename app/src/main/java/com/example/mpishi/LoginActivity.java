package com.example.mpishi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;


public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText logPassword = findViewById(R.id.logPassword);
        Button logBtn = findViewById(R.id.loginBtn);
        EditText logEmail = findViewById(R.id.Email);
        mAuth = FirebaseAuth.getInstance();

        logBtn.setOnClickListener(v ->{
            String email = logEmail.getText().toString().trim();
            String password = logPassword.getText().toString().trim();

            if (email.isEmpty()){
                logEmail.setError("Email is empty");
                logEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                logEmail.setError("Enter Valid Email");
                logEmail.requestFocus();
                return;
            }
            if (password.isEmpty())
            {
                logPassword.setError("Password is Empty");
                logPassword.requestFocus();
                return;
            }
            if (password.length() < 5) {
                logPassword.setError("Password should be more than 5 characters");
                logPassword.requestFocus();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password).
                addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, ChooseUserActivity.class));

                        } else {
                            Toast.makeText(LoginActivity.this, "Please check login credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
            });
        });




        TextView goToRegister = findViewById(R.id.Register);
        goToRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(regIntent);
            }


        });


    }
}



