package com.cmplxsoftsys.team3.financeapplication.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * The loan class is the structure for loans and keeps track of attributes of that loan
 */
public class Loan {

    @Id
    private String id;

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    private String loanType;
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount, String loanType) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
        this.loanType = loanType;
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Set a new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /** Return numberOfYears */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /** Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /** Return loanAmount */
    public double getLoanAmount() {
        return loanAmount;
    }

    /** Set a newloanAmount */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /** Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 -(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    }

    /** Find total payment */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    /** Return loan date */
    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanType(String loanType) { this.loanType = loanType; }

    /**
     * Returns the type of loan the requester wants.
     * @return value corresponding to loan type from LOAN_TYPES enum.
     */
    public String getLoanType() {
        return this.loanType;
    }
}
