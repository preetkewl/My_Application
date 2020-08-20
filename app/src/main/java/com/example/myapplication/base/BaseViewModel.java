package com.example.myapplication.base;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class BaseViewModel extends AndroidViewModel {

    private MutableLiveData<Throwable> mErrorLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> mDataBaseErrorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> mShowProgressBar = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Intent> getWellBeingNotificationData() {
        // for simplicity return data directly to view
        return BaseRepository.instance().getData();
    }

    public LiveData<Intent> getAutoRefreshData() {
        // for simplicity return data directly to view
        return BaseRepository.instance().getAutoRefreshData();
    }

    public MutableLiveData<Boolean> getShowProgressBar() {
        return mShowProgressBar;
    }

    public void setShowProgressBar(Boolean showProgressBars) {
        mShowProgressBar.setValue(showProgressBars);
    }

    LiveData<Throwable> getErrorLiveData() {
        return mErrorLiveData;
    }

    public void setErrorLiveData(Throwable s) {
        mErrorLiveData.setValue(s);
    }

    LiveData<Throwable> getDataBaseErrorLiveData() {
        return mDataBaseErrorLiveData;
    }

    public void setDataBaseErrorLiveData(Throwable error) {
        mDataBaseErrorLiveData.setValue(error);
    }

}