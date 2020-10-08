package home;

import devices.electric.ElectricDevice;

import java.util.LinkedList;
import java.util.List;

public class Home {
    private List<ElectricDevice> devices;

    /**
     * Constructor
     */
    public Home() {
        this.devices = new LinkedList<ElectricDevice>();
    }

    /**
     * Function to add device
     *
     * @param device
     */
    void addDevice(ElectricDevice device) {
        devices.add(device);
    }

    /**
     * Function to turn off all devices in the house
     */
    void turnOffAllDevices() {
        for (int i = 0; i < devices.size(); i++)
            devices.get(i).off();
    }

    /**
     * Function to calc all power consumption in the house
     *
     * @return
     */
    double allPowerConsumption() {
        double power = 0;

        for (int i = 0; i < devices.size(); i++)
            power += devices.get(i).powerConsumption();

        return power;
    }

    /**
     * devices getter
     *
     * @return devices
     */
    public List<ElectricDevice> getDevices() {
        return devices;
    }

    /**
     * devices setter
     *
     * @param devices
     */
    public void setDevices(List<ElectricDevice> devices) {
        this.devices = devices;
    }
}
