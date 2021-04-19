package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class is a service which implements the LoanService class
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Override
    public void submitLoanApplication(LoanApplicationRequest loanApplicationRequest) {
        Loan loanApplication = new Loan(loanApplicationRequest.getTenure(), loanApplicationRequest.getAmount(), loanApplicationRequest.getType(), loanApplicationRequest.getUserId());
        loanRepository.save(loanApplication);
    }

    /**
     * Returns an HTTP verification status
     *
     * @return status
     */
    @Override
    public ResponseEntity<?> verifyLoanContents() {
        return null;
    }

    /**
     * Returns an HTTP conversion status
     *
     * @return status
     */
    @Override
    public ResponseEntity<?> convertToUSD() {
        return null;
    }

    @Override
    public ResponseEntity<?> submitLoanApplication() {
        return null;
    }

    @Override
    public ResponseEntity<?> getLoansForAccount() {
        return null;
    }

    @Override
    public ResponseEntity<?> getLoanApplicationStatus() {
        return null;
    }
}
