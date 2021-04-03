package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.LoanApplication;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.response.MessageResponse;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanApplicationRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanApplicationService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * This class is used to connect the loan model class to its respective interface.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/loan")
public class LoanController {
    private final LoanApplicationService loanApplicationService;
    private Logger logger = LoggerFactory.getLogger(LoanController.class);

    private final LoanApplicationRepository loanApplicationRepository;

    public LoanController(LoanApplicationService loanApplicationService, LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationService = loanApplicationService;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestNewLoan(@Valid @RequestBody LoanApplicationRequest request) {
        loanApplicationService.submitLoanApplication(request);
        return ResponseEntity.ok(new MessageResponse("Loan application submitted successfully!"));
    }

    @GetMapping("/byuser/{userId}")
    public String findByUser(@PathVariable("userId") String userId) {
        Optional<List<LoanApplication>> allFromUserId = loanApplicationRepository.findByUserId(userId);
        if (allFromUserId.isPresent()) {
            List<LoanApplication> loanApplications = allFromUserId.get();
            loanApplications.stream().forEach(loanApplication -> logger.info(loanApplication.toString()));
            return loanApplications.toString();
        } else {
            return null;
        }
    }
}
