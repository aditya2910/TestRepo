package com.tpp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String bsb;
    @Column(unique=true)
    private long identification;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date openingDate;
    @Column
    private float balance;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date balanceLastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getBalanceLastUpdated() {
        return balanceLastUpdated;
    }

    public void setBalanceLastUpdated(Date balanceLastUpdated) {
        this.balanceLastUpdated = balanceLastUpdated;
    }
}
