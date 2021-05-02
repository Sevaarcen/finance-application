package com.cmplxsoftsys.team3.financeapplication.repository;

import com.cmplxsoftsys.team3.financeapplication.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    Optional<Transaction> findById(String id);
    Optional<List<Transaction>> findByUserId(String userId);
    Optional<List<Transaction>> findByLoanId(String loanId);
}
