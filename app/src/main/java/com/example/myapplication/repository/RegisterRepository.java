package com.example.myapplication.repository;

import android.app.Application;

import com.example.myapplication.beans.RegisterResponse;
import com.example.myapplication.network.RestClient;
import com.example.myapplication.utility.Constants;
import com.google.gson.JsonObject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RegisterRepository {

    public RegisterRepository(Application application) {
    }


    public Single<RegisterResponse> createUser(String name,
                                               String email,
                                               String phone,
                                               String password,
                                               String deviceType,
                                               String deviceToken) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(Constants.API_NAME, name);
        jsonObject.addProperty(Constants.API_EMAIL, email);
        jsonObject.addProperty(Constants.API_PHONE, phone);
        jsonObject.addProperty(Constants.API_PASSWORD, password);
        jsonObject.addProperty(Constants.API_DEVICE_TYPE, deviceType);
        jsonObject.addProperty(Constants.API_DEVICE_TOKEN, deviceToken);

        return RestClient.getRestClient(Constants.DEFAULT_BASE_URL)
                .register("application/json", jsonObject)
                .subscribeOn(Schedulers.io());
    }


}