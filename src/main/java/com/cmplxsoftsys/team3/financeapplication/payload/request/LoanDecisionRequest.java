package com.cmplxsoftsys.team3.financeapplication.payload.request;

/**
 * This class is used to marshal requests from employees and update a loan request.
 */
public class LoanDecisionRequest {

    /**
     * An enum containing all possible decisions a loan officer is able to make.
     */
    public enum LOAN_DECISION {
        PENDING,
        DENIED,
        ACCEPTED
    }

    private String loanId;
    private LOAN_DECISION decision;


    /**
     * Returns the GUID of the loan request for correlation.
     *
     * @return the GUID of the request.
     */
    public String getLoanId() {
        return this.loanId;
    }

    /**
     * Gets the decision about the loan.
     *
     * @return value for the decision corresponding to the LOAN_DECISION enum.
     */
    public LOAN_DECISION getDecision() {
        return this.decision;
    }

}
