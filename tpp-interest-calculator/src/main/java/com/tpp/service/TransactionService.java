package com.tpp.service;

import com.tpp.model.Account;
import com.tpp.model.AccountTransaction;
import com.tpp.model.Interest;
import com.tpp.repository.AccountRepository;
import com.tpp.repository.AccountTransactionRepository;
import com.tpp.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private InterestRepository interestRepository;

    public void processTransaction(AccountTransaction accountTransaction) {
        switch (accountTransaction.getTransactionType()) {
            case DEBIT:
                processDebitTransaction(accountTransaction);
                break;
            case CREDIT:
                processCreditTransaction(accountTransaction);
                break;
        }
    }

    private void processCreditTransaction(AccountTransaction accountTransaction) {
        Account account = accountRepository.findByIdentification(accountTransaction.getIdentification());
        float balance = account.getBalance();
        Date lastBalanceUpdatedDate = account.getBalanceLastUpdated();
        Date currentDate = new Date();
        long numberOfDays = getNumberOfDays(lastBalanceUpdatedDate, currentDate);
        System.out.println(numberOfDays);
        float interest = getInterestForGivenDays(numberOfDays);
        System.out.println(interest);



        account.setBalance(account.getBalance() + accountTransaction.getAmount());
        accountRepository.save(account);
        accountTransactionRepository.save(accountTransaction);
    }

    private float getInterestForGivenDays(long numberOfDays) {
        float interest = interestRepository.findLatestInterestRate().get(0);
        float oneDayInterest = (interest / 30) * numberOfDays;
    }

    private long getNumberOfDays(Date lastBalanceUpdatedDate, Date currentDate) {
        return currentDate.getTime() - lastBalanceUpdatedDate.getTime();
    }


    @Transactional
    private void processDebitTransaction(AccountTransaction accountTransaction) {
        Account account = accountRepository.findByIdentification(accountTransaction.getIdentification());
        System.out.println(account);
        if(account.getBalance() > accountTransaction.getAmount()) {
            account.setBalance(account.getBalance() - accountTransaction.getAmount());
            accountRepository.save(account);
            accountTransactionRepository.save(accountTransaction);
        } else {
            // insufficient balance
        }
    }
}
