package com.tpp.repository;

import com.tpp.model.AccountTransaction;
import org.springframework.data.repository.CrudRepository;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Integer> {
}
