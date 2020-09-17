package com.smartsoft.resourceOfCurrencies.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String charcode;
    private BigDecimal value;
    @Column(name="date_add")
    private LocalDate date;

    public Rate(String charcode, BigDecimal value, LocalDate date) {
        this.charcode = charcode;
        this.value = value;
        this.date = date;
    }
    
}