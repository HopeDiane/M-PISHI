package com.example.mpishi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Access_token {
    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("expires_in")
    @Expose
    private String expiresIn;

    public Access_token(String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}