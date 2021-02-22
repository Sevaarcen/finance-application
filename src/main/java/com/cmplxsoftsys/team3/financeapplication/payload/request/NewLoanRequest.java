package com.cmplxsoftsys.team3.financeapplication.payload.request;

import com.cmplxsoftsys.team3.financeapplication.model.Loan.LOAN_TYPE;;

/**
 * This class is used to marshal requests for new loans by customers.
 */
public class NewLoanRequest { 

    private String loanId;
    private String requestor;
    private LOAN_TYPE loanType;
    private int loanTerm;
    private double loanAmount;

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
     * Returns the term of the requested loan in months.
     * @return number of months of the loan's term.
     */
    public int getLoanTerm() {
        return this.loanTerm;
    }

    /**
     * Returns the amount of currency in USD of the loan request.
     * @return amount of USD being requested
     */
    public double getLoanAmount() {
        return this.loanAmount;
    }

    /**
     * Returns the loan type being requested by the customer.
     * @return the type of loan.
     */
    public LOAN_TYPE getLoanType() {
        return this.loanType;
    }
}
