import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;


class UserInterfaceTest {

    /**
     * Test for adding a single tenant
     */
    @Test
    public void user_interface_addTenant_test() {

        UserInterface userinterface = new UserInterface();
        userinterface.addTenant("Jane Doe", "1000");
    }

    /**
     * Test displaying a single tenant that has been added
     */
    @Test
    public void user_interface_displayTenat_test() {
        UserInterface userinterface = new UserInterface();
        userinterface.displayTenants("Jane Doe", "1A");
    }

    /**
     * Test adds a tenant and then removes the tenant.
     */
    @Test
    public void user_interface_removeTenat_test() {
        UserInterface userInterface = new UserInterface();
        TenantRecords test_tenant = new TenantRecords();
        test_tenant.addTenant(new Tenant("John Doe", "10B"));
        userInterface.removeTenant(test_tenant, "10B");
    }

    /**
     * Unit test for adding tenants to the systems.
     * Auto-generates 10,000 random tenants and adds them to the tenant record list.
     * Output to terminal shows 2 tenants added, then 1 removed, then 10,000 more added
     * Final count is displayed, should be 10001 tenants, and list of tenants shown in terminal
     */
    @Test
    public void user_interface_tenants_test() {
        TenantRecords tenantRecords = new TenantRecords();
        System.out.println("Displaying empty tenant records list...");
        tenantRecords.displayRecords();
        System.out.println("Adding new tenants...");
        tenantRecords.addTenant(new Tenant("Elmo", "1A"));
        tenantRecords.addTenant(new Tenant("Grover", "1B"));
        tenantRecords.displayRecords();
        System.out.println("Removing tenant in apartment 1B...");
        tenantRecords.removeTenant("1B");
        tenantRecords.displayRecords();
        System.out.println("Adding 10000 more random generated tenants...");
        for(int i = 0; i <10000; i++) {
            String name  = makeRandomString();
            String aptNo = makeRandomString();
            tenantRecords.addTenant(new Tenant(name, aptNo));
        }
        ArrayList<Tenant> test_list = tenantRecords.getTenantRecords();
        System.out.println("Number of tenants recorded: " + test_list.size());
        tenantRecords.displayRecords();
    }

    // My random string function using Java util package UUID.
    // This function is used to preform unit testing
    public static String makeRandomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}