package com.example.mpishi.Services;
import com.example.mpishi.model.Access_token;
import com.example.mpishi.model.STK_push;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface STK_pushservice {
    @POST("mpesa/stkpush/v1/processrequest")
    Call<STK_push> sendPush(@Body STK_push stkPush);

    @GET("oauth/v1/generate?grant_type=client_credentials")
    Call<Access_token> getAccessToken();
}