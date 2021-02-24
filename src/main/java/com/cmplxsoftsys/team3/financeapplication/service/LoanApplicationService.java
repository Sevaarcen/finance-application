package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;

public interface LoanApplicationService {
    public void submitLoanApplication(LoanApplicationRequest loanApplicationRequest);
}
