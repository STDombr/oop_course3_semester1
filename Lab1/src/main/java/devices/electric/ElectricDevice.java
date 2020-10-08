package devices.electric;

import devices.Device;

/**
 * Class of electric devices
 */
public class ElectricDevice extends Device {
    protected double power;     //power in watts
    protected boolean mode;     //device mode (1 - on / 0 - off)

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

    /**
     * Function to display electric device
     */
    @Override
    public void display() {
        System.out.print("Name: " + name +
                ", company: " + productionCompany +
                ", " + power + "W" +
                ", mode: ");
        if (mode)
            System.out.println("on.");
        else
            System.out.println("off.");
    }
}
