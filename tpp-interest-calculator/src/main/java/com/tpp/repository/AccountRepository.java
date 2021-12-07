package com.tpp.repository;

import com.tpp.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByIdentification(long identification);
}
