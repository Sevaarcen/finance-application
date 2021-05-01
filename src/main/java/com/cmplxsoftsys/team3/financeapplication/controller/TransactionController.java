package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.Transaction;
import com.cmplxsoftsys.team3.financeapplication.payload.request.MakeTransactionRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.response.MessageResponse;
import com.cmplxsoftsys.team3.financeapplication.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/make")
    public ResponseEntity<?> makeTransaction(@Valid @ RequestBody MakeTransactionRequest makeTransactionRequest) {
        transactionService.makePayment(makeTransactionRequest);
        return ResponseEntity.ok(new MessageResponse("Transaction successfully made!"));
    }

    @GetMapping("/get/{userId}")
    public List<Transaction> getByUserId(@PathVariable("userId") String userId) {
        return transactionService.viewPaymentsByUser(userId);
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Transaction> getAll() {
        return transactionService.viewAllTransactions();
    }
}
