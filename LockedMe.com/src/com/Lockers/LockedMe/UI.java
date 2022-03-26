package com.Lockers.LockedMe;

import java.util.Scanner;
import org.apache.logging.log4j.*;

/**
 * User Interface that contains all the methods and global variables required for handling user interactions.<br>
 * UI interface contains the global scanner-input and logger-output objects.<br>
 */
public interface UI {

	/**
	 * global scanner object for user input.<br>
	 */
	public static final Scanner input = new Scanner(System.in);

	/**
	 * global logger object for output.<br>
	 */
	public static final Logger output = LogManager.getLogger(User.class.getName());
	
	/**
	 * displays welcome message
	 */
	public void welcome();
	
	/**
	 * displays the main menu to the user.<br>
	 */
	public void displayMenu();
	/**
	 * used to close the initialized resources.<br>
	 */
	public void closeResources();
	
}
