package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.response.MessageResponse;
import com.cmplxsoftsys.team3.financeapplication.service.LoanApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This class is used to connect the loan model class to its respective interface.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/loan")
public class LoanController {
    private final LoanApplicationService loanApplicationService;

    public LoanController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestNewLoan(@Valid @RequestBody LoanApplicationRequest request) {
        loanApplicationService.submitLoanApplication(request);
        return ResponseEntity.ok(new MessageResponse("Loan application submitted successfully!"));
    }
}
