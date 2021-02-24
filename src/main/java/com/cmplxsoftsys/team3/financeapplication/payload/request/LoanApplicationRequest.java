package com.cmplxsoftsys.team3.financeapplication.payload.request;

import org.springframework.data.annotation.Id;

/**
 * This class is used to marshal requests for new loans by customers.
 */
public class LoanApplicationRequest {

    @Id
    private String loanApplicationId;
    private double loanAmount;
    private String userId;

    private String type;


    /**
     * Returns the requester of the loan.
     * @return a String containing the username in the request
     */
    public String getUserId() {
        return this.userId;
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
    public String getType() {
        return this.type;
    }

}
