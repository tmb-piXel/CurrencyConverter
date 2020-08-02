package com.smartsoft.resourceOfCurrencies.model;

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
    private long id;
    private short numcode;
    private String charcode;
    private short nominal;
    private String name;

    public Currency(short numCode, String charCode, short nominal, String name) {
        this.numcode = numCode;
        this.charcode = charCode;
        this.nominal = nominal;
        this.name = name;
    }

}