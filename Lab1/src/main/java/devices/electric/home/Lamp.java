package devices.electric.home;

import devices.electric.ElectricDevice;

/**
 * Class of lamps
 */
public class Lamp extends ElectricDevice {
    protected double luminousFlux;

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
        System.out.print("Name: " + name +
                ", company: " + productionCompany +
                ", " + power + "W" +
                ", " + luminousFlux + "Lm" +
                ", mode: ");
        if (mode)
            System.out.println("on.");
        else
            System.out.println("off.");
    }
}
