package com.example.mpishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChefLandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_landing_page);

        Button chefProfile = findViewById(R.id.chefProfileBtn);
        Button chefBookings = findViewById(R.id.chefBookingBtn);

        chefProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chefIntent = new Intent(getApplicationContext(), ChefProfile.class);
                startActivity(chefIntent);
            }
        });

        chefBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent custIntent = new Intent(getApplicationContext(), ChefBookings.class);
                startActivity(custIntent);
            }
        });
    }
}