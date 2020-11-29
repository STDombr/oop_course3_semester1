import org.xml.sax.SAXException;
import parser.DOMParser;
import parser.SAXParser;
import parser.StAXParser;
import tariff.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        List<Tariff> DOMList = DOMParser.parse("Tariff.xml");
        System.out.println(DOMList.toString());

        System.out.println();

        List<Tariff> StAXList = StAXParser.parse("Tariff.xml");
        System.out.println(StAXList.toString());

        System.out.println();

        List<Tariff> SAXList = SAXParser.parse("Tariff.xml");
        System.out.println(SAXList.toString());

    }
}
