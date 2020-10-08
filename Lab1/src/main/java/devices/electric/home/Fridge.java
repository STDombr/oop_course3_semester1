package devices.electric.home;

import devices.electric.ElectricDevice;

/**
 * Class of fridges
 */
public class Fridge extends ElectricDevice {
    protected double capacity;

    /**
     * Constructor
     *
     * @param name
     * @param productionCompany
     * @param power
     */
    public Fridge(String name, String productionCompany, double power, double capacity) {
        super(name, productionCompany, power);

        if (capacity >= 0)
            this.capacity = capacity;
        else
            this.capacity = 0;
    }

    /**
     * capacity getter
     *
     * @return capacity
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * capacity setter
     *
     * @param capacity
     */
    public void setCapacity(double capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity can't be negative!");
        else
            this.capacity = capacity;
    }

    /**
     * Function to display fridge
     */
    @Override
    public void display() {
        System.out.print("Name: " + name +
                ", company: " + productionCompany +
                ", " + power + "W" +
                ", capacity: " + capacity + "L" +
                ", mode: ");
        if (mode)
            System.out.println("on.");
        else
            System.out.println("off.");
    }
}
