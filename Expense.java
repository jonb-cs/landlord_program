import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Expense implements Comparable<Expense>, Serializable {
    private LocalDate date;
    private String category;
    private String payee;
    private int paymentAmount;

    public Expense() {

    }

    public Expense(String date, String category, String payee, int paymentAmount) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.category = category;
        this.payee = payee;
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getPayee() {
        return payee;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public int compareTo(Expense expense) {
        if (date.compareTo(expense.date) == 0) {
            return 0;
        }
        else if (date.compareTo(expense.date) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
