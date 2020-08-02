package com.smartsoft.resourceOfCurrencies.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Currency
 */
public class Valute {

    private int id;
    private int numCode;
    private String charCode;
    private short nominal;
    private String name;
    private BigDecimal value;


    public Valute() {
    }

    public Valute(int numCode, String charCode, short nominal, String name, BigDecimal value) {
        this.id = 1;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCode() {
        return this.numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return this.charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public short getNominal() {
        return this.nominal;
    }

    public void setNominal(short nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Valute id(int id) {
        this.id = id;
        return this;
    }

    public Valute numCode(int numCode) {
        this.numCode = numCode;
        return this;
    }

    public Valute charCode(String charCode) {
        this.charCode = charCode;
        return this;
    }

    public Valute nominal(short nominal) {
        this.nominal = nominal;
        return this;
    }

    public Valute name(String name) {
        this.name = name;
        return this;
    }

    public Valute value(BigDecimal value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Valute)) {
            return false;
        }
        Valute valute = (Valute) o;
        return Objects.equals(id, valute.id) && numCode == valute.numCode && Objects.equals(charCode, valute.charCode) && nominal == valute.nominal && Objects.equals(name, valute.name) && Objects.equals(value, valute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numCode, charCode, nominal, name, value);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numCode='" + getNumCode() + "'" +
            ", charCode='" + getCharCode() + "'" +
            ", nominal='" + getNominal() + "'" +
            ", name='" + getName() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    
    
}