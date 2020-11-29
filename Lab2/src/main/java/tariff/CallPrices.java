package tariff;

public class CallPrices {
    private Double inNetCallPrice;      //дзвінки в мережі
    private Double outNetCallPrice;     //дзвінки не в мережі
    private Double landlineCallPrice;   //дзвінки на стаціонарні телефони

    public CallPrices() {
        this.inNetCallPrice = 0d;
        this.outNetCallPrice = 0d;
        this.landlineCallPrice = 0d;
    }

    public CallPrices(Double inNetCallPrice, Double outNetCallPrice, Double landlineCallPrice) {
        this.inNetCallPrice = inNetCallPrice;
        this.outNetCallPrice = outNetCallPrice;
        this.landlineCallPrice = landlineCallPrice;
    }

    public Double getInNetCallPrice() {
        return inNetCallPrice;
    }

    public void setInNetCallPrice(Double inNetCallPrice) {
        this.inNetCallPrice = inNetCallPrice;
    }

    public Double getOutNetCallPrice() {
        return outNetCallPrice;
    }

    public void setOutNetCallPrice(Double outNetCallPrice) {
        this.outNetCallPrice = outNetCallPrice;
    }

    public Double getLandlineCallPrice() {
        return landlineCallPrice;
    }

    public void setLandlineCallPrice(Double landlineCallPrice) {
        this.landlineCallPrice = landlineCallPrice;
    }

    @Override
    public String toString() {
        return "(" + "inNetCallPrice=" + inNetCallPrice +
                ", outNetCallPrice=" + outNetCallPrice +
                ", landlineCallPrice=" + landlineCallPrice + ")";
    }
}
