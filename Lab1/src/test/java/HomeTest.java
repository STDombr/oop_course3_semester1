import devices.electric.ElectricDevice;
import devices.electric.home.Fridge;
import devices.electric.home.Kettle;
import devices.electric.home.Lamp;
import home.Home;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HomeTest {

    Home home;

    @Before
    public void setUp(){
        home = new Home();

        Fridge fridge = new Fridge("fridge", "samsung", 120d, 391d);
        Kettle kettle = new Kettle("kettle", "samsung", 1100d, 2d);
        Lamp lamp = new Lamp("lamp", "samsung", 6d, 300d);

        home.addDevice(fridge);
        home.addDevice(kettle);
        home.addDevice(lamp);
    }

    @Test
    public void removeDevice_TEST(){

        Assert.assertEquals(home.deviceCount(), 3);

        Assert.assertFalse(home.removeDevice(-1));
        Assert.assertFalse(home.removeDevice(10));

        Assert.assertTrue(home.removeDevice(0));
        Assert.assertTrue(home.removeDevice(1));
        Assert.assertTrue(home.removeDevice(0));

        Assert.assertFalse(home.removeDevice(0));

        Assert.assertEquals(home.deviceCount(), 0);
    }

    @Test
    public void removeDevices_TEST(){

        Assert.assertEquals(home.deviceCount(), 3);

        Assert.assertTrue(home.removeDevices());
        Assert.assertFalse(home.removeDevices());

        Assert.assertEquals(home.deviceCount(), 0);
    }

    @Test
    public void devicesPower_TEST(){

        Assert.assertEquals(home.allPowerConsumption(), 0d, 0.001d);
        Assert.assertTrue(home.turnOnAllDevices());
        Assert.assertEquals(home.allPowerConsumption(), 1226d, 0.001d);
        Assert.assertTrue(home.turnOnAllDevices());
        Assert.assertEquals(home.allPowerConsumption(), 1226d, 0.001d);
        Assert.assertTrue(home.turnOffAllDevices());
        Assert.assertEquals(home.allPowerConsumption(), 0d, 0.001d);
        Assert.assertTrue(home.turnOffAllDevices());
        Assert.assertEquals(home.allPowerConsumption(), 0d, 0.001d);

        home.removeDevices();

        Assert.assertEquals(home.allPowerConsumption(), 0d, 0.001d);
        Assert.assertFalse(home.turnOffAllDevices());
        Assert.assertFalse(home.turnOnAllDevices());
    }
}
