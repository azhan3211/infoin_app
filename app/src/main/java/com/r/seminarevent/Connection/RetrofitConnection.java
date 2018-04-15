package com.r.seminarevent.Connection;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Unknown on 3/25/2018.
 */

public class RetrofitConnection {

    public Retrofit service() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(httpLoggingInterceptor);

        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.102/infoin/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build());

        return retrofit.build();
    }
}
