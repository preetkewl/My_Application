package com.example.myapplication.network;

import com.example.myapplication.beans.RegisterResponse;
import com.google.gson.JsonObject;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("register")
    Single<RegisterResponse> register(@Header("Content-Type") String value, @Body JsonObject object);



}