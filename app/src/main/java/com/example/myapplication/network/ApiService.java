package com.example.myapplication.network;

import com.google.gson.JsonObject;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/login")
    Single<ResponseBody> emailValidate(@Body JsonObject object);

}