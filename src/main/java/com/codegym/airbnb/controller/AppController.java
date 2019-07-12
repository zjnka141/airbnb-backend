package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Account;
import com.codegym.airbnb.security.JwtResponse;
import com.codegym.airbnb.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AppController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping("/test")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Welcome to my website", HttpStatus.OK);
    }
    @GetMapping("/admin/test")
    public ResponseEntity<?> sayAdmin() {
        return new ResponseEntity<>("Welcome admin to my website", HttpStatus.OK);
    }
    @GetMapping("/operator/test")
    public ResponseEntity<?> sayUser() {
        return new ResponseEntity<>("Welcome operator to my website", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken=jwtTokenProvider.generateToken(authentication);
        UserDetails userDetails =(UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>( new JwtResponse(jwtToken,userDetails.getUsername(),userDetails.getAuthorities()),HttpStatus.OK);
    }
}
