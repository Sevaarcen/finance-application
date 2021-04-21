package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.response.MessageResponse;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    LoanService loanService;

    @Autowired
    LoanRepository loanRepository;


    @PostMapping("/request")
    public ResponseEntity<?> requestNewLoan(@Valid @RequestBody LoanApplicationRequest request) {
        loanService.submitLoanApplication(request);
        return ResponseEntity.ok(new MessageResponse("Loan application submitted successfully!"));
    }

    @GetMapping("/byuser/{userID}")
    public ResponseEntity<?> findByUser(@PathVariable("userID") String userID) {
        Optional<List<Loan>> allFromUserId = loanRepository.findByUserId(userID);
        if (allFromUserId.isPresent()) {
            List<Loan> loanApplications = allFromUserId.get();
            loanApplications.stream().forEach(loanApplication -> logger.info(loanApplication.toString()));
            return new ResponseEntity<>(loanApplications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not find loans for given userid", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pending/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> requestAllApplications() {
        Optional<List<Loan>> allPending = loanRepository.findByApplicationStatus(Loan.STATUS.PENDING);
        if(allPending.isPresent()) {
            List<Loan> presentPending = allPending.get();
            return new ResponseEntity<>(presentPending, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("LoanRepository returning nothing", HttpStatus.NOT_FOUND);
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
