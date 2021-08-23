package com.example.mpishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button lookingButton = findViewById(R.id.lookingChef);
        Button userChef = findViewById(R.id.userAsChef);
        lookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lookingIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(lookingIntent);

            }
        });

        userChef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    public void LookingChef(View view) {
    }

    public void Chef(View view) {
    }
}