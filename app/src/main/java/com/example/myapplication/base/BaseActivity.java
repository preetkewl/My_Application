package com.example.myapplication.base;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.application.EcoHubApplication;

public class BaseActivity extends AppCompatActivity {

    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Show progress dialog.
     */
    public void showProgressDialog() {
        try {
            progressDialog.setMessage(getResources().getString(R.string.please_wait));
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show progress dialog with message.
     *
     * @param message the message
     */
    public void showProgressDialogWithMessage(String message) {
        try {
            progressDialog.setMessage(message);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hide progress dialog.
     */
    public void hideProgressDialog() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("BaseActivity", "onDestroy()");
    }

    /**
     * Show toast.
     *
     * @param value the value
     */
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(BaseActivity.class.getName(), "on Resume");
        EcoHubApplication.activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(BaseActivity.class.getName(), "on Pause");
        EcoHubApplication.activityPaused();
    }

}