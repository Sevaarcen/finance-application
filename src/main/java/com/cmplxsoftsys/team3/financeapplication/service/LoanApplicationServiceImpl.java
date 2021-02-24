package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.model.LoanApplication;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    @Autowired
    LoanApplicationRepository loanApplicationRepository;

    @Override
    public void submitLoanApplication(LoanApplicationRequest loanApplicationRequest) {
        LoanApplication loanApplication = new LoanApplication(loanApplicationRequest.getType(), loanApplicationRequest.getLoanAmount(), loanApplicationRequest.getUserId());
        loanApplicationRepository.save(loanApplication);
    }
}
