package com.smartsoft.resourceOfCurrencies.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smartsoft.resourceOfCurrencies.model.Currency;
import com.smartsoft.resourceOfCurrencies.service.XMLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class  ResourceOfCurrenciesController {

    @Autowired
    private XMLService xmlService;

    @GetMapping("/")
    public String getCurrency() {
        StringBuilder buildResponse = new StringBuilder();
        for (Currency valute : xmlService.parseValute()) {
            buildResponse.append(valute + "\n");
        }
        xmlService.saveAll(xmlService.parseValute());
        return buildResponse.toString();
    }
}