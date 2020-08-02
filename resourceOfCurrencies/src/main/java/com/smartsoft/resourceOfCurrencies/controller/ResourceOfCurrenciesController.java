package com.smartsoft.resourceOfCurrencies.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smartsoft.resourceOfCurrencies.Service.XMLService;
import com.smartsoft.resourceOfCurrencies.model.Valute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class  ResourceOfCurrenciesController {

    @Autowired
    private XMLService xmlService;

    @GetMapping("/")
    public String getCurrency() {
        StringBuilder buildResponse = new StringBuilder();
        for (Valute valute : xmlService.parseValute()) {
            buildResponse.append(valute + "\n");
        }
        return buildResponse.toString();
    }
}