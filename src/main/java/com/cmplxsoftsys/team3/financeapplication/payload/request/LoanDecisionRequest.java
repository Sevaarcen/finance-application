package com.cmplxsoftsys.team3.financeapplication.payload.request;

/**
 * This class is used to marshal requests from employees and update a loan request.
 */
public class LoanDecisionRequest {

    private double annualInterestRate;

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}
