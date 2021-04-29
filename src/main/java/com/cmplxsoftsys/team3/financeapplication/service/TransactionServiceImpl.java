package com.cmplxsoftsys.team3.financeapplication.service;

import com.cmplxsoftsys.team3.financeapplication.model.Transaction;
import com.cmplxsoftsys.team3.financeapplication.payload.request.MakeTransactionRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void makePayment(MakeTransactionRequest makeTransactionRequest) {
        Transaction transaction = new Transaction(makeTransactionRequest.getUserId(), makeTransactionRequest.getValue());
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> viewPaymentsByUser(String userId) {
        Optional<List<Transaction>> byUserId = transactionRepository.findByUserId(userId);
        if (byUserId.isPresent()) {
            List<Transaction> transactions = byUserId.get();
            return transactions;
        } else {
            return null;
        }
    }

    @Override
    public List<Transaction> viewAllTransactions() {
        return transactionRepository.findAll();
    }
}
