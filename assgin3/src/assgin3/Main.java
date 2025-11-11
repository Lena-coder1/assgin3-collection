package assgin3;
import java.io.*;
import java.util.*;

class Products { 
    private Map<Integer,Integer> products; 
    public Products() {
        products = new HashMap<>(); 
    }
    
    public void ProductManagement(int productID, int qty) {
    	if (products.containsKey(productID)) {
    		products.put(productID, products.getOrDefault(productID, 0) + qty);
    	}else { 
    		products.put(productID, qty);
    	}
    }
    
   
    public Map<Integer, Integer> getProductsMap() {
        return products;
    }
}

class Customers { 
	private Map< Integer,Double> customers; 
	public Customers() { 
		customers = new HashMap<>();
		
	}
	
	public void CustomerManagement(int customerID, double price, int qty) {
		double priceTotal = price * qty;
        customers.put(customerID, customers.getOrDefault(customerID, 0.0) + priceTotal);
	}
	public Map<Integer,Double> getCustomerMap(){
		return customers;
	}
}



public class Main {
    public static void main(String[] args) {
        Customers customers = new Customers();
    	Products products = new Products();
    	String filename = "sales.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); 
                int customerID = Integer.parseInt(parts[0].trim());
                double price = Double.parseDouble(parts[5].trim());
                
                int productID = Integer.parseInt(parts[3].trim());
                int qty = Integer.parseInt(parts[6].trim());
                
                customers.CustomerManagement(customerID, price, qty);
                products.ProductManagement(productID, qty);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("--- Customer Bills ---");
        for (Map.Entry<Integer, Double> entry : customers.getCustomerMap().entrySet()) {
            System.out.println("Customer ID " + entry.getKey() + ": $" + entry.getValue());
        }

       
        System.out.println("--- Product Totals ---");
        for (Map.Entry<Integer, Integer> entry : products.getProductsMap().entrySet()) { 
            System.out.println("Product ID " + entry.getKey() + ": Total Quantity " + entry.getValue()); 
        }
    }
}
