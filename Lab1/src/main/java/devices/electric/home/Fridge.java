package devices.electric.home;

import devices.electric.ElectricDevice;

import java.util.Scanner;

/**
 * Class of fridges
 */
public class Fridge extends ElectricDevice {
    private double capacity;

    /**
     * Constructor
     */
    public Fridge() {
        super();

        this.capacity = 0;
    }

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
        System.out.print("Name: " + this.getName() +
                ", company: " + this.getProductionCompany() +
                ", " + this.getPower() + "W" +
                ", capacity: " + capacity + "L" +
                ", mode: ");
        if (this.getMode())
            System.out.println("on.");
        else
            System.out.println("off.");
    }

    /**
     * Function to create device from console
     */
    @Override
    public void createFromConsole(){
        Scanner input = new Scanner(System.in);

        super.createFromConsole();

        System.out.print("Enter capacity: ");
        capacity = input.nextDouble();
    }
}
