package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;

import org.springframework.http.ResponseEntity;

/**
 * This is an interface that handles the verification of loan contents and conversion of monetary values to USD.
 */
public interface LoanService {

    public void submitLoanApplication(LoanApplicationRequest loanApplicationRequest);
    public void approveLoan(String id);
    public void rejectLoan(String id);

    /**
     * Returns an HTTP verification status
     *
     * @return status
     */
    public ResponseEntity<?> verifyLoanContents();

    /**
     * Returns an HTTP conversion status
     *
     * @return status
     */
    public ResponseEntity<?> convertToUSD();

    /**
     * Returns an HTTP conversion status
     *
     * @return status
     */
    public ResponseEntity<?> submitLoanApplication();

    /**
     * Returns an HTTP conversion status
     *
     * @return status
     */
    public ResponseEntity<?> getLoansForAccount();

    /**
     * Returns an HTTP conversion status
     *
     * @return status
     */
    public ResponseEntity<?> getLoanApplicationStatus();


}
