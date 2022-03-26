package com.Lockers.LockedMe;

/**
 *Class that implements all the functionality of program.<br>
 *Code Execution begins here.
 */
public class LockedMeImplementation {
	public static void main(String[] args) {
		
//		creating user object	
		User user = new User();
		
//		displaying welcome message
		user.welcome();
		
//		displaying menu
		user.displayMenu();
		
//		closing all the resources created by user
		user.closeResources();
	}
}