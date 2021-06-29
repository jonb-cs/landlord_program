import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.*;

public class UserInterface {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String mainInput = "0";

        UserLogin login = new UserLogin();
        TenantRecords tenantRecords = new TenantRecords();
        RentRecords rentRecords = new RentRecords();
        ExpenseRecords expenseRecords = new ExpenseRecords();

        /**
         Using Java deserialization to add values from tenants_list, Expenses_list
         in src to ArrayList tenantRecords.
         */
        try
        {
            FileInputStream fis = new FileInputStream("tenants_list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tenantRecords = (TenantRecords) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            FileOutputStream fos= new FileOutputStream("tenants_list.ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(tenantRecords);
            oos.close();
            fos.close();
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        try
        {
            FileInputStream fis = new FileInputStream("expenses_list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            expenseRecords = (ExpenseRecords) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            FileOutputStream fos= new FileOutputStream("expenses_list.ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(expenseRecords);
            oos.close();
            fos.close();
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        try
        {
            FileInputStream fis = new FileInputStream("rents_list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            rentRecords = (RentRecords) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            FileOutputStream fos= new FileOutputStream("rents_list.ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(rentRecords);
            oos.close();
            fos.close();
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        // while loop for the main menu
        // will keep looping if user enters incorrect username or password
        while (!mainInput.equals("2")) {
            System.out.println("*** Welcome to the Program ***");
            System.out.println("1. Login");
            System.out.println("2. Quit");
            System.out.print("What do you want to do?: ");
            mainInput = scanner.nextLine();

            if (mainInput.equals("1")) {

                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                // boolean that checks whether the username and password exists
                boolean exists = login.verify(username, password);

                if (exists) {
                    System.out.println("*** Successfully logged in ***");
                    String optionInput = "0";

                    // while loop for the options menu
                    while (!optionInput.equals("e")) {
                        System.out.println();
                        System.out.println("*** Options Menu ***");
                        System.out.println("a. Tenant Records");
                        System.out.println("b. Rent Records");
                        System.out.println("c. Expense Records");
                        System.out.println("d. Annual Summary");
                        System.out.println("e. Quit");
                        System.out.print("Choose option: ");
                        optionInput = scanner.nextLine();

                        // if user wants to access Tenant Records
                        if (optionInput.equals("a")) {
                            String tenantInput = "0";

                            // while loop for the Tenant Records Menu
                            while (!tenantInput.equals("4")) {
                                System.out.println();
                                System.out.println("    *** Tenant Records ***");
                                System.out.println("    1. Add new tenant");
                                System.out.println("    2. Remove tenant");
                                System.out.println("    3. Display tenant record");
                                System.out.println("    4. Go back to options");
                                System.out.print("    Choose action: ");
                                tenantInput = scanner.nextLine();

                                // Add new Tenant
                                if (tenantInput.equals("1")) {
                                    System.out.print("    Enter tenant name: ");
                                    String tenantName = scanner.nextLine();
                                    System.out.print("    Enter apartment number: ");
                                    String aptNo = scanner.nextLine();

                                    tenantRecords.addTenant(new Tenant(tenantName, aptNo));
                                }

                                // Remove tenant
                                else if (tenantInput.equals("2")) {
                                    System.out.print("    Enter the apartment number to remove: ");
                                    String apartmentNumber = scanner.nextLine();

                                    tenantRecords.removeTenant(apartmentNumber);
                                }

                                // Display tenant records
                                else if (tenantInput.equals("3")){
                                    tenantRecords.displayRecords();
                                }

                                // Go back to options menu
                                else if (tenantInput.equals("4")) {
                                    ;
                                }
                            }
                        }

                        // if user wants to access Rent Records
                        else if (optionInput.equals("b")) {
                            String rentInput = "0";

                            // while loop for the Rent Records Menu
                            while (!rentInput.equals("4")) {
                                System.out.println();
                                System.out.println("    *** Rent Records ***");
                                System.out.println("    1. Add new rent");
                                System.out.println("    2. Remove rent");
                                System.out.println("    3. Display rent record");
                                System.out.println("    4. Go back to options");
                                System.out.print("    Choose action: ");
                                rentInput = scanner.nextLine();


                                // Add new Rent
                                if (rentInput.equals("1")) {
                                    System.out.print("    Enter apartment number: ");
                                    String apartmentNumber = scanner.nextLine();
                                    System.out.print("    Enter the month(1 - 12): ");
                                    String month = scanner.nextLine();
                                    System.out.print("    Enter the payment amount: ");
                                    int payment = scanner.nextInt();
                                    scanner.nextLine();

                                    rentRecords.addRent(new Rent(apartmentNumber, month, payment));

                                }

                                // Remove rent
                                else if (rentInput.equals("2")) {
                                    System.out.print("    Enter the apartment number to remove Rent for: ");
                                    String aptNo = scanner.nextLine();

                                    rentRecords.removeApartmentRent(aptNo);
                                }

                                // Display rent records
                                else if (rentInput.equals("3")) {
                                    rentRecords.displayRecords();
                                }

                                // Go back to options menu
                                else if (rentInput.equals("4")) {
                                    ;
                                }
                            }
                        }

                        // Expense Records
                        else if (optionInput.equals("c")) {
                            String expenseInput = "0";

                            // while loop for the Expense Records Menu
                            while (!expenseInput.equals("4")) {
                                System.out.println();
                                System.out.println("    *** Expense Records ***");
                                System.out.println("    1. Add new expense");
                                System.out.println("    2. Remove expense");
                                System.out.println("    3. Display expense record");
                                System.out.println("    4. Go back to options");
                                System.out.print("    Choose action: ");
                                expenseInput = scanner.nextLine();

                                // Add new Expense
                                if (expenseInput.equals("1")) {
                                    System.out.print("    Enter the date in this format (MM-DD-YYYY): ");
                                    String date = scanner.nextLine();

                                    System.out.print("    Enter the expense category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("    Enter the payee: ");
                                    String payee = scanner.nextLine();

                                    System.out.print("    Enter the payment amount: ");
                                    int payment = scanner.nextInt();
                                    scanner.nextLine();

                                    expenseRecords.addExpense(
                                            new Expense(date, category, payee, payment)
                                    );

                                }

                                // remove Expense
                                else if (expenseInput.equals("2")) {
                                    System.out.print("    Enter the date in the format (MM-DD-YYYY): ");
                                    String date = scanner.nextLine();

                                    System.out.print("    Enter the expense category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("    Enter the payee: ");
                                    String payee = scanner.nextLine();

                                    expenseRecords.removeExpense(date, category, payee);
                                }

                                // Display expense records
                                else if (expenseInput.equals("3")) {
                                    expenseRecords.displayRecords();
                                }

                                // Go back to the options menu
                                else if (expenseInput.equals("4")){
                                    ;
                                }
                            }
                        }

                        // Annual Summary
                        else if (optionInput.equals("d")) {
                            String annualInput = "0";

                            // while loop for the Annual Summary Menu
                            while (!annualInput.equals("2")) {
                                System.out.println();
                                System.out.println("    *** Annual Summary ***");
                                System.out.println("    1. Display annual summary");
                                System.out.println("    2. Go back to options");
                                System.out.print("    Choose action: ");
                                annualInput = scanner.nextLine();

                                // Display annual summary
                                if (annualInput.equals("1")) {
                                    AnnualSummary annualSummary = new AnnualSummary(rentRecords.getRentRecords(),
                                            expenseRecords.getExpenseRecords());

                                    annualSummary.displaySummary();
                                }

                                // Go back to the options menu
                                else if (annualInput.equals("2")) {
                                    ;
                                }
                            }
                        }

                        // Quit
                        else if (optionInput.equals("e")) {
                            // if the user enters "Quit" from the options,
                            // exit the program entirely

                            /**
                             * Using java serializable to output ArrayList tenantRecords to a file.
                             */
                            try{
                                FileOutputStream fos= new FileOutputStream("tenants_list.ser");
                                ObjectOutputStream oos= new ObjectOutputStream(fos);
                                oos.writeObject(tenantRecords);
                                oos.close();
                                fos.close();
                            }catch(IOException ioe){
                                ioe.printStackTrace();
                            }
                            try{
                                FileOutputStream fos= new FileOutputStream("expenses_list.ser");
                                ObjectOutputStream oos= new ObjectOutputStream(fos);
                                oos.writeObject(expenseRecords);
                                oos.close();
                                fos.close();
                            }catch(IOException ioe){
                                ioe.printStackTrace();
                            }
                            try{
                                FileOutputStream fos= new FileOutputStream("rents_list.ser");
                                ObjectOutputStream oos= new ObjectOutputStream(fos);
                                oos.writeObject(rentRecords);
                                oos.close();
                                fos.close();
                            }catch(IOException ioe){
                                ioe.printStackTrace();
                            }

                            System.exit(0);
                        }
                    }
                }

                else {
                    System.out.println("The username and/or password was incorrect.");
                }
            }

            else if (mainInput.equals("2")) {
                ;
            }
        }
    }

    /**
     * Functions used to test UI class
     */
    public void addTenant(String name, String aptNo) {
        TenantRecords tenantRecords = new TenantRecords();
        tenantRecords.addTenant(new Tenant(name, aptNo));
    }

    public void displayTenants(String name, String aptNo) {
        TenantRecords tenantRecords = new TenantRecords();
        tenantRecords.addTenant(new Tenant(name, aptNo));
        tenantRecords.displayRecords();
    }

    public void removeTenant(TenantRecords tenantRecords, String aptNo) {
        tenantRecords.removeTenant(aptNo);
    }

}
