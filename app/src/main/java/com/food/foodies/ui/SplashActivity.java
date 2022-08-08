package com.food.foodies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.food.foodies.databinding.ActivitySplashBinding;

/**
 * here we add the custom splash screen as
 * there's new Android 12 splashscreen api is available
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    //view-binding
    ActivitySplashBinding binding;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflating the view to access the view binding.
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        //asking permissions for locations


    }
}