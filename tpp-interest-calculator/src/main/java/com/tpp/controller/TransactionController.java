package com.tpp.controller;

import com.tpp.model.AccountTransaction;
import com.tpp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/debit")
    public void debitTransaction(@RequestBody AccountTransaction accountTransaction) {
        transactionService.processTransaction(accountTransaction);
    }

    @PostMapping("/credit")
    public void creditTransaction(@RequestBody AccountTransaction accountTransaction) {
        transactionService.processTransaction(accountTransaction);
    }
}
