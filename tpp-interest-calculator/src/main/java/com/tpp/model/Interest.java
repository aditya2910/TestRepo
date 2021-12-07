package com.tpp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private float interestRate;
    @Column
    private Date dateEffectiveFrom;

    public Interest() {
    }

    public Interest(float interestRate, Date dateEffectiveFrom) {
        this.interestRate = interestRate;
        this.dateEffectiveFrom = dateEffectiveFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Date getDateEffectiveFrom() {
        return dateEffectiveFrom;
    }

    public void setDateEffectiveFrom(Date dateEffectiveFrom) {
        this.dateEffectiveFrom = dateEffectiveFrom;
    }
}
