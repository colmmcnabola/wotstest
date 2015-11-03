

public class purchaseOrderLine implements Comparable <purchaseOrderLine>{

	//variables
	private int purchaseOrderLineId;
	private String productName;
	private int quantity;
	
	//default constructor
	public purchaseOrderLine (int purchaseOrderLineId, String productName, int quantity){
		this.purchaseOrderLineId = purchaseOrderLineId;
		this.productName = productName;
		this.quantity = quantity;		
	}
	
	//get and set methods
	public int getPurchaseOrderLineId (){
		return purchaseOrderLineId;
	}
	
	public void setPurchaseOrderLineId(int purchaseOrderLineId){
		this.purchaseOrderLineId = purchaseOrderLineId;
	}

	public String getProductName (){
		return productName;
	}
	
	public void setProductName (String productName){
		this.productName = productName;
	}
	
	public int getQuantity (){
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	@Override
	public int compareTo(purchaseOrderLine o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
