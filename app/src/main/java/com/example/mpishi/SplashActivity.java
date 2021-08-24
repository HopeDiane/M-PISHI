

    package com.example.mpishi;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mpishi.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

    public class SplashActivity extends AppCompatActivity {

        private static int SPLASH_TIME_OUT=5000;

    Animation topAnimation, bottomAnimation, middleAnimation;
    View first,second,third,fourth,fifth,sixth;
    TextView mpishi,tagline;

        private AppBarConfiguration appBarConfiguration;
        private ActivityMainBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_splash);

            topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation);
            bottomAnimation= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
            middleAnimation= AnimationUtils.loadAnimation(this, R.anim.middle_animation);

            first=findViewById(R.id.first_line);
            second=findViewById(R.id.second_line);
            third=findViewById(R.id.third_line);
            fourth=findViewById(R.id.fourth_line);
            fifth=findViewById(R.id.fifth_line);
            sixth=findViewById(R.id.sixth_line);

            mpishi= findViewById(R.id.mpishi);
            tagline= findViewById(R.id.tagline);

            first.setAnimation(topAnimation);
            second.setAnimation(topAnimation);
            third.setAnimation(topAnimation);
            fourth.setAnimation(topAnimation);
            fifth.setAnimation(topAnimation);
            sixth.setAnimation(topAnimation);

            mpishi.setAnimation(middleAnimation);
            tagline.setAnimation(bottomAnimation);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent( SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }



    }
