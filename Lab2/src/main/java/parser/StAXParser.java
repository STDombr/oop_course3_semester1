package parser;

import org.xml.sax.SAXException;
import tariff.CallPrices;
import tariff.Parameters;
import tariff.Tariff;
import validator.Validator;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StAXParser {
    public static List<Tariff> parse(String pathXML) {
        if (!Validator.validateDocument(pathXML, pathXML.replace("xml", "xsd")))
            return new ArrayList<>();

        List<Tariff> list = new ArrayList<>();
        Tariff tariff = new Tariff();
        CallPrices callPrices = new CallPrices();
        Parameters parameters = new Parameters();

        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(pathXML));

            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "tariff":
                            tariff = new Tariff();
                            callPrices = new CallPrices();
                            parameters = new Parameters();
                            tariff.setId(startElement.getAttributeByName(new QName("id")).getValue());

                            break;
                        case "name":
                            xmlEvent = reader.nextEvent();
                            tariff.setName(xmlEvent.asCharacters().getData());

                            break;
                        case "operatorName":
                            xmlEvent = reader.nextEvent();
                            tariff.setOperatorName(xmlEvent.asCharacters().getData());

                            break;
                        case "payroll":
                            xmlEvent = reader.nextEvent();
                            tariff.setPayroll(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "inNetCallPrice":
                            xmlEvent = reader.nextEvent();
                            callPrices.setInNetCallPrice(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "outNetCallPrice":
                            xmlEvent = reader.nextEvent();
                            callPrices.setOutNetCallPrice(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "landlineCallPrice":
                            xmlEvent = reader.nextEvent();
                            callPrices.setLandlineCallPrice(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "smsPrice":
                            xmlEvent = reader.nextEvent();
                            tariff.setSmsPrice(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "countOfFavNumbers":
                            xmlEvent = reader.nextEvent();
                            parameters.setCountOfFavNumbers(Integer.parseInt(xmlEvent.asCharacters().getData()));

                            break;
                        case "connectionPrice":
                            xmlEvent = reader.nextEvent();
                            parameters.setConnectionPrice(Double.parseDouble(xmlEvent.asCharacters().getData()));

                            break;
                        case "tariffication":
                            xmlEvent = reader.nextEvent();
                            parameters.setTariffication(xmlEvent.asCharacters().getData());

                            break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    if (xmlEvent.asEndElement().getName().getLocalPart().equals("tariff")) {
                        tariff.setCallPrices(callPrices);
                        tariff.setParameters(parameters);
                        list.add(tariff);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        Collections.sort(list);

        return list;
    }
}
