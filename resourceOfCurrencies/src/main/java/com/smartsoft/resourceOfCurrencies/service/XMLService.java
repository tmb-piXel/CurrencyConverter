package com.smartsoft.resourceOfCurrencies.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.smartsoft.resourceOfCurrencies.model.Currency;
import com.smartsoft.resourceOfCurrencies.model.Rate;
import com.smartsoft.resourceOfCurrencies.repository.CurrencyRepository;
import com.smartsoft.resourceOfCurrencies.repository.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class XMLService {

    @Autowired
    CurrencyRepository currencyRerository;

    @Autowired
    RateRepository rateRepository;

    List<Rate> listRate = new ArrayList<>();

    public List<Currency> parseValute() {

        List<Currency> listValute = new ArrayList<>();
        
        try {
            String url = "http://www.cbr.ru/scripts/XML_daily.asp";
            //String url1 = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url);

            document.getDocumentElement().normalize();

            for (int i = 0; i < document.getElementsByTagName("Name").getLength(); i++) {

                short numCode = Short.parseShort(document.getElementsByTagName("NumCode").item(i).getTextContent());
                String charCode = document.getElementsByTagName("CharCode").item(i).getTextContent();
                int nominal = Integer.parseInt(document.getElementsByTagName("Nominal").item(i).getTextContent());
                String name = document.getElementsByTagName("Name").item(i).getTextContent();
                BigDecimal value = new BigDecimal(document.getElementsByTagName("Value").item(i).getTextContent().replace(",", "."));

                Currency currency = new Currency(numCode, charCode, nominal, name);
                Rate rate = new Rate(charCode, value, LocalDate.now());

                currencyRerository.save(currency);
                rateRepository.save(rate);
                listValute.add(currency);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listValute;
    }

    public Currency save (Currency valute) {
        return currencyRerository.save(valute);
    }
    
    public void saveAll (List<Currency> listValute) {
        for(Currency valute : listValute) {
            currencyRerository.save(valute);
        }
    }
    
}