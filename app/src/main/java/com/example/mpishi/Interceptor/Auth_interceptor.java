package com.example.mpishi.Interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class Auth_interceptor implements Interceptor {
    private String mAuthToken;

    public Auth_interceptor(String authToken) {
        mAuthToken = authToken;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request  = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + mAuthToken)
                .build();
        return chain.proceed(request);
    }
}