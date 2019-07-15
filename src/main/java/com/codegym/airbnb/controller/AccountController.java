package com.codegym.airbnb.controller;

import com.codegym.airbnb.dto.AccountDTO;
import com.codegym.airbnb.model.Account;
import com.codegym.airbnb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
        List<Account> accounts;

        accounts = accountService.findAllByDeletedIsFalse();

        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable(value = "id") Integer id) {
        AccountDTO accountDTO = accountService.findById(id);
        return ResponseEntity.ok().body(accountDTO);
    }
    @PutMapping("accounts/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable(value = "id") Integer id,@RequestBody AccountDTO accountDTO){
        accountService.update(accountDTO);
        return ResponseEntity.ok(accountDTO);
    }
}