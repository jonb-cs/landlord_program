import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnnualSummary {
    private ArrayList<Expense> expenseRecords;
    private HashMap<String, HashMap<String, Integer>> rentRecords;

    public AnnualSummary() {

    }

    public AnnualSummary(HashMap<String, HashMap<String, Integer>> rentRecords, ArrayList<Expense> expenseRecords) {
        this.expenseRecords = expenseRecords;
        this.rentRecords = rentRecords;

    }

    public int getRentTotal() {
        int totalSum = 0;
        for (Map.Entry<String, HashMap<String, Integer>> entry: rentRecords.entrySet()) {
            int tenantTotal = 0;

            for (Map.Entry<String, Integer> tenantEntry: entry.getValue().entrySet()) {
                tenantTotal += tenantEntry.getValue();
            }

            totalSum += tenantTotal;
        }

        return totalSum;
    }

    public HashMap<String, Integer> getExpense_byCategory() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Expense obj: expenseRecords) {
            if (!hashMap.containsKey(obj.getCategory())) {
                hashMap.put(obj.getCategory(), obj.getPaymentAmount());
            }
            else {
                hashMap.replace(obj.getCategory(), hashMap.get(obj.getCategory()) + obj.getPaymentAmount());
            }
        }

        return hashMap;

    }

    public void displaySummary() {
        System.out.println("    Annual Summary");
        System.out.println("    -----------------");
        System.out.println("    Income:");
        System.out.println("    Rent: " + getRentTotal());
        System.out.println();
        System.out.println("    Expenses: ");
        HashMap<String, Integer> hashMap = getExpense_byCategory();
        int totalExpense = 0;
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            totalExpense += entry.getValue();
        }
        System.out.println("    Total expense: " + totalExpense);
        System.out.println();

        System.out.println("    Profit: " + (getRentTotal() - totalExpense));
    }
}
