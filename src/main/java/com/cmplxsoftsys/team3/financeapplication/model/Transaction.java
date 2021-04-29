package com.cmplxsoftsys.team3.financeapplication.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.StringJoiner;

public class Transaction {

    @Id
    private String id;

    private String userId;
    private double value;
    private Date date;

    public Transaction(String userId, double value) {
        this.userId = userId;
        this.value = value;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Transaction.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("userId='" + userId + "'")
                .add("value=" + value)
                .add("date=" + date)
                .toString();
    }
}
