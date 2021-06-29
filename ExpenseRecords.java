import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.function.Predicate;
import java.io.Serializable;

public class ExpenseRecords implements Serializable {
    private ArrayList<Expense> expenseRecords;

    public ExpenseRecords() {
        expenseRecords = new ArrayList<>();
    }

    public void addExpense(Expense newExpense) {
        expenseRecords.add(newExpense);
    }

    public void removeExpense(String dateString, String category, String payee) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        Predicate<Expense> condition = expense -> expense.getDate().compareTo(date) == 0
                && expense.getCategory().equals(category) && expense.getPayee().equals(payee);

        expenseRecords.removeIf(condition);
    }

    public ArrayList<Expense> getExpenseRecords() {
        return expenseRecords;
    }

    public void displayRecords() {
        Collections.sort(expenseRecords);
        System.out.printf("    %-15s %-15s %-25s %-20s %n", "Date", "Category", "Payee", "Amount");
        System.out.println("    ------------------------------------------------------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        for (Expense obj: expenseRecords) {
            System.out.printf("    %-15s %-15s %-25s %-20d %n", obj.getDate().format(formatter), obj.getCategory(), obj.getPayee(), obj.getPaymentAmount());
        }
    }
}
