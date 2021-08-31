package com.example.mpishi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialize register xml elements
        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText phoneNo = findViewById(R.id.phone);
        EditText emailAddress = findViewById(R.id.Email);
        EditText password = findViewById(R.id.RegPassword);
        TextView textGoToSignUp = findViewById(R.id.logIn);
        Button registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = emailAddress.getText().toString().trim();
                String pass_word = password.getText().toString().trim();

                if (email.isEmpty()) {
                    emailAddress.setError("Required");
                    emailAddress.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailAddress.setError("Enter Valid Email");
                    emailAddress.requestFocus();
                    return;
                }
                if (pass_word.isEmpty()) {
                    password.setError("Enter the Password");
                    password.requestFocus();
                    return;
                }
                if (password.length() < 5) {
                    password.setError("Password should be more than 5 characters");
                    password.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,pass_word).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this, "You are successfully Registered", Toast.LENGTH_SHORT).
                                    show();
                            startActivity(new Intent(RegisterActivity.this, ChooseUserActivity.class));

                        } else {
                            Toast.makeText(RegisterActivity.this, "You are not Registered, Try Again!", Toast.LENGTH_SHORT).
                                    show();
                        }
                    }
                });
            }

        });




        textGoToSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(goIntent);
            }


        });


    }
}
