package com.codegym.airbnb.controller;

import com.codegym.airbnb.dto.AccountDTO;
import com.codegym.airbnb.model.Account;
import com.codegym.airbnb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/accounts")
public class AppController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<?> createAccounts(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        accountService.save(accountDTO);
        return ResponseEntity.ok(accountDTO);
    }
}
