package com.codegym.airbnb.repository;

import com.codegym.airbnb.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAllByDeletedIsFalse();
}
