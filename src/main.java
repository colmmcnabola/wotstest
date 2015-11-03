



public class main {
	
	public static void main ( String [] args ){
		GUI sd = new GUI();
		sd.mainMenu();
		
		interfacePage ip = new interfacePage();
		warehouseWorkerDetails Daniel = new warehouseWorkerDetails ("daniel", "abc", "daniel", "dos santos");
		warehouseWorkerDetails Colm = new warehouseWorkerDetails("colm", "abc", "colm", "mcnabola");
		warehouseWorkerDetails Ben = new warehouseWorkerDetails ("ben", "abc", "ben", "butters");
		warehouseWorkerDetails Joe = new warehouseWorkerDetails ("joe", "abc", "joe", "irving");
		
		ip.register(Daniel);
		ip.register(Colm);
		ip.register(Ben);
		ip.register(Joe);
		ip.startMenu();
	}
}




