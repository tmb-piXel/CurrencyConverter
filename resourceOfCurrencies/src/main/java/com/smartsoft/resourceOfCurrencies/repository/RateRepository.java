package com.smartsoft.resourceOfCurrencies.repository;

import com.smartsoft.resourceOfCurrencies.model.Rate;

import org.springframework.data.repository.CrudRepository;

public interface RateRepository extends CrudRepository<Rate, Long>{ }