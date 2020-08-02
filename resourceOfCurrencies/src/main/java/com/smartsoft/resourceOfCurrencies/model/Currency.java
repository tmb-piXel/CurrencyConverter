package com.smartsoft.resourceOfCurrencies.model;

import java.math.BigDecimal;

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
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numcode")
    private int numCode;
    @Column(name = "charcode")
    private String charCode;
    private short nominal;
    private String name;
    private BigDecimal value;

    public Currency(int numCode, String charCode, short nominal, String name, BigDecimal value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

}