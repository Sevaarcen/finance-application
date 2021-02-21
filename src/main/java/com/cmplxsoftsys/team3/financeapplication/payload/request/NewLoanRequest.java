package com.cmplxsoftsys.team3.financeapplication.payload.request;

/**
 * This class is used to marshall requests for new loans by customers.
 */
public class NewLoanRequest { 

    public enum LOAN_TYPE {
        HOUSE,
        CAR,
        PERSONAL
    }

    private String loanId;
    private String requestor;
    private LOAN_TYPE loanType;
    private int loanTerm;
    private float loanAmount;

    /**
     * Returns the GUID of the loan request for correlation.
     * @return the GUID of the request.
     */
    public String getLoanId() {
        return this.loanId;
    }

    /**
     * Returns the requester of the loan.
     * @return a String containing the username in the request
     */
    public String getRequestor() {
        return this.requestor;
    }

    /**
     * Returns the type of loan the requester wants.
     * @return value corresponding to loan type from LOAN_TYPES enum.
     */
    public LOAN_TYPE loanType() {
        return this.loanType;
    }

    /**
     * Returns the term of the requested loan in months.
     * @return number of months of the loan's term.
     */
    public int getLoanTerm() {
        return this.loanTerm;
    }

    /**
     * Returns the amount of currency in USD of the loan request.
     * @return float of USD of loan amount requested
     */
    public float getLoanAmount() {
        return this.loanAmount;
    }
}
