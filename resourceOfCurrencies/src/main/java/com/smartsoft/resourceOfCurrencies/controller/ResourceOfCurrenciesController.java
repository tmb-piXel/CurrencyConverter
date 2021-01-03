package com.smartsoft.resourceOfCurrencies.controller;

import com.smartsoft.resourceOfCurrencies.model.Currency;
import com.smartsoft.resourceOfCurrencies.service.XMLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResourceOfCurrenciesController{

    @Autowired
    private XMLService xmlService;

    @GetMapping("/currency")
    public String currencyPageHtml(Model model){
        model.addAttribute("valutes", xmlService.parseValute());
        return "currencyPage";
    }

    @GetMapping("/")
    public String startPageHtml(){
        return "startPage";
    }

}