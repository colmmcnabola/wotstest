

public class purchaseOrder implements Comparable <purchaseOrder> {

	//instance variables
	private int purchaseOrderId;
	private String purchaseOrderName;
	private String employeeWorking;
	private String checkedOut;
	
	//default constructor
	public purchaseOrder (int purchaseOrderId, String purchaseOrderName, String employeeWorking, String checkedOut){
		this.purchaseOrderId = purchaseOrderId;
		this.purchaseOrderName = purchaseOrderName;
		this.employeeWorking = employeeWorking;
		this.checkedOut = checkedOut;
	}
	
	//get and set methods 
	public int getPurchaseOrderId (){
		return purchaseOrderId;
	}
	
	public void setPurchaseOrderId (int purchaseOrderId){
		this.purchaseOrderId = purchaseOrderId;
	}
	
	public String getPurchaseOrderName(){
		return purchaseOrderName;
	}
	
	public void setPurchaseOrderName (String purchaseOrderName){
		this.purchaseOrderName = purchaseOrderName;
	}
	
	public String getEmployeeWorking(){
		return employeeWorking;
	}
	
	public void setEmployeeWorking (String employeeWorking){
		this.employeeWorking = employeeWorking;
	}
	
	public String getCheckedOut(){
		return checkedOut;
	}
	
	public void setCheckedOut (String checkedOut){
		this.checkedOut = checkedOut;
	}
	
	

	@Override
	public int compareTo(purchaseOrder o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
