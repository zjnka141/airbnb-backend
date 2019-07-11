package com.codegym.airbnb.service;

import com.codegym.airbnb.dto.AccountDTO;
import com.codegym.airbnb.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAllByDeletedIsFalse();

    void save(AccountDTO accountDTO);
    AccountDTO findById(Integer id);
    void update(AccountDTO accountDTO);
}
