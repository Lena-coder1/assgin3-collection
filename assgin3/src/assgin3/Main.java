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
                	System.out.println(" Please enter product code: ")
                	int productID= input.nextInt(); 
                	int ID = map.get(productID);
                	
                	
                }
                   
            }
            


	}
}

public class Main {
    public static void main(String[] args) {

	
    
    }




}