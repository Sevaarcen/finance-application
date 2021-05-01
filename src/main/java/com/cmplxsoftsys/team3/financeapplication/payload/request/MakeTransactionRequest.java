package com.cmplxsoftsys.team3.financeapplication.payload.request;

public class MakeTransactionRequest {
    private String userId;
    private double value;

    public String getUserId() {
        return userId;
    }

    public double getValue() {
        return value;
    }
}
