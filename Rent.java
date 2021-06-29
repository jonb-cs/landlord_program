import java.io.Serializable;

public class Rent implements Serializable {
    private String apartmentNumber;
    private String month;
    private int paymentAmount;

    public Rent() {

    }

    public Rent(String apartmentNumber, String month, int paymentAmount) {
        this.apartmentNumber = apartmentNumber;
        this.month = month;
        this.paymentAmount = paymentAmount;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getMonth() {
        return month;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
