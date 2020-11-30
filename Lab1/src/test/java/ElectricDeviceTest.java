import devices.electric.ElectricDevice;
import devices.electric.home.Fridge;
import devices.electric.home.Kettle;
import devices.electric.home.Lamp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElectricDeviceTest {

    ElectricDevice fridge;
    ElectricDevice kettle;
    ElectricDevice lamp;

    @Before
    public void setUp() {
        fridge = new Fridge("fridge", "samsung", 120d, 391d);
        kettle = new Kettle("kettle", "samsung", 1100d, 2d);
        lamp = new Lamp("lamp", "samsung", 6d, 300d);
    }

    @Test
    public void DeviceTurns_TEST() {
        Assert.assertFalse(fridge.getMode());
        Assert.assertFalse(kettle.getMode());
        Assert.assertFalse(lamp.getMode());

        fridge.off();
        kettle.off();
        lamp.off();

        Assert.assertFalse(fridge.getMode());
        Assert.assertFalse(kettle.getMode());
        Assert.assertFalse(lamp.getMode());

        fridge.on();
        kettle.on();
        lamp.on();

        Assert.assertTrue(fridge.getMode());
        Assert.assertTrue(kettle.getMode());
        Assert.assertTrue(lamp.getMode());

        fridge.on();
        kettle.on();
        lamp.on();

        Assert.assertTrue(fridge.getMode());
        Assert.assertTrue(kettle.getMode());
        Assert.assertTrue(lamp.getMode());
    }

    @Test
    public void powerConsumption_TEST() {
        Assert.assertEquals(fridge.powerConsumption(), 0d, 0.001d);
        Assert.assertEquals(kettle.powerConsumption(), 0d, 0.001d);
        Assert.assertEquals(lamp.powerConsumption(), 0d, 0.001d);

        fridge.on();
        kettle.on();
        lamp.on();

        Assert.assertEquals(fridge.powerConsumption(), 120d, 0.001d);
        Assert.assertEquals(kettle.powerConsumption(), 1100d, 0.001d);
        Assert.assertEquals(lamp.powerConsumption(), 6d, 0.001d);
    }
}
