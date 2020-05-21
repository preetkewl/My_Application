package com.example.myapplication.application;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.utility.AppSharedPreference;

import java.lang.ref.WeakReference;

public class EcoHubApplication extends Application {

    private static WeakReference<Context> context;
    public static AppSharedPreference mAppSharedPreference;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppSharedPreference = AppSharedPreference.getInstance(this);
        context = new WeakReference<>(getApplicationContext());
    }

    public static WeakReference<Context> getAppContext() {
        return context;
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}