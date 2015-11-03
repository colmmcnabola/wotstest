

import java.util.ArrayList;
import java.util.Scanner;

	public final class interfacePage {
		private final arrayOfWarehouseWorkers user;
		private final Scanner scanner;
		databaseConnection dbconnect = new databaseConnection();
		
		//Home Page Title 
		public interfacePage (){
			this.user = new arrayOfWarehouseWorkers(10);
			this.scanner = new Scanner (System.in);
			System.out.println ("Welcome to the Warehouse Order Tracking System");
		}
		
		//Home Page Menu
		public void startMenu (){
			int choice;
			do{
				System.out.println("1. Log In");
				System.out.println("2. Register");
				System.out.println("3. Exit the system.");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice){
				case 0:
					System.out.println("You have now exited the Warehouse Order Tracker System");
					break;
				case 1: 
					loginPrompt();
					break;
				case 2: 
					registerPrompt();
					break;
				default: 
					System.out.println("Wrong Input please try again");
				}
			}while (choice !=0);
		}// Home page switch statements. log in/register/exit.
		
		//LogIn Prompt
		private void loginPrompt(){
			System.out.println("Please enter your username: ");
			String username = scanner.nextLine();
			System.out.println("Please enter your password: ");
			String password = scanner.nextLine();
			
			warehouseWorkerDetails w = login (username, password);
			if ( w != null){
				System.out.println("Computer Says No. Wrong username or password entered.");
			}
			else{
				userMenu(w);
			}
		}
		
		//the process of when a user chooses the login option on the home screen. 
		private void registerPrompt(){
			System.out.println("We need the following details from you.");
			System.out.println("Your username please: ");
			String username = scanner.nextLine();
			//go back to the register prompt method in SN and look up searching an email thats on the system. 
			System.out.println("Your password please: ");
			String password = scanner.nextLine();
			System.out.println("Your firstname please: ");
			String firstname = scanner.nextLine();
			System.out.println("Your lastname please: ");
			String lastname = scanner.nextLine();
			
			register( new warehouseWorkerDetails (username, password, firstname, lastname));
		}//the process of when a user chooses the register option on the home screen. 
		
		public void register (warehouseWorkerDetails w){
			if (user.getIndexByUsername(w.getUsername ()) == -1)
				user.insert(w);	
		}//register method for the registerPrompt method of the login/register/home screen
		
		private void userMenu (warehouseWorkerDetails w){
			int choice;
			do{
				System.out.println("Please choose from the menu below which action you wish to carry out. ");
			
			System.out.println("1. Inventory Menu");
			System.out.println("2. Customer Order Menu");
			System.out.println("3. View Orders");
			System.out.println("4. Order More Stock");
			System.out.println("0. Log out:");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice){
			case 1: 
				inventoryMenu();
				break;
			case 2: 
				customerOrdermenu();
				break;
			case 3: 
				viewOrders();
				break;
			case 4: 
				orderMoreStock();
			case 0:
				System.out.println("You have been logged out. See ya lataaaaaaaa ");
			default: 
					System.out.println("Computer Says No.");
		}
		}while (choice !=0);
	}

		//creating a new customer order. 
		private void newCustomerOrder(){
			System.out.println("Please Enter The Customer Order ID: ");
			int customerId = scanner.nextInt();
			
			System.out.println("Please Enter The Customer Name: ");
			String customerName = scanner.toString();
			
			System.out.println("Please Enter The Name Of The Employee Working: ");
			String employeeWorking = scanner.toString();
			
			System.out.println("Has This Product Been Checked Out? ");
			String checkedOut = scanner.toString();
			
			String sql = "INSERT INTO customerorder (customerID, customerName, employeeWorking, checkedOut) VALUES ("+customerId+" , '"+customerName+"','"+employeeWorking+"','"+checkedOut+")";
			dbconnect.createOrder(sql);
			newCustomerOrderLine();
		}
		
		//creating a new customer order line
		private void newCustomerOrderLine(){
			System.out.println("Please Enter The Purchase Order ID: ");
			int customerOrderLineId = scanner.nextInt();
			
			System.out.println("Please Enter The Purchase Order Name: ");
			String customerName = scanner.toString();
			
			System.out.println("Please Enter The Name Of The Employee Working: ");
			String employeeWorking = scanner.toString();
			
			System.out.println("Has This Product Been Checked Out? ");
			String checkedOut = scanner.toString();
			
			String sql = "INSERT INTO customerorderline (customerId, customerName, employeeWorking, checkedOut) VALUES ("+customerOrderLineId+", '"+customerName+"', '"+employeeWorking+"', '"+checkedOut+")";
			dbconnect.createOrder(sql);
			
			int choice; 
			System.out.println("Next:");
			System.out.println("Select 1 to add this into the order. ");
			System.out.println("Select 2 to return to the main menu. ");
			choice = Integer.parseInt(scanner.nextLine());
			switch(choice){
			case 1:
				System.out.println("You have chosen to add this to the order");
				newCustomerOrderLine();
				break;
			case 2: 
				System.out.println("You have been returned to the main menu. ");
				userMenu(null);
				break;
			}
		}
		
		//creating a new purchase order - linked into the order menu. 
		private void newPurchaseOrder (){
			System.out.println("Please Enter The Purchase Order ID: ");
			int purchaseOrderId = scanner.nextInt();
			
			System.out.println("Please Enter The Purchase Order Name: ");
			String purchaseOrderName = scanner.nextLine();
			
			System.out.println("Please Enter The Name Of The Employee Working: ");
			String employeeWorking = scanner.nextLine();
			
			System.out.println("Has This Product Been Checked Out? ");
			String checkedOut = scanner.nextLine();
			
			String sql = "INSERT INTO purchaseorder (purchaseOrderId, purchaseOrderName, employeeWorking, checkedOut) VALUES ("+ purchaseOrderId +", '"+purchaseOrderName+"', '"+employeeWorking+"' ,'"+checkedOut+"')";
			dbconnect.createPurchaseOrder(sql); 
			newPurchaseOrderLine();
		}
		
		//creation of a new purchase order line
		private void newPurchaseOrderLine (){
			System.out.println("Please Enter The Purchase Order ID: ");
			int purchaseOrderLineID = scanner.nextInt();
			
			System.out.println("Please Enter The Product Name: ");
			String productName = scanner.toString();
			
			System.out.println("Please Enter The Number: ");
			int quantity = scanner.nextInt();
			
			String sql = "INSERT INTO purchaseorderline (purchaseOrderLineId, productName, quantity) VALUES ("+purchaseOrderLineID+"', '"+productName+"' , '"+quantity+")";
			dbconnect.createPurchaseOrder(sql);
			
			int choice;
			System.out.println("Next:");
			System.out.println("1) to add this into the order. ");
			System.out.println("2) to return to the main menu. ");
			choice = Integer.parseInt(scanner.nextLine());
			switch(choice){
			case 1:
				System.out.println("You have chosen to add this to the order");
				newPurchaseOrderLine();
				break;
			case 2: 
				System.out.println("You have been returned to the main menu. ");
				userMenu(null);
				break;
			}
			
		}

		
		// whenever they have logged in, this is the menu that the warehouse worker has to choose from.
		private void inventoryMenu() {
			int choice; 
			do{
				System.out.println("--- INVENTORY MENU ---");
			
			System.out.println("1. View Inventory");
			System.out.println("2. Back to main menu");
		
			choice = Integer.parseInt(scanner.nextLine()); 
			switch (choice){
				case 1:
				databaseConnection.readFromDatabaseProduct();
				break;
				case 2: System.out.println("You have now been returned to the user menu");
				userMenu(null);
				return;
				default: 
					System.out.println("Computer Says No.");
			}
			}while (choice !=0);
		}
	
		// Update order menu from the userMenu method
		private void viewOrders (){
			int choice;	
			
			System.out.println("--- VIEW ORDERS ---");
			System.out.println(" Please Enter The Number Of The Type Of Order You Wish To View");
			System.out.println("1) Customers Orders Currently In The System. ");
			System.out.println("2) Supplier Orders Currently Placed. ");
			System.out.println("3) Orders That Have Been Picked. ");
			System.out.println("4) Orders That Have Been Packed. ");
			System.out.println("5) Products That Require Porous Wear. ");
			System.out.println("6) Return to Menu. ");
			choice = Integer.parseInt(scanner.nextLine()); 
			switch (choice) {
			case 1:
				System.out.println("View Customer Orders ");
				ArrayList<customerOrder> listOfOrders = dbconnect.readAllCustomerOrders();
				for (int i = 0; i< listOfOrders.size(); i++){
					System.out.println("Customer ID: " +listOfOrders.get(i).getCustomerId() + "\t. Customer Name: " +listOfOrders.get(i).getCustomerName() + 
							"\t . Employee Working On It Is: " +listOfOrders.get(i).getEmployeeWorking() + "\t . Checked Out: " +listOfOrders.get(i).getCheckedOut()); 
				}
				System.out.println("Please Choose from the following options.");
				System.out.println("1) To Change The Status Of The Order. ");
				System.out.println("2) View The Order. ");
				System.out.println("3) To Return To The Previous Screen: ");
				String option = scanner.next(); 
					switch (option){
					case "1": System.out.println("Change An Orders Status"); 
					updateOrderStatus();
					break;
					case "2": System.out.println("View An Order ");
					newCustomerOrderLine(); 
					break;
					case "3": System.out.println("View The Order Line ");
					selectCustomerOrderLine();
					break;
				}
				
			break;
			case 2: 
				System.out.println("View Supplier Orders. ");
				ArrayList<purchaseOrder> listOfOrders1 = dbconnect.readAllPurchaseOrders();
				for (int i = 0; i< listOfOrders1.size(); i++){
					System.out.println("Purchase ID: " +listOfOrders1.get(i).getPurchaseOrderId() + ". \t Purchase Name: " +listOfOrders1.get(i).getPurchaseOrderId());
				}
				selectPurchaseOrderLine();
				break;
			case 3: 
				System.out.println("Orders That Have Picked. ");
				ArrayList<customerOrder> listOfOrders2 = dbconnect.readPickedOrder();
				for (int i = 0; i< listOfOrders2.size(); i++){
					System.out.println(" Customer Id:  " +listOfOrders2.get(i).getCustomerId() +  ". \t Order ID: "+listOfOrders2.get(i).getCustomerName() +
							". \t Employee Working: " +listOfOrders2.get(i).getEmployeeWorking() + ". \t Checked Out: " +listOfOrders2.get(i).getCheckedOut());
				}
				break;
			case 4: 
				System.out.println("Orders That Have Been Packed. ");
				ArrayList<customerOrder> listOfOrders3 = dbconnect.readPackedOrder();
				for (int i = 0; i< listOfOrders3.size(); i++){
					System.out.println(" Customer Id:  " +listOfOrders3.get(i).getCustomerId() +  ". \t Order ID: "+listOfOrders3.get(i).getCustomerName() +
							". \t Employee Working: " +listOfOrders3.get(i).getEmployeeWorking() + ". \t Checked Out: " +listOfOrders3.get(i).getCheckedOut());
				}
				break;
			case 5: 
				System.out.println("Products That Require Porous Wear. ");
				ArrayList<customerOrderLine> listOfOrders5 = dbconnect.readPorous();
				for (int i = 0; i< listOfOrders5.size(); i++){
					System.out.println("Purchase Id: " +listOfOrders5.get(i).getCustomerId() + ". \t Product Name: " +listOfOrders5.get(i).getProductName() + ". \t Quantity: " +listOfOrders5.get(i).getQuantity());
				}
				break;
			case 6:
				userMenu(null);
			default: 
				System.out.println("Computer Says No.");
			return;
			}	
		}
		
		// customer order menu from the user menu method
		private void customerOrdermenu (){
			int choice;
			do{
				System.out.println("--- CUSTOMER ORDERS MENU ---");	
				System.out.println("1. New Customer Order");				
				System.out.println("2. Back to main menu");
				
				choice = Integer.parseInt(scanner.nextLine()); 
				switch (choice) {
				case 1:
					newCustomerOrder();
				break;
				case 2:
					System.out.println("Exiting back to main menu...");
					userMenu(null);
					return;
				} 
			}while (choice !=0);
		}
		
		//ordering of more stock choice menu
		private void orderMoreStock (){
			int choice;
			do{
				System.out.println(" --- Create A new Purchase Order --- ");
				System.out.println("1) Enter A New Purchase Order. ");
				System.out.println("2) Return To Main Menu. ");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice){
				case 1: newPurchaseOrder();
					break;
				case 2: userMenu(null);
					break;
				default:
						System.out.println(" Computer Says No. ");
				}
			}while (choice !=0);
		}
		
		//Deleting a product from the system
		private void deleteProduct(){
			System.out.println("--- DELETE PRODUCT ---");
			System.out.println("Please Enter The Number Of The Order You Wish To Delete.");
			int choice = scanner.nextInt();
			dbconnect.DeleteProduct(choice);
		}
		
		//selecting from the purchase order line 
		private void selectPurchaseOrderLine(){
			System.out.println("Please Enter The Number Of The Order You Wish To View");
			int choice = scanner.nextInt();
			ArrayList <purchaseOrderLine> listOfOrders = dbconnect.readPurchaseOrderByID (choice);
			for (int i = 0; i <listOfOrders.size(); i++){
				System.out.println("Purchase ID: " + listOfOrders.get(i).getPurchaseOrderLineId() + 
						". \t Product Name: " +listOfOrders.get(i).getProductName() + 
						". \t Quantity: " +listOfOrders.get(i).getQuantity());
			}
		}
		
		//Selecting from the customer order line
		private void selectCustomerOrderLine(){
			System.out.println("Please Enter The Number Of The Order You Wish To View");
			int choice = scanner.nextInt();
			ArrayList <customerOrderLine> listOfOrders = dbconnect.readCustomerOrderByID (choice);
			for (int i = 0; i <listOfOrders.size(); i++){
				System.out.println("Purchase ID: " + listOfOrders.get(i).getCustomerId() + 
						". \t Product Name: " +listOfOrders.get(i).getProductName() + 
						". \t Quantity: " +listOfOrders.get(i).getQuantity());
			}
		}
		
		//Reading the Number of stock thats remaining in the system based on the select method.  
		private void readStock (){
			System.out.println("Please Enter The Number Of The Order You Wish To View");
			ArrayList <Product> listOfOrders = dbconnect.readStock ();
			for (int i = 0; i <listOfOrders.size(); i++){
				System.out.println("Product Name: " + listOfOrders.get(i).getProductName() + 
						". \t Product Description: " +listOfOrders.get(i).getProductDesc() + 
						". \t Quantity: " +listOfOrders.get(i).getProductQuantRemain() + 
						". \t Location: " + listOfOrders.get(i).getProductLoc());
			}
			deleteProduct();
		}
		
		//updating the order
		private void updateOrderStatus (){
			System.out.println("Enter The Number Of The Order You Wish To Update: ");
			int choice1 = scanner.nextInt();
			System.out.println("What Is The Name Of The Employee Working On the System? ");
			String choice2 = scanner.next();
			System.out.println("Is the order being checked out? ");
			String choice3 = scanner.next();
			dbconnect.UpdateWorking(choice1, choice2, choice3);
		}
		
		public warehouseWorkerDetails login (String username, String pass){
			int index = user.getIndexByUsername(username);
			if (index ==-1)
				return null;
			warehouseWorkerDetails w = user.getWarehouseWorkersByIndex(index);
			if (w != null){
				if (w.getUsername().equals(pass)){
					return w;
				}
				else {
					return null;
				}
			}
			return null;
		}// Log in check details based on its password being correct
		
	}


