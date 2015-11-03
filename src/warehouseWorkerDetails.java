

public final class warehouseWorkerDetails implements Comparable <warehouseWorkerDetails> {
	private String userName;
	private String passWord; 
	private String firstName;
	private String lastName; 
	
	public warehouseWorkerDetails(String username, String password, String firstname, String lastname){
		this.userName = username;
		this.passWord = password;
		this.firstName = firstname;
		this.lastName = lastname;
	}//default constructor for a new warehouse worker. 
	
	public void showWorkerDetails(){
		System.out.println("Username:" +this.userName);
		System.out.println("FirstName:" +this.firstName);
		System.out.println("lastname" + this.lastName);
	}
	
	//get and set methods for the string variables 
	public String getUsername (){
		return userName;
	}
	public void setUsername (String username){
		this.userName = username;
	}
	
	public String getPassword (){
		return passWord;
	}
	public void setPassword (String password){
		this.passWord = password;
	}
	public String getFirstname (){
		return firstName;
	}
	public void setFirstname(String firstName){
		this.firstName = firstName;
	}
	public String getLastName (){
		return lastName;
	}
	public void setLastName (String lastName){
		this.lastName = lastName;
	}

	@Override
	public int compareTo(warehouseWorkerDetails o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
