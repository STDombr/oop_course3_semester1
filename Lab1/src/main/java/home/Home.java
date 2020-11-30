package home;

import devices.electric.ElectricDevice;

import java.util.Collections;
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
     * Constructor with devices
     */
    public Home(List<ElectricDevice> devices) {
        this.devices = new LinkedList<ElectricDevice>();

        this.devices = devices;
    }

    /**
     * Function to add device
     *
     * @param device
     */
    public void addDevice(ElectricDevice device) {
        devices.add(device);
    }

    /**
     * Function to remove a device from home
     * @param counter
     */
    public boolean removeDevice(int counter){
        if ((counter >= 0) && (counter < devices.size()))
        {
            devices.remove(counter);

            return true;
        }

        return false;
    }

    /**
     * Function to remove all devices from home
     */
    public boolean removeDevices(){
        if (devices.size() == 0)
            return false;
        else
        {
            devices.clear();

            return true;
        }
    }

    /**
     * Function to turn off all devices in the house
     */
    public boolean turnOffAllDevices() {
        if (devices.size() == 0)
            return false;
        else
            for (int i = 0; i < devices.size(); i++)
                devices.get(i).off();

        return true;
    }

    /**
     * Function to turn on all devices in the house
     */
    public boolean turnOnAllDevices() {
        if (devices.size() == 0)
            return false;
        else
            for (int i = 0; i < devices.size(); i++)
                devices.get(i).on();

        return true;
    }

    /**
     * Function to calc all power consumption in the house
     *
     * @return
     */
    public double allPowerConsumption() {
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
     * Function to get count of devices
     * @return count
     */
    public int deviceCount(){
        return devices.size();
    }
    /**
     * devices setter
     *
     * @param devices
     */
    public void setDevices(List<ElectricDevice> devices) {
        this.devices = devices;
    }

    /**
     * Function to sort all devices from the smallest to the largest power
     */
    public boolean sort() {
        if (devices.size() == 0)
            return false;
        else
            Collections.sort(devices);

        return true;
    }

    /**
     * Function to display all devices
     */
    public void displayDevices() {
        if (devices.size() == 0)
            System.out.println("No devices at home.");
        else
            for (int i = 0; i < devices.size(); i++){
                System.out.print(i + ". ");
                devices.get(i).display();
            }
    }

    /**
     * Function to display devices with a specific power
     */
    public void displayDevices(double minPower, double maxPower) {
        for (int i = 0; i < devices.size(); i++)
            if (devices.get(i).getPower() >= minPower && devices.get(i).getPower() <= maxPower) {
                System.out.print(i + ". ");
                devices.get(i).display();
            }
    }
}
