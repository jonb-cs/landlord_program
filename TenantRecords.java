import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.io.Serializable;

public class TenantRecords implements Serializable {
    private ArrayList<Tenant> tenantRecords;

    public TenantRecords() {
        tenantRecords = new ArrayList<>();
    }

    public ArrayList<Tenant> getTenantRecords() {
        return tenantRecords;
    }

    public void addTenant(Tenant newTenant) {
        tenantRecords.add(newTenant);
    }

    public void removeTenant(String apartmentNumber) {
        Predicate<Tenant> condition = tenantObj -> tenantObj.getApartmentNumber().equals(apartmentNumber);

        tenantRecords.removeIf(condition);
    }

    public void displayRecords() {
        Collections.sort(tenantRecords);
        System.out.printf("    %-20s %-10s %n", "Tenant Name", "Apartment No");
        System.out.println("    ------------------------------------");
        for (Tenant tenant: tenantRecords) {
            System.out.printf("    %-20s %-10s %n", tenant.getName(), tenant.getApartmentNumber());
        }
    }
}
