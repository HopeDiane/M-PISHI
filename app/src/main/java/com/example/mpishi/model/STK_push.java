package com.example.mpishi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class STK_push {

        @SerializedName("BusinessShortCode")
        @Expose
        public String businessShortCode;
        @SerializedName("Password")
        @Expose
        public String password;
        @SerializedName("Timestamp")
        @Expose
        public String timestamp;
        @SerializedName("TransactionType")
        @Expose
        public String transactionType;
        @SerializedName("Amount")
        @Expose
        public Integer amount;
        @SerializedName("PartyA")
        @Expose
        public Long partyA;
        @SerializedName("PartyB")
        @Expose
        public Integer partyB;
        @SerializedName("PhoneNumber")
        @Expose
        public Long phoneNumber;
        @SerializedName("CallBackURL")
        @Expose
        public String callBackURL;
        @SerializedName("AccountReference")
        @Expose
        public String accountReference;
        @SerializedName("TransactionDesc")
        @Expose
        public String transactionDesc;

        public STK_push(String businessShortCode, String password, String timestamp, String transactionType,
                        Integer amount, String partyA, String partyB, String phoneNumber, String callBackURL,
                        String accountReference, String transactionDesc) {
                this.businessShortCode = businessShortCode;
                this.password = password;
                this.timestamp = timestamp;
                this.transactionType = transactionType;
                this.amount = amount;
                this.partyA = partyA;
                this.partyB = partyB;
                this.phoneNumber = phoneNumber;
                this.callBackURL = callBackURL;
                this.accountReference = accountReference;
                this.transactionDesc = transactionDesc;
        }


}
