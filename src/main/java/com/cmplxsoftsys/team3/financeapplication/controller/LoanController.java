package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.response.MessageResponse;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private Logger logger = LoggerFactory.getLogger(LoanController.class);

    private final LoanService loanService;
    private final LoanRepository loanRepository;

    public LoanController(LoanService loanService, LoanRepository loanRepository) {
        this.loanService = loanService;
        this.loanRepository = loanRepository;
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestNewLoan(@Valid @RequestBody LoanApplicationRequest request) {
        loanService.submitLoanApplication(request);
        return ResponseEntity.ok(new MessageResponse("Loan application submitted successfully!"));
    }

    @GetMapping("/byuser/{userID}")
    public List<Loan> findByUser(@PathVariable("userID") String userID) {
        Optional<List<Loan>> allFromUserId = loanRepository.findByUserId(userID);
        if (allFromUserId.isPresent()) {
            List<Loan> loanApplications = allFromUserId.get();
            loanApplications.stream().forEach(loanApplication -> logger.info("Finding loan. userID={} loanApplication={}", userID, loanApplication));
            return loanApplications;
        } else {
            return null;
        }
    }

    @GetMapping("/pending/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Loan> requestAllApplications() {
        Optional<List<Loan>> allPending = loanRepository.findByApplicationStatus(Loan.STATUS.PENDING);
        if(allPending.isPresent()) {
            List<Loan> presentPending = allPending.get();
            return presentPending;
        } else {
            return null;
        }
    }

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> approveLoanApplication(@Valid @RequestBody LoanDecisionRequest decisionRequest, @PathVariable("id") String id) {
        loanService.approveLoan(decisionRequest, id);
        return ResponseEntity.ok(new MessageResponse("Loan application approved successfully!"));
    }

    @PostMapping("/reject/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> rejectLoanApplication(@PathVariable("id") String id) {
        loanService.rejectLoan(id);
        return ResponseEntity.ok(new MessageResponse("Loan application rejected successfully!"));
    }
}
