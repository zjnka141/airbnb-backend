package com.codegym.airbnb.service.impl;

import com.codegym.airbnb.dto.AccountDTO;
import com.codegym.airbnb.model.Account;
import com.codegym.airbnb.repository.AccountRepository;
import com.codegym.airbnb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> findAllByDeletedIsFalse() {
        return accountRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(AccountDTO accountDTO) {
        Account account = new Account();
        account.setFullName(accountDTO.getFullName());
        account.setAge(accountDTO.getAge());
        account.setAddress(accountDTO.getAddress());
        account.setDeleted(Boolean.FALSE);
        account.setEmail(accountDTO.getEmail());
        account.setGender(accountDTO.getGender());
        account.setPhone(accountDTO.getPhone());
        account.setUsername(accountDTO.getUsername());
        account.setPassword(accountDTO.getPassword());
        accountRepository.save(account);
    }
}
