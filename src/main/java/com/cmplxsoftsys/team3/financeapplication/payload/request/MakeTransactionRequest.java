package com.cmplxsoftsys.team3.financeapplication.payload.request;

public class MakeTransactionRequest {
    private String userId;
    private double value;
    private String loanId;

    public String getUserId() {
        return userId;
    }

    public double getValue() {
        return value;
    }

    public String getLoanId() { return loanId; }
}
