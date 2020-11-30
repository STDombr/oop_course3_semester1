package consoleMenu;


import devices.electric.ElectricDevice;
import devices.electric.home.*;
import home.Home;
import sql.DataBase;

import javax.swing.*;
import java.util.Scanner;

/**
 * Class of console menu
 */
public class ConsoleMenu {
    private Home home;
    private final Scanner input;          //scanner to read input from System.in

    /**
     * Constructor
     */
    public ConsoleMenu() {
        home = new Home();
        input = new Scanner(System.in);
    }

    /**
     * Function to show some program functions
     */
    public void run(){
        int selection;
        int deviceNumber;

        System.out.println("1 - Show all electric devices at home.");
        System.out.println("2 - Add new device.");
        System.out.println("3 - Add devices from DB.");
        System.out.println("4 - Remove the device.");
        System.out.println("5 - Remove all devices.");
        System.out.println("6 - Turn On / Off the device.");
        System.out.println("7 - Turn On all devices.");
        System.out.println("8 - Turn Off all devices.");
        System.out.println("9 - Show all power consumption at home.");
        System.out.println("10 - Sort electric devices by power.");
        System.out.println("11 - Device search.");
        System.out.println("-1 - Exit.\n");

        while(true){
            System.out.println();
            System.out.print("Select a command: ");

            selection = input.nextInt();

            switch (selection){
                case 1:
                    //Show all electric devices at home
                    home.displayDevices();

                    break;
                case 2:
                    //Add new device
                    addNewDevice();

                    break;
                case 3:
                    //Add devices from DB
                    DataBase.readAllData(getHome().getDevices());

                    break;
                case 4:
                    //Remove the device
                    deviceNumber = selectADevice();

                    if (deviceNumber != -1)
                        if (home.removeDevice(deviceNumber))
                            System.out.println("Device removed.");
                        else
                            System.out.println("No such device at home.");

                    break;
                case 5:
                    //Remove all devices
                    if (home.removeDevices())
                        System.out.println("Devices removed.");
                    else
                        System.out.println("No devices at home.");

                    break;
                case 6:
                    //Turn On / Off the device
                    deviceNumber = selectADevice();

                    if (deviceNumber != -1)
                        if (home.getDevices().get(deviceNumber).getMode())
                            home.getDevices().get(deviceNumber).off();
                        else
                            home.getDevices().get(deviceNumber).on();

                    break;
                case 7:
                    //Turn On all devices
                    if (!home.turnOnAllDevices())
                        System.out.println("No devices at home.");

                    break;
                case 8:
                    //Turn Off all devices
                    if (!home.turnOffAllDevices())
                        System.out.println("No devices at home.");

                    break;
                case 9:
                    //Show all power consumption at home
                    double allpowerConsumption = home.allPowerConsumption();

                    System.out.println("All power consumption at home: " + allpowerConsumption + "W");
                    break;
                case 10:
                    //Sort electric devices by power
                    if (home.sort())
                        System.out.println("Devices sorted from the smallest to the largest power.");
                    else
                        System.out.println("No devices at home.");

                    break;
                case 11:
                    //Device search
                    deviceSearch();

                    break;
                case -1:
                    return;
                default:
                    System.out.println("Error. Select a command.");
            }
        }
    }

    /**
     * Function to select a device
     * @return device number or error(-1)
     */
    private int selectADevice(){
        int count = home.deviceCount();
        int deviceNumber;

        if (count == 0)
        {
            System.out.println("No devices at home.");

            return -1;
        }

        System.out.println("Select a device: ");
        home.displayDevices();
        System.out.println("-1 - Return.");

        deviceNumber = input.nextInt();
        while (deviceNumber < -1 || deviceNumber >= count)
        {
            System.out.println("Error. Invalid input number. Select a device or return.");

            deviceNumber = input.nextInt();
        }

        return deviceNumber;
    }

    /**
     * Function to create and add new Device
     */
    private void addNewDevice(){
        int category;

        System.out.println();
        System.out.println("1 - Fridge.");
        System.out.println("2 - Kettle.");
        System.out.println("3 - Lamp.");
        System.out.println("-1 - Return.");
        System.out.print("Select the device category: ");

        category = input.nextInt();

        while (category < -1 || category > 3 || category == 0)
        {
            System.out.println("Error. Invalid input number. Select the category or return.");

            category = input.nextInt();
        }

        if (category == 1)
        {
            Fridge fridge = new Fridge();

            fridge.createFromConsole();
            home.addDevice((ElectricDevice)fridge);
        }
        else if (category == 2)
        {
            Kettle kettle = new Kettle();

            kettle.createFromConsole();
            home.addDevice((ElectricDevice)kettle);
        }
        else if (category == 3)
        {
            Lamp lamp = new Lamp();

            lamp.createFromConsole();
            home.addDevice((ElectricDevice)lamp);
        }
    }

    /**
     * Function to search and print devices by parameters
     */
    private void deviceSearch(){
        if (home.getDevices().size() <= 0)
        {
            System.out.println("No devices at home.");
            return;
        }

        double min, max;

        System.out.print("Enter the minimum and maximum power: ");

        min = input.nextDouble();
        max = input.nextDouble();

        home.displayDevices(min, max);
    }
    /**
     * home getter
     * @return home
     */
    public Home getHome() {
        return home;
    }

    /**
     * home setter
     * @param home
     */
    public void setHome(Home home) {
        this.home = home;
    }
}
