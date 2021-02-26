package com.cmplxsoftsys.team3.financeapplication.repository;

import com.cmplxsoftsys.team3.financeapplication.model.ERole;
import com.cmplxsoftsys.team3.financeapplication.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
