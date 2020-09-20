package com.smartsoft.resourceOfCurrencies.model;

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
    @Column(name="id_currency")
    private long id;
    private String numcode;
    private String charcode;
    private int nominal;
    private String name;

    public Currency(String numCode, String charCode, int nominal, String name) {
        this.numcode = numCode;
        this.charcode = charCode;
        this.nominal = nominal;
        this.name = name;
    }

    public String toString(){
        String id = "id = " + this.id + ", ";
        String numcode = "num = " + this.numcode + ", ";
        String charcode = "char = " + this.charcode + ", ";
        String nominal = "nominal = " + this.nominal + ", ";
        String name = "name = " + this.name;
        return id + numcode + charcode + nominal + name;
    }

}