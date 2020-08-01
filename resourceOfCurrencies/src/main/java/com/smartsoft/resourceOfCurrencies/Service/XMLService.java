package com.smartsoft.resourceOfCurrencies.Service;

import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.smartsoft.resourceOfCurrencies.model.Valute;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class XMLService {

    public String parseValute() {

        Valute valute = null;

        String test = "";
        
        try {
            String url = "http://www.cbr.ru/scripts/XML_daily.asp";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url);

            document.getDocumentElement().normalize();

            int numCode = Integer.parseInt(document.getElementsByTagName("NumCode").item(1).getTextContent());

            test += document.getElementsByTagName("NumCode").item(1).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
    
}