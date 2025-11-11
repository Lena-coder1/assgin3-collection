package assgin3;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	 Map<Integer, Double> customers = new HashMap<>();
         Map<Integer, Integer> products = new HashMap<>();
         
         String filename = "sales.txt";
         
         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 String[] parts = line.split(",");
                 int customerID = Integer.parseInt(parts[0]);
                 double totalBill = Double.parseDouble(parts[5]) * Double.parseDouble(parts[6]);
                 customers.put(customerID, totalBill);
                 
                 
                 int id = Integer.parseInt(parts[3].trim());
                 int qty = Integer.parseInt(parts[6].trim());
                 products.put(id,qty); 
                
             }
         } catch (IOException e) {
             System.err.println("Error:" + e.getMessage());
         }
         
         System.out.println("---Customer Bills---");
         for (Map.Entry<Integer, Double> customer : customers.entrySet()) {
             System.out.println("Total Bill For Customer ID " + customer.getKey() + ": $" + customer.getValue());
         }
         
         // product management section 
         Scanner input = new Scanner(System.in);
         int choice;

         do {
             System.out.println("\n--- Product Management ---");
             System.out.println("1. Update product quantity");
             System.out.println("2. Add new product");
             System.out.println("3. Exit");
             System.out.print("Enter your choice: ");
             choice = input.nextInt();
             input.nextLine();

             switch (choice) {
                 case 1:
                     System.out.print("Enter product ID to update: ");
                     int productID = input.nextInt();
                     input.nextLine();

                     if (products.containsKey(productID)) {
                         System.out.print("Enter new quantity: ");
                         int newQty = input.nextInt();
                         input.nextLine();
                         int currentQty = products.get(productID);
                         newQty = newQty + currentQty; // this should add the qty entered with the value already in the file
                         products.put(productID, newQty);
                         
                         System.out.println("Product " + productID + " has been updated.");
                     } else {
                         System.out.println("Product ID not found.");
                     }
                     break;

                 case 2:
                     System.out.print("Enter new product ID: ");
                     int newProductID = input.nextInt();
                     input.nextLine();

                     if (products.containsKey(newProductID)) {
                         System.out.println("Product ID already exists.");
                     } else {
                         System.out.print("Enter initial quantity: ");
                         int qty = input.nextInt();
                         input.nextLine();

                         products.put(newProductID, qty); 
                         System.out.println("New product added successfully.");
                     }
                     break;

                 case 3:
                     System.out.println("Exiting the product management...");
                     break;

                 default:
                     System.out.println("Invalid entry. Please try again.");
             }

         } while (choice != 3);

         input.close();

         
         
	
    

    }

}