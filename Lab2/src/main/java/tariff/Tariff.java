package tariff;

public class Tariff implements Comparable<Tariff> {
    private String id;
    private String name;
    private String operatorName;
    private Double payroll;
    private CallPrices callPrices;
    private Double smsPrice;
    private Parameters parameters;

    public Tariff() {
        this.id = "";
        this.name = "";
        this.operatorName = "";
        this.payroll = 0d;
        this.callPrices = new CallPrices();
        this.smsPrice = 0d;
        this.parameters = new Parameters();
    }

    public Tariff(String id, String name, String operatorName, Double payroll, CallPrices callPrices, Double smsPrice, Parameters parameters) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrices = callPrices;
        this.smsPrice = smsPrice;
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Double getPayroll() {
        return payroll;
    }

    public void setPayroll(Double payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public Double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(Double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public int compareTo(Tariff o) {
        return payroll.compareTo(o.getPayroll());
    }

    @Override
    public String toString() {
        return "Tariff(" +
                "id=" + '\'' + id + '\'' +
                ", name=" + '\'' + name + '\'' +
                ", operatorName=" + '\'' + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrices" + callPrices +
                ", smsPrice=" + smsPrice +
                ", parameters" + parameters +
                ")" + '\n';
    }
}
