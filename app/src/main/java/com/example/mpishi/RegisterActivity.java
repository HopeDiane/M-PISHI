package com.example.mpishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView textGoToSignUp = findViewById(R.id.logIn);
        textGoToSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent goIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(goIntent);
            }



        });



    }
    public void goToSignUp(View view) {
    }
}
