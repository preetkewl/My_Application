package com.example.myapplication.base;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

public class BaseRepository {

    private static final BaseRepository INSTANCE = new BaseRepository();

    private final MediatorLiveData<Intent> mWellBeingData = new MediatorLiveData<>();
    private final MediatorLiveData<Intent> mAutoRefreshData = new MediatorLiveData<>();

    private BaseRepository() {
    }

    static BaseRepository instance() {
        return INSTANCE;
    }

    public LiveData<Intent> getData() {
        return mWellBeingData;
    }

    LiveData<Intent> getAutoRefreshData() {
        return mAutoRefreshData;
    }

    void addWellBeingDataSource(LiveData<Intent> data) {
        mWellBeingData.addSource(data, mWellBeingData::setValue);
    }

    void removeWellBeingDataSource(LiveData<Intent> data) {
        mWellBeingData.removeSource(data);
    }

    void addAutoRefreshDataSource(LiveData<Intent> data) {
        mAutoRefreshData.addSource(data, mAutoRefreshData::setValue);
    }

    void removeAutoRefreshDataSource(LiveData<Intent> data) {
        mAutoRefreshData.removeSource(data);
    }


}
