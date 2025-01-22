package VendingMachine;

//vendingMachine.java
import java.util.ArrayList;
import java.util.List;

public class vendingMachine {
 private List<product> products;
 private double insertedAmount;

 public vendingMachine() {
     products = new ArrayList<>();
     insertedAmount = 0.0;
 }

 // Add a product to the vending machine
 public void addProduct(product item) {
     products.add(item);
 }

 // Insert money into the vending machine
 public void insertMoney(double amount) {
     if (amount == 0.25 || amount == 1.0) { // Accept only quarters or $1 bills
         insertedAmount += amount;
         System.out.println("Inserted $" + amount + ". Total: $" + insertedAmount);
     } else {
         System.out.println("Invalid denomination. Only quarters ($0.25) and $1 bills are accepted.");
     }
 }

 // Select a product by name
 public void selectProduct(String productName) {
     for (product item : products) {
         if (item.getName().equalsIgnoreCase(productName)) {
             if (item.getPrice() <= insertedAmount) {
                 if (item.reduceQuantity()) {
                     double change = insertedAmount - item.getPrice();
                     System.out.println("Dispensed: " + item.getName());
                     System.out.println("Change: $" + change);
                     insertedAmount = 0.0;
                 } else {
                     System.out.println("Out of stock.");
                 }
             } else {
                 System.out.println("Insufficient funds. Please insert more money.");
             }
             return;
         }
     }
     System.out.println("Product not found.");
 }

 // Refund the inserted money
 public void refund() {
     System.out.println("Refunding $" + insertedAmount);
     insertedAmount = 0.0;
 }

 // Display available products
 public void displayProducts() {
     System.out.println("Available Products:");
     for (product item : products) {
         System.out.println(item);
     }
 }

 // Main method for testing
 public static void main(String[] args) {
     // Create a vending machine instance
     vendingMachine machine = new vendingMachine();

     // Add products to the vending machine
     machine.addProduct(new product("Coke", 0.75, 10));
     machine.addProduct(new product("Pepsi", 0.75, 8));
     machine.addProduct(new product("Sprite", 0.75, 5));
     machine.addProduct(new product("Chips", 0.75, 7));
     machine.addProduct(new product("Candy", 0.75, 3));
     machine.addProduct(new product("Cookies", 0.75, 2));

     // Display available products
     machine.displayProducts();

     // Simulate customer inserting money
     machine.insertMoney(1.0); // Insert $1
     machine.insertMoney(0.25); // Insert 25 cents

     // Simulate product selection
     machine.selectProduct("Coke"); // Select Coke

     // Display products again to show updated stock
     machine.displayProducts();

     // Try selecting another product with insufficient funds
     machine.selectProduct("Pepsi");

     // Refund remaining balance
     machine.refund();
 }
}
