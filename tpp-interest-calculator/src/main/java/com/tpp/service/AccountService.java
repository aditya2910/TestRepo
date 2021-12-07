package com.tpp.service;

import com.tpp.model.Account;
import com.tpp.model.Interest;
import com.tpp.repository.AccountRepository;
import com.tpp.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private InterestRepository interestRepository;

    public void processAccountOpening(Account account) {
        account.setBalanceLastUpdated(new Date());
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    public void setInterestRate(float interestRate) {
        interestRepository.save(new Interest(interestRate, new Date()));
    }

    public float getInterestRate() {
        List<Float> interestRates = interestRepository.findLatestInterestRate();
        return interestRates.get(0);
    }
}
