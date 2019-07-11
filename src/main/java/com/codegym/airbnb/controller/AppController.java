package com.codegym.airbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AppController {
    @GetMapping("")
    @ResponseBody
    public String index(){
        return "Hello world";
    }
    @GetMapping("/user")
    @ResponseBody
    public String user(Principal principal){
        return "Hello user:"+principal.getName();
    }
}