package parser;

import org.xml.sax.SAXException;
import tariff.Tariff;
import validator.Validator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SAXParser {
    public static List<Tariff> parse(String pathXML) {
        if (!Validator.validateDocument(pathXML, pathXML.replace("xml", "xsd")))
            return new ArrayList<>();

        List<Tariff> list = new ArrayList<>();
        try {
            javax.xml.parsers.SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            Handler handler = new Handler();
            parser.parse(pathXML, handler);

            list = handler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(list);

        return list;
    }
}
