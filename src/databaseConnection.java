

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class databaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.50.15.14/warehourseordertrackingsystem";
	static final String USER = "root";
	static final String PASS = "colm1990";
	
	static Statement stmt = null;
	static Connection conn = getConnection();
	
	//connecting to the database
	private static Connection getConnection (){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName ("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database ....");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}
			catch (Exception e){
			System.out.println("Connection failed");
			}
			return conn;
	}

	//printing of the product table of the product
	public static void readFromDatabaseProduct (){
		try{
		System.out.println("Creating statement..");
		stmt = conn.createStatement();
		String sql2 = " SELECT productid, productname, productdesc, productloc, productquantremain FROM product";
		ResultSet rs = stmt.executeQuery(sql2);
		while(rs.next()){
		int productid = rs.getInt("productid");
		String productname = rs.getString("productname");
		String productdesc = rs.getString("productdesc");
		String productloc = rs.getString("productloc");
		int productquantremain = rs.getInt("productquantremain");
		System.out.println("Product I.D:  " + productid + ".  Product Name: " + productname + ".  Product description: " + productdesc +" .  Product Location: " +productloc + " .  Product Quantity Remaining: " + productquantremain + "."); 
		}
		rs.close();
		conn.close();
	}
	catch (SQLException sqle){
	sqle.printStackTrace();
	}
	catch (Exception e){
	e.printStackTrace();
	}
	}
	
	//arraylist calling all of the products table.
	public static ArrayList<Product> readAllProducts (){
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		String ReadProductInfo = "SELECT * FROM product ";
		ResultSet rsProductInfo; 
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsProductInfo = stmt.executeQuery(ReadProductInfo);
			while(rsProductInfo.next()){
			Product product = new Product(0, ReadProductInfo, ReadProductInfo, 0, ReadProductInfo);
			
			int PID = rsProductInfo.getInt("productid");
			String PNM = rsProductInfo.getString("productname");
			String PDS = rsProductInfo.getString("productdesc");
			String PLO = rsProductInfo.getString("productloc");
			int PRO = rsProductInfo.getInt("productquantremain");	
			
			product.setProductId(PID);
			product.setProductName(PNM);
			product.setProductDesc(PDS);
			product.setProductLoc(PLO);
			product.setProductQuantRemain(PRO); 
			
			listOfProducts.add(product);
		} rsProductInfo.close();
		return listOfProducts;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//arraylist with all of the purchase orders table called
	public ArrayList<purchaseOrder> readAllPurchaseOrders (){
		ArrayList<purchaseOrder> listOfPurchaseOrders = new ArrayList<purchaseOrder>();
		String readPurchase = "SELECT * FROM purchaseorder";
		getConnection();
		ResultSet rsPurchase;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsPurchase= stmt.executeQuery(readPurchase);
		while (rsPurchase.next()){
			purchaseOrder po = new purchaseOrder(0, readPurchase, readPurchase, readPurchase);
		
			int PID = rsPurchase.getInt("purchaseorderid");
			String PON = rsPurchase.getString("purchaseordername");
			String EW = rsPurchase.getString("employeeworking");
			String CO = rsPurchase.getString("checkedout");
		
			po.setPurchaseOrderId(PID);
			po.setPurchaseOrderName(PON);
			po.setEmployeeWorking(EW);
			po.setCheckedOut(CO);
		
			listOfPurchaseOrders.add(po);
		}
		rsPurchase.close();
		return listOfPurchaseOrders;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//array list with all of the purchase order line called. 
	public ArrayList<purchaseOrderLine> readAllPurchaseOrderLine (){
		ArrayList<purchaseOrderLine> listOfPurchaseOrderLine = new ArrayList <purchaseOrderLine>();
		String readPurchaseOrderLine = "SELECT * FROM purchaseOrderLine";
		getConnection();
		ResultSet rsPurchaseOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsPurchaseOrderLine = stmt.executeQuery(readPurchaseOrderLine);
		while (rsPurchaseOrderLine.next()){
			purchaseOrderLine pol = new purchaseOrderLine(0, readPurchaseOrderLine, 0);
			
			int POLID = rsPurchaseOrderLine.getInt("purchaseorderlineid");
			String PN = rsPurchaseOrderLine.getString("productname");
			int Q = rsPurchaseOrderLine.getInt("quantity");
			
			pol.setPurchaseOrderLineId(POLID);
			pol.setProductName(PN);
			pol.setQuantity(Q);
			
			listOfPurchaseOrderLine.add(pol);
		}
		rsPurchaseOrderLine.close();
		return listOfPurchaseOrderLine;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//arraylist with all of the details from the customer order line table. 
	public static ArrayList<customerOrder> readAllCustomerOrders(){
		ArrayList<customerOrder> listOfCustomerOrders = new ArrayList<customerOrder>();
		String readCustomer = "SELECT * FROM customerorder";
		getConnection();
		ResultSet rsCustomer;
		try{ 
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomer= stmt.executeQuery(readCustomer);
		while (rsCustomer.next()){
			customerOrder co = new customerOrder (0, readCustomer, readCustomer, readCustomer);
			
			int CID = rsCustomer.getInt("customerid");
			String CN = rsCustomer.getString("customername");
			String EW = rsCustomer.getString("employeeworking");
			String CO = rsCustomer.getString("checkedout");
			
			co.setCustomerId(CID);
			co.setCustomerName(CN);
			co.setEmployeeWorking(EW);
			co.setCheckedOut(CO);
			
			listOfCustomerOrders.add(co);
		}
		rsCustomer.close();
		return listOfCustomerOrders;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	//ArrayList with all of the customer order details entered.
	public ArrayList<customerOrderLine> readAllCustomerOrderLine(){
		ArrayList<customerOrderLine> listOfCustomerOrderLine = new ArrayList<customerOrderLine>();
		String readCustomerOrderLine = "SELECT * FROM customerorderline";
		getConnection();
		ResultSet rsCustomerOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomerOrderLine= stmt.executeQuery(readCustomerOrderLine);
		while (rsCustomerOrderLine.next()){
			customerOrderLine col = new customerOrderLine(0, readCustomerOrderLine, 0);
			
			int CID = rsCustomerOrderLine.getInt("customerid");
			String PN = rsCustomerOrderLine.getString("productname");
			int Q = rsCustomerOrderLine.getInt("quantity");
			
			col.setCustomerId(CID);
			col.setProductName(PN);
			col.setQuantity(Q);
			
			listOfCustomerOrderLine.add(col);
		}
		rsCustomerOrderLine.close();
		return listOfCustomerOrderLine;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//ArrayList with just the productId from the customer order line table
	public ArrayList<customerOrderLine> readAllCustomerOrderLine(int productId){
		ArrayList<customerOrderLine> listOfCustomerOrderLine = new ArrayList<customerOrderLine>();
		String readCustomerOrderLine = "SELECT * FROM customerorderline";
		getConnection();
		ResultSet rsCustomerOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomerOrderLine= stmt.executeQuery(readCustomerOrderLine);
		while (rsCustomerOrderLine.next()){
			customerOrderLine col = new customerOrderLine(0, readCustomerOrderLine, 0);
			
			int CID = rsCustomerOrderLine.getInt("customerid");
			String PN = rsCustomerOrderLine.getString("productname");
			int Q = rsCustomerOrderLine.getInt("quantity");
			
			col.setCustomerId(CID);
			col.setProductName(PN);
			col.setQuantity(Q);
			
			listOfCustomerOrderLine.add(col);
		}
		rsCustomerOrderLine.close();
		return listOfCustomerOrderLine;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	//deleting a customer order from products
	public void deleteCustomerOrderFromProducts(){
		try{
		System.out.println("Creating Statement ... ");
		stmt = conn.createStatement();
		String sql4 = "DELETE FROM product" + "WHERE orderid =";
		stmt.executeUpdate(sql4);
		}
		catch (SQLException sqle) {
		 sqle.printStackTrace();
		} catch (Exception e) {
		 e.printStackTrace();
		} finally {
		 try {
		  if (stmt != null)
		   stmt.close();
		  } catch (SQLException se) { }
		  try {
		   if (conn != null)
		    conn.close();
		   } catch (SQLException se) {
		    se.printStackTrace();
		   }
		  }
		  System.out.println("Goodbye!");
	}
	
	//Linking to the database and reading the order line table
	public void readFromDatabaseOrderline (){
		try{
			System.out.println("Creating statement..");
			stmt = conn.createStatement();
			String sql2 = " SELECT orderid, productid, quantity FROM orderline";
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()){
			int orderid = rs.getInt("orderid");
			int productid = rs.getInt("productid");
			int quantity= rs.getInt("quantity");
			System.out.println("Order ID " + orderid + ". Product ID" + productid + ". Quantity: " + quantity); 
			}
			rs.close();
			conn.close();
		}
		catch (SQLException sqle){
		sqle.printStackTrace();
		}
		catch (Exception e){
		e.printStackTrace();
		}
		}
	
	//creating a record into the orderline table in the database 	
	public void createDatabaseOrderLine (){
		try{
		System.out.println("Inserting Records Into The dase .... ");
		stmt = conn.createStatement();
		String sql = "INSERT INTO orderLine " + "VALUES (6, 10, 5)";
		stmt.executeUpdate(sql);
		System.out.println("Inserted Records Into Table ... ");
		} catch (SQLException sqle) {
		 sqle.printStackTrace();
		} catch (Exception e) {
		 e.printStackTrace();
		} finally {
		 try {
		  if (stmt != null)
		   stmt.close();
		  } catch (SQLException se) { }
		  try {
		   if (conn != null)
		    conn.close();
		   } catch (SQLException se) {
		    se.printStackTrace();
		   }
		  }
		  System.out.println("Goodbye!");
		 } 
	
	//Inserting a method in the 
	public void createOrder(String sql){
		getConnection();
		try{
			System.out.println("Inserting Records Into The dase .... ");
			stmt = conn.createStatement();
			System.out.println(sql);
			stmt.executeQuery(sql);
			System.out.println("Inserted Records Into the Database!");
			} catch (Exception e) {
				 e.printStackTrace();
				 
			} finally {
				 try {
				  if (stmt != null)
				   stmt.close();
				  } catch (SQLException se) { }
				  try {
				   if (conn != null)
				    conn.close();
				   } catch (SQLException se) {
				    se.printStackTrace();
				   }
				  }
				  System.out.println("Goodbye!");
	}
	//code to create a purchase order of new stock 
	public void createPurchaseOrder(String sql){
		getConnection();
		try{
			System.out.println("Inserting Records Into The dase .... ");
			stmt = conn.createStatement();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("Inserted Records Into the Database!");
			} catch (Exception e) {
				 e.printStackTrace();
				 
			} finally {
				 try {
				  if (stmt != null)
				   stmt.close();
				  } catch (SQLException se) { }
				  try {
				   if (conn != null)
				    conn.close();
				   } catch (SQLException se) {
				    se.printStackTrace();
				   }
				  }
				  System.out.println("Goodbye!");
	}
	
	//selecting all the columns in from the supplier ordertable in an arraylist. 
	public ArrayList<purchaseOrderLine> readPurchaseOrderByID (int purchaseOrderID){
		ArrayList<purchaseOrderLine> listOfOrders = new ArrayList<purchaseOrderLine>();
		String readPurchase = "SELECT * FROM purchaseorderline WHERE purchaseorderlineid = " +purchaseOrderID; 
		getConnection();
		ResultSet rsPurchase;
		try{
			System.out.println("Creating Statement... ");
			stmt = conn.createStatement();
			rsPurchase = stmt.executeQuery(readPurchase);
			
			while (rsPurchase.next()){
				purchaseOrderLine pol = new purchaseOrderLine(purchaseOrderID, readPurchase, purchaseOrderID);
				int PID = rsPurchase.getInt("purchaseOrderId");
				String PN = rsPurchase.getString("productName");
				int QTY = rsPurchase.getInt("Quantity");
				
				pol.setPurchaseOrderLineId(PID);
				pol.setProductName(PN);
				pol.setQuantity(QTY);
				
				//storing the array list in the supplier order object.
				listOfOrders.add(pol);
			}
			rsPurchase.close();
			return listOfOrders;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<customerOrderLine> readCustomerOrderByID (int customerOrderID){
		ArrayList< customerOrderLine> listOfOrders = new ArrayList<customerOrderLine>();
		String readPurchase = "SELECT * FROM customerorderline WHERE customerOrderID = " +customerOrderID;
		getConnection();
		ResultSet rsPurchase;
		try{
		System.out.println("Creating Statement...");
		stmt= conn.createStatement();
		rsPurchase = stmt.executeQuery(readPurchase);
		while (rsPurchase.next()) {
		customerOrderLine col = new customerOrderLine(customerOrderID, readPurchase, customerOrderID);	
			int PID = rsPurchase.getInt("customerOrderID"); //getters
			String PN = rsPurchase.getString("productName");
			int QTY = rsPurchase.getInt("quantity");
			
			col.setCustomerId(PID); 
			col.setProductName(PN);
			col.setQuantity(QTY);
			
			listOfOrders.add(col); 
		}
		rsPurchase.close();
		return listOfOrders;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<customerOrder> readPickedOrder()
	{
		ArrayList<customerOrder> listOfOrders2 = new ArrayList<customerOrder>();
		String ReadCustomerPicked = "SELECT * FROM customerorder WHERE progress = 'picked'"; 
		getConnection();
		ResultSet rsCustomerPicked ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rsCustomerPicked = stmt.executeQuery(ReadCustomerPicked);
		while (rsCustomerPicked.next()) {
			
			customerOrder co = new customerOrder(0, ReadCustomerPicked, ReadCustomerPicked, ReadCustomerPicked); 
			
			int COID = rsCustomerPicked.getInt("customerOrderID"); 
			String CN= rsCustomerPicked.getString("customerName");
			String EW = rsCustomerPicked.getString("employeeWorking");
			String CO = rsCustomerPicked.getString("checkedOut");
						
			co.setCustomerId(COID); 
			co.setCustomerName(CN);
			co.setEmployeeWorking(EW);
			co.setCheckedOut(CO);
			
			listOfOrders2.add(co);
			
		}
		rsCustomerPicked.close();
		return listOfOrders2;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<customerOrderLine> readPorous()
	{
		ArrayList<customerOrderLine> listOfOrders10 = new ArrayList<customerOrderLine>();
		String readCustomer = "SELECT * FROM customerorderline WHERE productName LIKE '%Porous%'"; 
		getConnection();
		ResultSet rsPorous ;
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rsPorous= stmt.executeQuery(readCustomer);
			
		while (rsPorous.next()) {
			
			customerOrderLine col = new customerOrderLine(0, readCustomer, 0);

			int PID = rsPorous.getInt("customerOrderID");
			String PN = rsPorous.getString("productName");
			int QTY = rsPorous.getInt("quantity");
			
			col.setCustomerId(PID); //setters
			col.setProductName(PN);
			col.setQuantity(QTY);
			
			listOfOrders10.add(col); 
		}
		rsPorous.close();
		return listOfOrders10;
		} catch (SQLException e){
				e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<customerOrder> readPackedOrder(){
		ArrayList<customerOrder> listOfOrders3 = new ArrayList<customerOrder>(); 
		String ReadCustomerPacked = "SELECT * FROM customerorder WHERE progress = 'packed'"; 
		getConnection();
		ResultSet rsCustomer; 
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			rsCustomer = stmt.executeQuery(ReadCustomerPacked);
			while (rsCustomer.next()) {
			
				customerOrder co = new customerOrder(0, ReadCustomerPacked, ReadCustomerPacked, ReadCustomerPacked); 
				
				int COID = rsCustomer.getInt("customerOrderID"); 
				String CN= rsCustomer.getString("customerName");
				String EW = rsCustomer.getString("employeeWorking");
				String CO = rsCustomer.getString("checkedOut");
							
				co.setCustomerId(COID); 
				co.setCustomerName(CN);
				co.setEmployeeWorking(EW);
				co.setCheckedOut(CO);
				
				listOfOrders3.add(co);
		}
		rsCustomer.close();
		return listOfOrders3;
		} catch (SQLException e){
				e.printStackTrace();
				return null;
			} 
	}
	
	public ArrayList<Product> readStock() 
	{
		ArrayList<Product> listOfOrders4 = new ArrayList<Product>(); 
		String ReadProduct = "SELECT * FROM product";
		getConnection();
		ResultSet rsStock;
		try
		{
				System.out.println("Creating Statement....");
				stmt= conn.createStatement();
				rsStock = stmt.executeQuery(ReadProduct);
				while (rsStock.next()) {
				Product Product = new Product(0, ReadProduct, ReadProduct, 0, ReadProduct); 
										
				int PRID = rsStock.getInt("productID"); 
				String PN = rsStock.getString("productName");
				String PD = rsStock.getString("productDescription");
				int QTY = rsStock.getInt("quantity");
				String LOC = rsStock.getString("location");
											
				Product.setProductId(PRID); 
				Product.setProductName(PN);
				Product.setProductDesc(PD);
				Product.setProductQuantRemain(QTY);
				Product.setProductLoc(LOC);
											
				listOfOrders4.add(Product);	
				}
				rsStock.close();
				return listOfOrders4;
				} catch (SQLException e){
					e.printStackTrace();
						return null;
				} 
	}
	
	public void UpdateWorking(int ID, String working, String checked)
	{
		String updateOrder = "UPDATE customerorder " + "SET employeeWorking = '" + working + "', checkedout = '"+ checked + "' WHERE customerorderID = " + ID;
		System.out.println(updateOrder);
		getConnection(); 
		
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			stmt.executeUpdate(updateOrder);
		
		} catch (SQLException e){
				e.printStackTrace();
			
		} 
	}
	
	public void DeleteProduct(int ID)//UPDATE
	{
		String deleteProduct = "DELETE FROM product " + " WHERE productID = " + ID;
		System.out.println(deleteProduct);
		getConnection(); 
		
		try
		{
			System.out.println("Creating Statement...");
			stmt= conn.createStatement();
			stmt.executeUpdate(deleteProduct);
		
		} catch (SQLException e){
				e.printStackTrace();
			
		} 
	}
	
	
}
	
	


