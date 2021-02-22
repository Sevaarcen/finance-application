package com.cmplxsoftsys.team3.financeapplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class is a service which implements the LoanService class
 */
@Service
public class LoanServiceImpl implements LoanService {

    /**
     * Returns an HTTP verification status
     * @return status
     */
    @Override
    public ResponseEntity<?> verifyLoanContents() {
        return null;
    }

    /**
     * Returns an HTTP conversion status
     * @return status
     */
    @Override
    public ResponseEntity<?> convertToUSD() {
        return null;
    }
}
