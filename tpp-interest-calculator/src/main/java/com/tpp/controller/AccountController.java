package com.tpp.controller;

import com.tpp.model.Account;
import com.tpp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/add")
    public void processAccountOpening(@RequestBody Account account) {
        service.processAccountOpening(account);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PostMapping("/interestRate")
    public void setInterestRate(@RequestParam("value") float interestRate) {
        service.setInterestRate(interestRate);
    }

    @GetMapping("/interestRate")
    public float getInterestRate() {
        return service.getInterestRate();
    }


    @PutMapping
    public void processAccountEndOfDayBalances() {

    }
}
