package com.smartsoft.resourceOfCurrencies.repository;

import com.smartsoft.resourceOfCurrencies.model.Currency;

import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {}