package com.example.mpishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        Button chefBtn = findViewById(R.id.chefBtn);
        Button customerBtn = findViewById(R.id.customerBtn);

        chefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chefIntent = new Intent(getApplicationContext(), ChefLandingPage.class);
                startActivity(chefIntent);
            }
        });

        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent custIntent = new Intent(getApplicationContext(), UserHomeLandingPage.class);
                startActivity(custIntent);
            }
        });
    }
}