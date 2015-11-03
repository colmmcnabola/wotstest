

import java.util.ArrayList;

public class customerOrderLine implements Comparable <customerOrderLine>{
	
	//default variables 
		private int customerId;
		private String productname;
		private int quantity;
		
	public customerOrderLine (int customerid, String productname, int quantity){
		this.customerId = customerid;
		this.productname = productname;
		this.quantity = quantity;
	}
	
	//get and set methods of the above
		public int getCustomerId(){
			return customerId;
		}
		
		public void setCustomerId (int customerId){
			this.customerId = customerId;
		}
		
		public String getProductName(){
			return productname;
		}
		
		public void setProductName (String productname){
			this.productname = productname;
		}
		
		public int getQuantity(){
			return quantity;
		}
		
		public void setQuantity (int quantity){
			this.quantity = quantity;
		}


		@Override
		public int compareTo(customerOrderLine o) {
			// TODO Auto-generated method stub
			return 0;
		}
}
