package com.example.myapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppSharedPreference {

    private static final String ECOHUB_PREF_NAME = "ecohub";

    private static SharedPreferences mSharedPref;
    private static AppSharedPreference mAppSharedPreference;

    private AppSharedPreference() {
    }

    private AppSharedPreference(Context context) {
        mSharedPref = context.getSharedPreferences(ECOHUB_PREF_NAME, MODE_PRIVATE);
    }

    public static AppSharedPreference getInstance(Context context) {
        if (mAppSharedPreference == null) {
            mAppSharedPreference = new AppSharedPreference(context.getApplicationContext());
        }
        return mAppSharedPreference;
    }

    private SharedPreferences getSharedPref() {
        return mSharedPref;
    }

    private static final String DEVICE_TOKEN = "device_token";

    public String getDeviceToken() {
        return getSharedPref().getString(DEVICE_TOKEN, "");
    }

    void setDeviceToken(String value) {
        SharedPreferences.Editor editor = getSharedPref().edit();
        editor.putString(DEVICE_TOKEN, value);
        editor.apply();
    }


}
