package com.example.snacktrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    TextView textView;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView= findViewById(R.id.welcomeTxt);
        lottieAnimationView= findViewById(R.id.lottie);
        textView.animate().setDuration(9000);
        lottieAnimationView.animate().setDuration(9000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent intent= new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
            }
        },5000);

    }
}