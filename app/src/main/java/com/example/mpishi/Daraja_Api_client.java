package com.example.mpishi;

import com.example.mpishi.Interceptor.Access_Token_interceptor;
import com.example.mpishi.Interceptor.Auth_interceptor;
import com.example.mpishi.Services.STK_pushservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mpishi.Constants.BASE_URL;
import static com.example.mpishi.Constants.CONNECT_TIMEOUT;
import static com.example.mpishi.Constants.READ_TIMEOUT;
import static com.example.mpishi.Constants.WRITE_TIMEOUT;

public class Daraja_Api_client {
    private Retrofit retrofit;
    private boolean isDebug;
    private boolean isGetAccessToken;
    private String mAuthToken;
    private HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    public Daraja_Api_client setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        return this;
    }

    public Daraja_Api_client setAuthToken(String authToken) {
        mAuthToken = authToken;
        return this;
    }

    public Daraja_Api_client setGetAccessToken(boolean getAccessToken) {
        isGetAccessToken = getAccessToken;
        return this;
    }

    private OkHttpClient.Builder okHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);

        return okHttpClient;
    }

    private Retrofit getRestAdapter() {

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());

        if (isDebug) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        OkHttpClient.Builder okhttpBuilder = okHttpClient();

        if (isGetAccessToken) {
            okhttpBuilder.addInterceptor(new Access_Token_interceptor());
        }

        if (mAuthToken != null && !mAuthToken.isEmpty()) {
            okhttpBuilder.addInterceptor(new Auth_interceptor(mAuthToken));
        }

        builder.client(okhttpBuilder.build());

        retrofit = builder.build();

        return retrofit;
    }
    public STK_pushservice mpesaService() {
        return getRestAdapter().create(STK_pushservice.class);
    }
}