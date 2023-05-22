  import java.util.ArrayList;
import java.util.Scanner;

public class ElectricBillManagement {
    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Electric Bill Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customer Bills");
            System.out.println("3. Calculate Total Quantity for Each Type of Customer");
            System.out.println("4. Calculate Average Total for Foreign Customers");
            System.out.println("5. Display Bills in September 2013");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> displayCustomerBills();
                case 3 -> calculateTotalQuantity();
                case 4 -> calculateAverageTotalForForeignCustomers();
                case 5 -> displayBillsInSeptember2013();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 6);
    }

    private static void addCustomer() {
        System.out.println("Add Customer");
        System.out.println("1. Vietnamese Customer");
        System.out.println("2. Foreign Customer");
        System.out.print("Enter customer type: ");
        int customerType = scanner.nextInt();

        System.out.print("Enter customer ID: ");
        String id = scanner.next();
        System.out.print("Enter customer name: ");
        String name = scanner.next();
        System.out.print("Enter invoice date (yyyy-MM-dd): ");
        String date = scanner.next();
        System.out.print("Enter quantity: ");
        double quantity = scanner.nextDouble();
        System.out.print("Enter unit price: ");
        double unitPrice = scanner.nextDouble();

        if (customerType == 1) {
            System.out.print("Enter threshold: ");
            double threshold = scanner.nextDouble();
            customers.add(new VietnameseCustomer(id, name, date, "Vietnamese", quantity, unitPrice, threshold));
        } else if (customerType == 2) {
            System.out.print("Enter nationality: ");
            String nationality = scanner.next();
            customers.add(new ForeignCustomer(id, name, date, "Foreign", quantity, unitPrice, nationality));
        }

        System.out.println("Customer added successfully!");
    }

    private static void displayCustomerBills() {
        System.out.println("Display Customer Bills");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    private static void calculateTotalQuantity() {
        int vietnameseCustomerCount = 0;
        int foreignCustomerCount = 0;

        for (Customer customer : customers) {
            if (customer.type.equals("Vietnamese")) {
                vietnameseCustomerCount++;
            } else {
                foreignCustomerCount++;
            }
        }

        System.out.println("Total Vietnamese customers: " + vietnameseCustomerCount);
        System.out.println("Total Foreign customers: " + foreignCustomerCount);
    }

    private static void calculateAverageTotalForForeignCustomers() {
        double foreignTotal = 0;
        int foreignCount = 0;

        for (Customer customer : customers) {
            if (customer.type.equals("Foreign")) {
                foreignTotal += customer.calculateTotal();
                foreignCount++;
            }
        }

        if (foreignCount > 0) {
            double foreignAverage = foreignTotal / foreignCount;
            System.out.println("Average total for Foreign customers: " + foreignAverage);
        } else {
            System.out.println("No Foreign customers found.");
        }
    }

    private static void displayBillsfromMay19,2023toMay22,2023() {
        System.out.println("Bills fromMay19,2023toMay22,2023");
        boolean found = false;

        for (Customer customer : customers) {
            if (customer.date.startsWith("fromMay19,2023toMay22,2023")) {
                System.out.println(customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No bills found in September 2013.");
        }
    }
}





