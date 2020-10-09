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
        System.out.println("Device added.");
    }

    /**
     * Function to remove a device from home
     * @param counter
     */
    public void removeDevice(int counter){
        if ((counter >= 0) && (counter < devices.size()))
        {
            devices.remove(counter);
            System.out.println("Device removed.");
        }
        else
            throw new IllegalArgumentException("No such device at home.");
    }

    /**
     * Function to remove all devices from home
     */
    public void removeDevices(){
        if (devices.size() == 0)
            System.out.println("No devices at home.");
        else
        {
            devices.clear();
            System.out.println("Devices removed.");
        }
    }

    /**
     * Function to turn off all devices in the house
     */
    public void turnOffAllDevices() {
        if (devices.size() == 0)
            System.out.println("No devices at home.");
        else
            for (int i = 0; i < devices.size(); i++)
                devices.get(i).off();
    }

    /**
     * Function to turn on all devices in the house
     */
    public void turnOnAllDevices() {
        if (devices.size() == 0)
            System.out.println("No devices at home.");
        else
            for (int i = 0; i < devices.size(); i++)
                devices.get(i).on();
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
    public void sort() {
        if (devices.size() == 0)
            System.out.println("No devices at home.");
        else{
            Collections.sort(devices);
            System.out.println("Devices sorted from the smallest to the largest power.");
        }
    }

    /**
     * Function to display all devices
     */
    public void displayDevices() {
        for (int i = 0; i < devices.size(); i++){
            System.out.print(i + ". ");
            devices.get(i).display();
        }
    }
}
