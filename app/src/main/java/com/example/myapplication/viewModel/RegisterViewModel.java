package com.example.myapplication.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.base.BaseViewModel;
import com.example.myapplication.beans.RegisterResponse;
import com.example.myapplication.repository.RegisterRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class RegisterViewModel extends BaseViewModel {

    private RegisterRepository registerRepository;
    private CompositeDisposable mDisposable;
    private MutableLiveData<RegisterResponse> mRegisterResponse = new MutableLiveData<>();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        registerRepository = new RegisterRepository(application);
        mDisposable = new CompositeDisposable();
    }


    public void createUser(String name,
                           String email,
                           String phone,
                           String password,
                           String deviceType,
                           String deviceToken) {

        mDisposable.add(
                registerRepository.createUser(name, email, phone, password, deviceType, deviceToken)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(data -> mRegisterResponse.setValue(data), throwable -> {
                            Log.e("Error: ", throwable.getMessage());
                        })
        );

    }


    public LiveData<RegisterResponse> getRegisterResponseLiveData() {
        return mRegisterResponse;
    }

}
