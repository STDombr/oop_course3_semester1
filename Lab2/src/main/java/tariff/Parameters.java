package tariff;

public class Parameters {
    private Integer countOfFavNumbers;     //кількість любимих номерів
    private Double connectionPrice;      //плата за підключення
    private String tariffication;   //тарифікація

    public Parameters() {
        this.countOfFavNumbers = 0;
        this.connectionPrice = 0d;
        this.tariffication = "";
    }

    public Parameters(Integer countOfFavNumbers, Double connectionPrice, String tariffication) {
        this.countOfFavNumbers = countOfFavNumbers;
        this.connectionPrice = connectionPrice;
        this.tariffication = tariffication;
    }

    public Integer getCountOfFavNumbers() {
        return countOfFavNumbers;
    }

    public void setCountOfFavNumbers(Integer countOfFavNumbers) {
        this.countOfFavNumbers = countOfFavNumbers;
    }

    public Double getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(Double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public String getTariffication() {
        return tariffication;
    }

    public void setTariffication(String tariffication) {
        this.tariffication = tariffication;
    }

    @Override
    public String toString() {
        return "(" + "countOfFavNumbers=" + countOfFavNumbers +
                ", connectionPrice=" + connectionPrice +
                ", tariffication=" + tariffication + ")";
    }
}
