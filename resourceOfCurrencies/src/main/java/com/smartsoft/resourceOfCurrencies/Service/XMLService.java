package com.smartsoft.resourceOfCurrencies.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.smartsoft.resourceOfCurrencies.model.Valute;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class XMLService {

    public List<Valute> parseValute() {

        List<Valute> listValute = new ArrayList<>();
        
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

                Valute valute = new Valute(numCode, charCode, nominal, name, value);

                listValute.add(valute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listValute;
    }
    
}