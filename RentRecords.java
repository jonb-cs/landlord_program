import java.lang.reflect.Array;
import java.util.*;
import java.io.Serializable;

public class RentRecords implements  Serializable {
    private HashMap<String, HashMap<String, Integer>> rentRecords;

    public RentRecords() {
        rentRecords = new HashMap<>();

    }

    public void addRent(Rent rent) {
        if (!rentRecords.containsKey(rent.getApartmentNumber())) {
            HashMap<String, Integer> monthPay = new HashMap<>();
            monthPay.put("1", 0); monthPay.put("2", 0); monthPay.put("3", 0);
            monthPay.put("4", 0); monthPay.put("5", 0); monthPay.put("6", 0);
            monthPay.put("7", 0); monthPay.put("8", 0); monthPay.put("9", 0);
            monthPay.put("10", 0); monthPay.put("11", 0); monthPay.put("12", 0);

            rentRecords.put(rent.getApartmentNumber(), monthPay);
            monthPay.replace(rent.getMonth(), rent.getPaymentAmount());
        }

        else {
            rentRecords.get(rent.getApartmentNumber()).replace(rent.getMonth(), rent.getPaymentAmount());
        }
    }

    public void removeApartmentRent(String apartmentNumber) {
        rentRecords.remove(apartmentNumber);
    }

    public HashMap<String, HashMap<String, Integer>> getRentRecords() {
        return rentRecords;
    }

    public void displayRecords() {
        System.out.println("    Current Year: 2021");
        System.out.printf("    %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %n",
                "AptNo", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        System.out.println("    ----------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, HashMap<String, Integer>> entry: rentRecords.entrySet()) {
            System.out.printf("    %-8s", entry.getKey());
            Map<Integer, Integer> temp_Map = new TreeMap<>();

            for (Map.Entry<String, Integer> monthEntry: entry.getValue().entrySet()) {
                temp_Map.put(Integer.parseInt(monthEntry.getKey()), monthEntry.getValue());
            }

            // System.out.println(temp_Map.toString());
            for (Map.Entry<Integer, Integer> displayEntry: temp_Map.entrySet()) {
                System.out.printf(" %-8d", displayEntry.getValue());
            }
            System.out.println();
        }

    }
}
