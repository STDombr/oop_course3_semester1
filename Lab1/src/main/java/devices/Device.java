package devices;

/**
 * Class of devices
 */
public class Device {
    protected String name;              //device name
    protected String productionCompany; //company name

    /**
     * Constructor
     * @param name
     * @param productionCompany
     */
    public Device(String name, String productionCompany) {
        this.name = name;
        this.productionCompany = productionCompany;
    }

    /**
     * name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * company name getter
     * @return company name
     */
    public String getProductionCompany() {
        return productionCompany;
    }

    /**
     * company name setter
     * @param productionCompany
     */
    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    /**
     * Function to display device
     */
    public void display(){
        System.out.println("Device: " + name + ", company: " + productionCompany);
    }
}

