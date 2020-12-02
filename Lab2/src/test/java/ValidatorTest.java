import org.junit.Assert;
import org.junit.Test;
import validator.Validator;

public class ValidatorTest {

    @Test
    public void validator_TEST(){
        Assert.assertTrue(Validator.validateDocument("Tariff.xml", "Tariff.xsd"));

        String pathXML = new String("Tariff.xml");
        Assert.assertTrue(Validator.validateDocument(pathXML, pathXML.replace("xml", "xsd")));

        Assert.assertFalse(Validator.validateDocument("False.xml", "Tariff.xsd"));
        Assert.assertFalse(Validator.validateDocument("Tariff.xml", "False.xsd"));
        Assert.assertFalse(Validator.validateDocument("False.xml", "False.xsd"));

        Assert.assertFalse(Validator.validateDocument("Tariff1.xml", "Tariff.xsd"));
    }
}
