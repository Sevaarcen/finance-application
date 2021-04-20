package com.cmplxsoftsys.team3.financeapplication.repository;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends MongoRepository<Loan, String> {
    Optional<List<Loan>> findByUserId(String userId);
    Optional<List<Loan>> findByApplicationStatus(Loan.STATUS status);
}
