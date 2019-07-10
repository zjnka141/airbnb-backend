package com.codegym.airbnb.controller;

import com.codegym.airbnb.dto.AccountDTO;
import com.codegym.airbnb.model.Account;
import com.codegym.airbnb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AppController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccounts(@RequestBody AccountDTO accountDTO) {
        accountService.save(accountDTO);
        return ResponseEntity.ok(accountDTO);
    }
}
