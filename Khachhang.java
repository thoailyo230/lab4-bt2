import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    protected String id;
    protected String name;
    protected String date;
    protected String type;
    protected double quantity;
    protected double unitPrice;

    public Customer(String id, String name, String date, String type, double quantity, double unitPrice) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double calculateTotal() {
        double totalPrice;

        if (type.equals("Vietnamese")) {
            if (quantity <= unitPrice) {
                totalPrice = quantity * unitPrice;
            } else {
                totalPrice = quantity * unitPrice + (quantity - unitPrice) * 25;
            }
        } else {
            totalPrice = quantity * unitPrice;
        }

        return totalPrice;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Date: " + date + ", Type: " + type + ", Total: " + calculateTotal();
    }
}
