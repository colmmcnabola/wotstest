

import java.util.ArrayList;

public class callingOfMethods {
	
	
	public static String [] productList (){
		ArrayList<Product> pList = new ArrayList<Product>();
		pList = databaseConnection.readAllProducts();
		int length = pList.size();
		String [] list = new String [length];
		
		for (int i = 0; i<length; i++ ){
			list[i] = (+ pList.get(i).getproductId() + "Name: " + pList.get(i).getProductName());
		}
		return list;

	}
}

