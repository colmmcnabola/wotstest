

public class Product implements Comparable <Product> {
	
	//Default Variables of the product
	private int productId;
	private String productName;
	private String productDesc;
	private String productLoc;
	private int productQuantRemain;
	
	//Default constructor for a new product
	public Product (int productid, String productName, String productDesc, int productQuantRemain, String productLoc){
		this.productId = productid;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productQuantRemain = productQuantRemain;
		this.productLoc = productLoc;
	}
	
	//Get and Set Methods
	public int getproductId (){
		return productId;
	}
	
	public void setProductId (int productid){
		this.productId = productid;
	}
	
	public String getProductName (){
		return productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductDesc (){
		return productDesc;
	}
	
	public void setProductDesc(String productDesc){
		this.productDesc = productDesc;
	}
	
	public String getProductLoc (){
		return productLoc;
	}
	
	public void setProductLoc(String productLoc){
		this.productLoc = productLoc;
	}
	
	public int getProductQuantRemain (){
		return productQuantRemain;
	}
	
	public void setProductQuantRemain(int QTY){
		this.productQuantRemain = QTY;
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
