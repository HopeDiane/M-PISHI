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
        Button startButton = findViewById(R.id.getStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lookingIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(lookingIntent);

            }
        });

    }

    public void getStart(View view) {
    }
}