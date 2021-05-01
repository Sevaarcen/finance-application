package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;


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

    @Override
    public void approveLoan(@Valid LoanDecisionRequest decisionRequest, String id) {
        Loan toBeApproved = loanRepository.findById(id).orElse(null);
        if (toBeApproved != null) {
            toBeApproved.setApplicationStatus(Loan.STATUS.APPROVED);
            toBeApproved.setAnnualInterestRate(decisionRequest.getAnnualInterestRate());
            loanRepository.save(toBeApproved);
        }
    }

    @Override
    public void rejectLoan(String id) {
        Loan toBeRejected = loanRepository.findById(id).orElse(null);
        if (toBeRejected != null) {
            toBeRejected.setApplicationStatus(Loan.STATUS.REJECTED);
            loanRepository.save(toBeRejected);
        }
    }
}
