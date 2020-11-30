import java.util.Scanner;

/**
 * Class of electric devices
 */
public class ElectricDevice implements Comparable<ElectricDevice>{
    private double power;     //power in watts
    public boolean mode;     //device mode (1 - on / 0 - off)

    /**
     * Constructor
     */
    public ElectricDevice() {

        this.power = 0;
        mode = false;
    }

    /**
     * Constructor
     *
     * @param power
     */
    public ElectricDevice(double power) {

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
}
