package com.cmplxsoftsys.team3.financeapplication.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.StringJoiner;

public class LoanApplication {
    @Id
    private String id;

    private String userId;

    private String type;
    private double amount;
    private int tenure;
    private Date date;


    public LoanApplication(String type, double amount, int tenure, String userId) {
        this.type = type;
        this.amount = amount;
        this.tenure = tenure;
        this.date = new Date();
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setLoanType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTenure() {
        return this.tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }
        

    @Override
    public String toString() {
        return new StringJoiner(", ", LoanApplication.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("userId='" + userId + "'")
                .add("type='" + type + "'")
                .add("amount=" + amount)
                .add("tenure=" + tenure)
                .add("date=" + date)
                .toString();
    }
}
