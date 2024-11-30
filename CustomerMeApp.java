import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class CustomerMe {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;

    public CustomerMe(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerMe{" +
                "id=" + id +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class CustomerMeComparator implements Comparator<CustomerMe> {
    @Override
    public int compare(CustomerMe c1, CustomerMe c2) {
        int firstNameCompare = c1.getFirstName().compareTo(c2.getFirstName());
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }

        int lastNameCompare = c1.getLastName().compareTo(c2.getLastName());
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        return Integer.compare(c1.getId(), c2.getId());
    }
}

public class CustomerMeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CustomerMe> customers = new ArrayList<>();

        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numCustomers; i++) {
            System.out.println("Enter details for customer " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            customers.add(new CustomerMe(id, balance, firstName, lastName));
        }

        Collections.sort(customers, new CustomerMeComparator());

        System.out.println("\nSorted Customers:");
        for (CustomerMe customer : customers) {
            System.out.println(customer);
        }

        scanner.close();
    }
}
