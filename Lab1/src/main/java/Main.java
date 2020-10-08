import devices.Device;
import devices.electric.ElectricDevice;
import devices.electric.home.*;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<ElectricDevice> devices= new LinkedList<ElectricDevice>();

        Lamp lamp1 = new Lamp("lamp1", "Samsung", 5, 10);
        Lamp lamp2 = new Lamp("lamp2", "Samsung", 5, 12);

        Kettle kettle1 = new Kettle("kettle1", "LG", 5, 12);

        devices.add(lamp1);
        devices.add(lamp2);
        devices.add(kettle1);

        lamp2.on();

        for (int i = 0; i < devices.size(); i++)
            devices.get(i);
    }
}
