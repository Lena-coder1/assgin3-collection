package assgin3;
import java.io.*;
import java.util.*;

class Products {
    private Map<Integer, Integer> products; 

    public Products(Map<Integer, Integer> products) {
        this.products = products;
    }

    public void run() {
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
                        System.out.print("Enter quantity to add: ");
                        int addQty = input.nextInt();
                        input.nextLine();

                        int newQty = products.get(productID) + addQty;
                        products.put(productID, newQty);

                        System.out.println("Product " + productID + " updated. New total quantity: " + newQty);
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
                    System.out.println("Exiting product management...");
                    break;

                default:
                    System.out.println("Invalid entry. Please try again.");
            }

        } while (choice != 3);
        
        input.close();
    }
    
}

public class Main {
    public static void main(String[] args) {
        Map<Integer, Double> customers = new HashMap<>();
        Map<Integer, Integer> products = new HashMap<>();
        String filename = "sales.txt";

        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int customerID = Integer.parseInt(parts[0].trim());
                double price = Double.parseDouble(parts[5].trim());
                
                int productID = Integer.parseInt(parts[3].trim());
                int qty = Integer.parseInt(parts[6].trim());

                customers.put(customerID, customers.getOrDefault(customerID, 0.0) + (price * qty));
                products.put(productID, products.getOrDefault(productID, 0) + qty);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        
        Products productInfo = new Products(products);
        productInfo.run();
        
        
        System.out.println("--- Customer Bills ---");
        for (Map.Entry<Integer, Double> entry : customers.entrySet()) {
            System.out.println("Customer ID " + entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("--- Product Totals ---");
        for (Map.Entry<Integer, Integer> entry : products.entrySet()) {
            System.out.println("Product ID " + entry.getKey() + ": Total Quantity " + entry.getValue());
        }
        
        
    }
}
