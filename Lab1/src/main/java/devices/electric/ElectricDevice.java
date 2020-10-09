package devices.electric;

import devices.Device;

import java.util.Scanner;

/**
 * Class of electric devices
 */
public class ElectricDevice extends Device implements Comparable<ElectricDevice>{
    private double power;     //power in watts
    private boolean mode;     //device mode (1 - on / 0 - off)

    /**
     * Constructor
     */
    public ElectricDevice() {
        super();

        this.power = 0;
        mode = false;
    }

    /**
     * Constructor
     *
     * @param name
     * @param productionCompany
     * @param power
     */
    public ElectricDevice(String name, String productionCompany, double power) {
        super(name, productionCompany);

        if (power >= 0)
            this.power = power;
        else
            this.power = 0;

        mode = false;
    }

    /**
     * Function to turn on the device
     */
    public void on() {
        mode = true;
    }

    /**
     * Function to turn off the device
     */
    public void off() {
        mode = false;
    }

    /**
     * Function to get the power consumption of the device
     *
     * @return power consumption
     */
    public double powerConsumption() {
        if (mode)
            return power;
        else
            return 0;
    }

    /**
     * power getter
     *
     * @return power
     */
    public double getPower() {
        return power;
    }

    /**
     * power setter
     *
     * @param power
     */
    public void setPower(double power) {
        if (power < 0)
            throw new IllegalArgumentException("Power can't be negative!");
        else
            this.power = power;
    }

    public boolean getMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    /**
     * Function to display electric device
     */
    @Override
    public void display() {
        System.out.print("Name: " + this.getName() +
                ", company: " + this.getProductionCompany() +
                ", " + power + "W" +
                ", mode: ");
        if (mode)
            System.out.println("on.");
        else
            System.out.println("off.");
    }

    /**
     * Overloading method compare
     * @param temp
     * @return result of compare
     */
    @Override
    public int compareTo(ElectricDevice temp) {
        if (this.power < temp.getPower())
            return -1;
        else if (this.power > temp.getPower())
            return 1;

        return 0;
    }

    /**
     * Function to create device from console
     */
    @Override
    public void createFromConsole(){
        Scanner input = new Scanner(System.in);

        super.createFromConsole();

        System.out.print("Enter power value: ");
        power = input.nextDouble();
    }
}
