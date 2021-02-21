package com.cmplxsoftsys.team3.financeapplication.model;

import java.util.Date;

public class Loan {
    
    /**
     * All the possible types of loans that may be regulated differently.
     */
    public enum LOAN_TYPE {
        HOUSE,
        CAR,
        PERSONAL
    }

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    private LOAN_TYPE loanType;
    
    /** Default constructor */
    public Loan() {
        this(7.5, 30, 100000);
    }
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
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

    /**
     * Returns the type of loan the requester wants.
     * @return value corresponding to loan type from LOAN_TYPES enum.
     */
    public LOAN_TYPE loanType() {
        return this.loanType;
    }
}
