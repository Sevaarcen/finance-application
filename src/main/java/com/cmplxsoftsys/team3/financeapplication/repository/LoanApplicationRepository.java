package com.cmplxsoftsys.team3.financeapplication.repository;

import com.cmplxsoftsys.team3.financeapplication.model.LoanApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LoanApplicationRepository extends MongoRepository<LoanApplication, String> {
    Optional<List<LoanApplication>> findByUserId(String userId);
}
