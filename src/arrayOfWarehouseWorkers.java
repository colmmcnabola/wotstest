
import java.util.ArrayList;


public class arrayOfWarehouseWorkers {
	private ArrayList <warehouseWorkerDetails> warehouseWorkers;
	
	public arrayOfWarehouseWorkers (int n){
		//Blank array with no limits
		warehouseWorkers = new ArrayList (n);
	}//default constructor
	
	public warehouseWorkerDetails getWarehouseWorkersByIndex (final int index){
		warehouseWorkerDetails p = null;
		try{
			p= warehouseWorkers.get(index);
		}catch 
		( IndexOutOfBoundsException ex){
		}
		return p;
	}
	
	public int size (){
		return warehouseWorkers.size();
	}
	//returns the array of the warehouse workers that were registered in the system. 
	
	public void insert (warehouseWorkerDetails w){
		//adding someone in the array
		int high = warehouseWorkers.size();
		if (high ==0){
			warehouseWorkers.add(w);
			return;
		}
		
		int low = 0;
		while (high > low){
			int mid = low + (int)Math.ceil((high-low)/2);
			int compare = warehouseWorkers.get(mid).compareTo(w);
			if (compare ==0){
				return;
			}else{
				high = mid;
			}
		}
		warehouseWorkers.add(w);
		
		if (high != warehouseWorkers.size()-1){
			for (int i = warehouseWorkers.size()-1; i>high && i>0; i--){
				warehouseWorkers.set(i,warehouseWorkers.get(i-1));
			}
			warehouseWorkers.set(high, w);
		}
	}//Inserting someone in the array of warehouse workers
	
	public int getIndexByUsername (String username){
		for (int i= 0; i< warehouseWorkers.size(); i++){
			if (warehouseWorkers.get(i).getUsername().equals(username))
				return i;
		}
		return -1;
	}
	
	public ArrayList <warehouseWorkerDetails> values (){
		return warehouseWorkers;
	}

}
