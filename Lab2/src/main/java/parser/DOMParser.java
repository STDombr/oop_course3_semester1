package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tariff.CallPrices;
import tariff.Parameters;
import tariff.Tariff;
import validator.Validator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DOMParser {
    public static List<Tariff> parse(String pathXML) throws ParserConfigurationException, IOException, SAXException {
        if (!Validator.validateDocument(pathXML, pathXML.replace("xml", "xsd")))
            return new ArrayList<>();


        List<Tariff> list = new ArrayList<>();

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new File(pathXML));

        NodeList tariffList = document.getElementsByTagName("tariff");
        NodeList callPricesList = document.getElementsByTagName("callPrices");
        NodeList parametersList = document.getElementsByTagName("parameters");


        for (int counter = 0; counter < tariffList.getLength(); counter++) {
            Element temp1 = (Element) tariffList.item(counter);
            Element temp2 = (Element) callPricesList.item(counter);
            Element temp3 = (Element) parametersList.item(counter);

            Tariff tariff = new Tariff();
            CallPrices callPrices = new CallPrices();
            Parameters parameters = new Parameters();

            tariff.setId(temp1.getAttribute("id"));
            tariff.setName(temp1.getElementsByTagName("name").item(0).getTextContent());
            tariff.setOperatorName(temp1.getElementsByTagName("operatorName").item(0).getTextContent());
            tariff.setPayroll(Double.parseDouble(temp1.getElementsByTagName("payroll").item(0).getTextContent()));
            tariff.setSmsPrice(Double.parseDouble(temp1.getElementsByTagName("smsPrice").item(0).getTextContent()));

            callPrices.setInNetCallPrice(Double.parseDouble(temp2.getElementsByTagName("inNetCallPrice").item(0).getTextContent()));
            callPrices.setOutNetCallPrice(Double.parseDouble(temp2.getElementsByTagName("outNetCallPrice").item(0).getTextContent()));
            callPrices.setLandlineCallPrice(Double.parseDouble(temp2.getElementsByTagName("landlineCallPrice").item(0).getTextContent()));

            parameters.setCountOfFavNumbers(Integer.parseInt(temp3.getElementsByTagName("countOfFavNumbers").item(0).getTextContent()));
            parameters.setConnectionPrice(Double.parseDouble(temp3.getElementsByTagName("connectionPrice").item(0).getTextContent()));
            parameters.setTariffication(temp3.getElementsByTagName("tariffication").item(0).getTextContent());

            tariff.setCallPrices(callPrices);
            tariff.setParameters(parameters);

            list.add(tariff);

        }
        Collections.sort(list);

        return list;
    }
}
