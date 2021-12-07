package com.tpp.repository;

import com.tpp.model.Interest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InterestRepository extends CrudRepository<Interest, Integer> {
    @Query("select interestRate from Interest order by dateEffectiveFrom DESC")
    List<Float> findLatestInterestRate();
}
