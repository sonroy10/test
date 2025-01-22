package VendingMachine;

//product.java
public class product {
 private String name;
 private double price;
 private int quantity;

 public product(String name, double price, int quantity) {
     this.name = name;
     this.price = price;
     this.quantity = quantity;
 }

 // Getters and Setters
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 public int getQuantity() {
     return quantity;
 }

 public void setQuantity(int quantity) {
     this.quantity = quantity;
 }

 // Reduce the quantity of the product
 public boolean reduceQuantity() {
     if (quantity > 0) {
         quantity--;
         return true;
     }
     return false; // Out of stock
 }

 @Override
 public String toString() {
     return name + " (Price: $" + price + ", Quantity: " + quantity + ")";
 }
}
