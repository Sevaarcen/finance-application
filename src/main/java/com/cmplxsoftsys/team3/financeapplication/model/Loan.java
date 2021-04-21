package com.cmplxsoftsys.team3.financeapplication.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.StringJoiner;

/**
 * The loan class is the structure for loans and keeps track of attributes of that loan
 */
public class Loan {
    public enum STATUS {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Id
    private String id;

    private double annualInterestRate;
    private int tenure;
    private double loanAmount;
    private Date loanDate;
    private String loanType;
    private String userId;
    private STATUS applicationStatus;

    public Loan() {

    }

    /**
     * Basic constuctor for instantiating a pending loan (formerly LoanApplication object)
     * @param tenure
     * @param loanAmount
     * @param loanType
     * @param userId
     */
    public Loan(int tenure, double loanAmount, String loanType, String userId) {
        this(0, tenure, loanAmount, loanType, userId, STATUS.PENDING);
    }

    /**
     * Setup a Loan with whatever valaues you desire.
     * @param annualInterestRate
     * @param tenure
     * @param loanAmount
     * @param loanType
     * @param userId
     * @param loanStatus
     */
    public Loan(double annualInterestRate, int tenure, double loanAmount, String loanType, String userId, STATUS loanStatus) {
        this.annualInterestRate = annualInterestRate;
        this.tenure = tenure;
        this.loanAmount = loanAmount;
        this.loanDate = new java.util.Date();
        this.loanType = loanType;
        this.applicationStatus = loanStatus;
        this.loanDate = new Date();
        this.userId = userId;
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return tenure of the loan, in months
     */
    public int getTenure() {
        return this.tenure;
    }

    /**
     * Set a new tenure, in months
     */
    public void setNumberOfYears(int tenure) {
        this.tenure = tenure;
    }

    /**
     * Return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a newloanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12;
        return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), tenure)));
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        return getMonthlyPayment() * tenure;
    }

    /**
     * Return loan date
     */
    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * Returns the type of loan the requester wants.
     *
     * @return value corresponding to loan type from LOAN_TYPES enum.
     */
    public String getLoanType() {
        return this.loanType;
    }

    public String getUserId() {
        return userId;
    }

    public void setApplicationStatus(STATUS applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public STATUS getApplicationStatus() {
        return this.applicationStatus;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Loan.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("annualInterestRate=" + annualInterestRate)
                .add("tenure=" + tenure)
                .add("loanAmount=" + loanAmount)
                .add("loanDate=" + loanDate)
                .add("loanType='" + loanType + "'")
                .add("userId='" + userId + "'")
                .add("applicationStatus=" + applicationStatus)
                .toString();
    }
}
