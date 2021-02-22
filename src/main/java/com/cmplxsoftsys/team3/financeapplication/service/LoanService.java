package com.cmplxsoftsys.team3.financeapplication.service;

import org.springframework.http.ResponseEntity;

/**
 * This is an interface that handles the verification of loan contents and conversion of monetary values to USD.
 */
public interface LoanService {

    /**
     * Returns an HTTP verification status
     * @return status
     */
    public ResponseEntity<?> verifyLoanContents();

    /**
     * Returns an HTTP conversion status
     * @return status
     */
    public ResponseEntity<?> convertToUSD();

}
