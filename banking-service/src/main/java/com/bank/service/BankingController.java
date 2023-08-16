package com.bank.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {
    @GetMapping("/balance")
    public String checkBalance() {
        // This is a mock balance check for the purpose of this lab.
        return "Your current balance is $5000.";
    }
}