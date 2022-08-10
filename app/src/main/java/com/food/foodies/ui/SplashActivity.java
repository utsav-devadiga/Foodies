package com.food.foodies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
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

        //wait till the animation ends
        binding.splashAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //going to home screen after the animation ends
                Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


    }
}