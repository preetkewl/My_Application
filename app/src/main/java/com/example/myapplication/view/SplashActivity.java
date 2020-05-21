package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.application.EcoHubApplication;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.utility.AppSharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    AppSharedPreference sharedPreference = EcoHubApplication.mAppSharedPreference;

    @BindView(R.id.lottieAnimationView)
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        animationView.setImageAssetsFolder("assets");
//        animationView.setAnimation("couple_riding_vespa.json");
//        animationView.addAnimatorListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) { }
//
//            @Override
//            public void onAnimationEnd(Animator animation) { startActivity(new Intent(SplashActivity.this, LoginActivity.class)); }
//
//            @Override
//            public void onAnimationCancel(Animator animation) { }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) { }
//        });
//        animationView.playAnimation();
    }
}