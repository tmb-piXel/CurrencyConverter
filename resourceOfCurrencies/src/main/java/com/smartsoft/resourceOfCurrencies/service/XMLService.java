package com.smartsoft.resourceOfCurrencies.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.smartsoft.resourceOfCurrencies.model.Currency;
import com.smartsoft.resourceOfCurrencies.repository.ValuteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class XMLService {

    @Autowired
    ValuteRepository valuteRepository;

    public List<Currency> parseValute() {

        List<Currency> listValute = new ArrayList<>();
        
        try {
            String url = "http://www.cbr.ru/scripts/XML_daily.asp";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url);

            document.getDocumentElement().normalize();

            for (int i = 0; i < document.getElementsByTagName("Name").getLength(); i++) {

                int numCode = Integer.parseInt(document.getElementsByTagName("NumCode").item(i).getTextContent());
                String charCode = document.getElementsByTagName("CharCode").item(i).getTextContent();
                short nominal = Short.parseShort(document.getElementsByTagName("Nominal").item(i).getTextContent());
                String name = document.getElementsByTagName("Name").item(i).getTextContent();
                BigDecimal value = new BigDecimal(document.getElementsByTagName("Value").item(i).getTextContent().replace(",", "."));

                Currency valute = new Currency(numCode, charCode, nominal, name, value);

                listValute.add(valute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listValute;
    }

    public Currency save (Currency valute) {
        return valuteRepository.save(valute);
    }
    
    public void saveAll (List<Currency> listValute) {
        for(Currency valute : listValute) {
            valuteRepository.save(valute);
        }
    }
    
}