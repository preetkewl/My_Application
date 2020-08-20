package com.example.myapplication.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static ApiService apiPostService;
    private static Retrofit retrofitPostClient;


    public static ApiService getRestClient(String url) {
        if (apiPostService == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient okClient = new OkHttpClient.Builder().
                    connectTimeout(1, TimeUnit.MINUTES).
                    readTimeout(3, TimeUnit.MINUTES).
                    addInterceptor(interceptor).build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofitPostClient = new Retrofit.Builder()
                    .baseUrl(url).client(okClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                    .build();

            apiPostService = retrofitPostClient.create(ApiService.class);


        }
        return apiPostService;
    }
}