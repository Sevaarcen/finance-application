package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.model.Transaction;
import com.cmplxsoftsys.team3.financeapplication.payload.request.MakeTransactionRequest;

import java.util.List;

public interface TransactionService {
    public void makePayment(MakeTransactionRequest makePaymentRequest);
    public List<Transaction> viewPaymentsByUser(String userId);
    public List<Transaction> viewAllTransactions();
    public List<Transaction> viewPaymentsByLoan(String loanId);
}
