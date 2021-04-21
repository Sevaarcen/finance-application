package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;

import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;

/**
 * This is an interface that handles the verification of loan contents and conversion of monetary values to USD.
 */
public interface LoanService {

    public void submitLoanApplication(LoanApplicationRequest loanApplicationRequest);
    public void approveLoan(LoanDecisionRequest loanDecisionRequest, String id);
    public void rejectLoan(String id);

}
