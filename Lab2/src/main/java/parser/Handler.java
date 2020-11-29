package parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import tariff.CallPrices;
import tariff.Parameters;
import tariff.Tariff;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {
    private final List<Tariff> list;
    private Tariff tariff;
    private CallPrices callPrices;
    private Parameters parameters;
    private int counter;

    public Handler() {
        list = new ArrayList<>();
        counter = 0;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (qName) {
            case "tariff":
                tariff = new Tariff();
                callPrices = new CallPrices();
                parameters = new Parameters();
                tariff.setId(attrs.getValue(0));
                break;
            case "name":
                counter = 1;
                break;
            case "operatorName":
                counter = 2;
                break;
            case "payroll":
                counter = 3;
                break;
            case "inNetCallPrice":
                counter = 4;
                break;
            case "outNetCallPrice":
                counter = 5;
                break;
            case "landlineCallPrice":
                counter = 6;
                break;
            case "smsPrice":
                counter = 7;
                break;
            case "countOfFavNumbers":
                counter = 8;
                break;
            case "connectionPrice":
                counter = 9;
                break;
            case "tariffication":
                counter = 10;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals("tariff")) {
            tariff.setCallPrices(callPrices);
            tariff.setParameters(parameters);
            list.add(tariff);
        }
    }

    @Override
    public void characters(char[] ch, int offset, int length) {
        String s = new String(ch, offset, length);

        try {
            switch (counter) {
                case 1:
                    tariff.setName(s);
                    break;
                case 2:
                    tariff.setOperatorName(s);
                    break;
                case 3:
                    tariff.setPayroll(Double.parseDouble(s));
                    break;
                case 4:
                    callPrices.setInNetCallPrice(Double.parseDouble(s));
                    break;
                case 5:
                    callPrices.setOutNetCallPrice(Double.parseDouble(s));
                    break;
                case 6:
                    callPrices.setLandlineCallPrice(Double.parseDouble(s));
                    break;
                case 7:
                    tariff.setSmsPrice(Double.parseDouble(s));
                    break;
                case 8:
                    parameters.setCountOfFavNumbers(Integer.parseInt(s));
                    break;
                case 9:
                    parameters.setConnectionPrice(Double.parseDouble(s));
                    break;
                case 10:
                    parameters.setTariffication(s);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        counter = 0;
    }

    public List<Tariff> getList() {
        return list;
    }
}
