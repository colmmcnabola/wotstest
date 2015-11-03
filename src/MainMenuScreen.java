

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuScreen extends JPanel {

	private JFrame mainFrame;
	
	public MainMenuScreen(JFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		System.out.println("Opening main menu");
		//creating of new buttons on the main screen
		JButton createNewCustOrderButton = new JButton ("Create New Customer Order");
		JButton createNewOrderButton = new JButton ("Create New Purchase Order");
		JButton viewOrdersButton = new JButton ("View Current Orders");
		JButton viewProductsButton = new JButton("View Products");
		JButton exitMainMenuButton = new JButton ("Exit");
		
		//setting of the command for each of the buttons created above
		createNewCustOrderButton.setActionCommand("Create New Customer Order");
		createNewOrderButton.setActionCommand("Create New Purchase Order");
		viewOrdersButton.setActionCommand("View Current Orders");
		viewProductsButton.setActionCommand("Products");
		exitMainMenuButton.setActionCommand("Exit");
		
		createNewCustOrderButton.addActionListener(new BCL(this));
		createNewOrderButton.addActionListener(new BCL(this));
		viewOrdersButton.addActionListener(new BCL(this));
		viewProductsButton.addActionListener(new BCL(this));
		exitMainMenuButton.addActionListener(new BCL(this));
		
		this.add(createNewCustOrderButton);
		this.add(createNewOrderButton);
		this.add(viewOrdersButton);
		this.add(viewProductsButton);
		this.add(exitMainMenuButton);
	}
	
	private class BCL implements ActionListener{
		
		private JPanel currentScreen;
		
		public BCL(JPanel currentScreen) {
			this.currentScreen = currentScreen;
		}
		
		@Override
		public void actionPerformed (ActionEvent ae){
			String command = ae.getActionCommand();
			switch (command){
			case "Customer Orders": 
				break;
			case "Stock Orders":
				break;
			case "Current Orders":
				//currentOrders();
				break;
			case "Products":
				//viewProducts();
				break;
			case "Exit":
				MainMenuScreen mainMenu = new MainMenuScreen(mainFrame);
				mainFrame.add(mainMenu);
				mainFrame.remove(currentScreen);
				currentScreen = mainMenu;
				break;
			case "Home":
				
				
				//productList.setVisible(false);
				//backToHome.setVisible(false);
				//productPanel.remove(productList);
				//productPanel.remove(backToHome);
				
				//mainMenu();
				break;
			}
		}
	}
}
