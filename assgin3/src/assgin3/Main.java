package assgin3;
import java.io.File;
import java.util.*;

class Products{
    private Map<Integer, Integer> products;
	public Products() {
        products = new HashMap<>();
	}
        public void run(Scanner input) {
        	int choice;
        	File file = new File("Sales.txt");
        	
        	Set<Integer> sales = new HashSet<>();
        	if (file.exists()) {
        		try(Scanner fileScanner = new Scanner(file)){
        			while (fileScanner.hasNextLine()) {
        				String line = fileScanner.nextLine();
        				String[] parts = line.split(","); 
        				int id = Integer.parseInt(parts[3].trim());
        				sales.add(id);
        				}
        		}catch(Exception e) {
        			
        			System.out.println("error reading sales.txt file,  " + e.getMessage());
        		}
        	}
            do {
                System.out.println("\n--- Prodcut Management ---");
                System.out.println("1. update product");
                System.out.println("2. add new product");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                input.nextLine(); 

                switch (choice) {
                case 1: 
                	System.out.println(" Please enter product code: ");
                	int productID= input.nextInt(); 
                	input.nextLine(); 
                	if(products.containsKey(productID) || sales.contains(productID)) {
                		System.out.println("please enter new quantity: ");
                		int qty = input.nextInt(); 
                		input.nextLine();
                		products.put(productID,qty); 
                		System.out.println("product " + productID + " ,has been update");
                		            			
                	}else { 
                		System.out.println("product ID not found.");
                		
                	}
                	break;
                	
                case 2:
                	System.out.println("Please enter the new product code:");
                	int newProductID = input.nextInt();
                	input.nextLine();
                	if(products.containsKey(newProductID) || sales.contains(newProductID)) {
                		System.out.println("Product ID already exists "); 
                		
                	}else {
                		
                		System.out.print("Enter quantity: ");
                		int qty= input.nextInt(); 
                		input.nextLine();
                		
                		products.put(newProductID, qty); 
                		System.out.println("new product has been added"); 
                		
                		
                	}break; 
                	
                case 3: 
                	System.out.println("Exiting the product managament"); 
                	break; 
                	
                default: 
                	System.out.println("Invalid entery"); 
                	
                	
                }
               
                   
            }while(choice !=3);
            


	}
}

public class Main {
    public static void main(String[] args) {

	
    Scanner input = new Scanner(System.in); 
    Products products = new Products(); 
    products.run(input);
    }




}
