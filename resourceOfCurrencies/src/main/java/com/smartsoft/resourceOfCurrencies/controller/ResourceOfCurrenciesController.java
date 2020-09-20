package com.smartsoft.resourceOfCurrencies.controller;

import com.smartsoft.resourceOfCurrencies.model.Currency;
import com.smartsoft.resourceOfCurrencies.service.XMLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  ResourceOfCurrenciesController {

    @Autowired
    private XMLService xmlService;

    @GetMapping("/")
    public String getCurrency() {
        StringBuilder buildResponse = new StringBuilder();

        String htmlStart = "<!doctype html>\n" +
                           "<html>\n" + 
                           "     <head>\n" +
                           "       <meta charset=\"utf-8\">\n" +
                           "       <style>\n" +
                           "        P {\n" +
                           "            line-height: 1px;\n" +
                           "        }\n" +
                           "       </style>\n" +
                           "     </head>\n" +
                           "     <body>\n";

        String htmlEnd   = "     </body>\n" +
                           "</html>";

        buildResponse.append(htmlStart);
        
        for (Currency valute : xmlService.parseValute()) {
            buildResponse.append("\t\t<p>" + valute + "</p>\n");
        }

        buildResponse.append(htmlEnd);
        
        return buildResponse.toString();
    }

}