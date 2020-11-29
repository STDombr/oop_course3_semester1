import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;
import parser.DOMParser;
import parser.SAXParser;
import parser.StAXParser;
import tariff.CallPrices;
import tariff.Parameters;
import tariff.Tariff;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    private static List<Tariff> list;

    @BeforeClass
    public static void setUp(){
        Tariff tariff1 = new Tariff("tariff1", "SuperNet Turbo", "Vodafone", 100d,
                new CallPrices(0d, 0d, 0.5d), 0.5d,
                new Parameters(5, 100d, "60 seconds"));
        Tariff tariff2 = new Tariff("tariff2", "SuperNet Start", "Vodafone", 70d,
                new CallPrices(0.5d, 0.5d, 1d), 1d,
                new Parameters(2, 70d, "60 seconds"));
        Tariff tariff3 = new Tariff("tariff3", "SuperNet Pro", "Vodafone", 150d,
                new CallPrices(0d, 0d, 0.5d), 0.5d,
                new Parameters(10, 150d, "60 seconds"));
        Tariff tariff4 = new Tariff("tariff4", "SuperNet Unlim", "Vodafone", 230d,
                new CallPrices(0d, 0d, 0d), 0d,
                new Parameters(20, 230d, "60 seconds"));

        list = new ArrayList<>();
        list.add(tariff2);
        list.add(tariff1);
        list.add(tariff3);
        list.add(tariff4);
    }

    @Test
    public void SAX_TEST(){
        List<Tariff> SAXlist = SAXParser.parse("Tariff.xml");

        Assert.assertEquals(this.list.size(), SAXlist.size());
        for (int i = 0; i < SAXlist.size(); i++){
            Assert.assertEquals(this.list.get(i).getId(), SAXlist.get(i).getId());
            Assert.assertEquals(this.list.get(i).getName(), SAXlist.get(i).getName());
            Assert.assertEquals(this.list.get(i).getPayroll(), SAXlist.get(i).getPayroll());
            Assert.assertEquals(this.list.get(i).getSmsPrice(), SAXlist.get(i).getSmsPrice());
            Assert.assertEquals(this.list.get(i).getOperatorName(), SAXlist.get(i).getOperatorName());
            Assert.assertEquals(this.list.get(i).getCallPrices().getInNetCallPrice(), SAXlist.get(i).getCallPrices().getInNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getOutNetCallPrice(), SAXlist.get(i).getCallPrices().getOutNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getLandlineCallPrice(), SAXlist.get(i).getCallPrices().getLandlineCallPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getConnectionPrice(), SAXlist.get(i).getParameters().getConnectionPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getCountOfFavNumbers(), SAXlist.get(i).getParameters().getCountOfFavNumbers());
            Assert.assertEquals(this.list.get(i).getParameters().getTariffication(), SAXlist.get(i).getParameters().getTariffication());
        }
    }

    @Test
    public void StAX_TEST(){
        List<Tariff> StAXlist = StAXParser.parse("Tariff.xml");

        Assert.assertEquals(this.list.size(), StAXlist.size());
        for (int i = 0; i < StAXlist.size(); i++){
            Assert.assertEquals(this.list.get(i).getId(), StAXlist.get(i).getId());
            Assert.assertEquals(this.list.get(i).getName(), StAXlist.get(i).getName());
            Assert.assertEquals(this.list.get(i).getPayroll(), StAXlist.get(i).getPayroll());
            Assert.assertEquals(this.list.get(i).getSmsPrice(), StAXlist.get(i).getSmsPrice());
            Assert.assertEquals(this.list.get(i).getOperatorName(), StAXlist.get(i).getOperatorName());
            Assert.assertEquals(this.list.get(i).getCallPrices().getInNetCallPrice(), StAXlist.get(i).getCallPrices().getInNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getOutNetCallPrice(), StAXlist.get(i).getCallPrices().getOutNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getLandlineCallPrice(), StAXlist.get(i).getCallPrices().getLandlineCallPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getConnectionPrice(), StAXlist.get(i).getParameters().getConnectionPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getCountOfFavNumbers(), StAXlist.get(i).getParameters().getCountOfFavNumbers());
            Assert.assertEquals(this.list.get(i).getParameters().getTariffication(), StAXlist.get(i).getParameters().getTariffication());
        }
    }

    @Test
    public void DOM_TEST() throws IOException, SAXException, ParserConfigurationException {
        List<Tariff> DOMlist = DOMParser.parse("Tariff.xml");

        Assert.assertEquals(this.list.size(), DOMlist.size());
        for (int i = 0; i < DOMlist.size(); i++){
            Assert.assertEquals(this.list.get(i).getId(), DOMlist.get(i).getId());
            Assert.assertEquals(this.list.get(i).getName(), DOMlist.get(i).getName());
            Assert.assertEquals(this.list.get(i).getPayroll(), DOMlist.get(i).getPayroll());
            Assert.assertEquals(this.list.get(i).getSmsPrice(), DOMlist.get(i).getSmsPrice());
            Assert.assertEquals(this.list.get(i).getOperatorName(), DOMlist.get(i).getOperatorName());
            Assert.assertEquals(this.list.get(i).getCallPrices().getInNetCallPrice(), DOMlist.get(i).getCallPrices().getInNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getOutNetCallPrice(), DOMlist.get(i).getCallPrices().getOutNetCallPrice());
            Assert.assertEquals(this.list.get(i).getCallPrices().getLandlineCallPrice(), DOMlist.get(i).getCallPrices().getLandlineCallPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getConnectionPrice(), DOMlist.get(i).getParameters().getConnectionPrice());
            Assert.assertEquals(this.list.get(i).getParameters().getCountOfFavNumbers(), DOMlist.get(i).getParameters().getCountOfFavNumbers());
            Assert.assertEquals(this.list.get(i).getParameters().getTariffication(), DOMlist.get(i).getParameters().getTariffication());
        }
    }
}
