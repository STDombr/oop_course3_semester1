package devices.electric.home;

import devices.electric.ElectricDevice;

import java.util.Scanner;

/**
 * Class of lamps
 */
public class Lamp extends ElectricDevice {
    private double luminousFlux;

    /**
     * Constructor
     */
    public Lamp() {
        super();

        this.luminousFlux = 0;
    }

    /**
     * Constructor
     *
     * @param name
     * @param productionCompany
     * @param power
     */
    public Lamp(String name, String productionCompany, double power, double luminousFlux) {
        super(name, productionCompany, power);

        if (luminousFlux >= 0)
            this.luminousFlux = luminousFlux;
        else
            this.luminousFlux = 0;
    }

    /**
     * luminous flux getter
     *
     * @return luminous flux
     */
    public double getLuminousFlux() {
        return luminousFlux;
    }

    /**
     * luminous flux setter
     *
     * @param luminousFlux
     */
    public void setLuminousFlux(double luminousFlux) {
        if (luminousFlux < 0)
            throw new IllegalArgumentException("Luminous flux can't be negative!");
        else
            this.luminousFlux = luminousFlux;
    }

    /**
     * Function to display lamps
     */
    @Override
    public void display() {
        System.out.print("Name: " + this.getName() +
                ", company: " + this.getProductionCompany() +
                ", " + this.getPower() + "W" +
                ", " + luminousFlux + "Lm" +
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

        System.out.print("Enter luminous flux value: ");
        luminousFlux = input.nextDouble();
    }
}
