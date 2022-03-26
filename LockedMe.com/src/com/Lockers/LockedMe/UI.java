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
	public static final Logger output = LogManager.getLogger(UI.class.getName());
	
	/**
	 * active context type
	 */
	
	public enum context{MAIN_MENU, FILE_MANAGER, LIST_ALL_FILES, ADD_FILE, DELETE_FILE, SEARCH_FILE};
	
	/**
	 * displays welcome message
	 */
	public void welcome();
	
	/**
	 * displays the main menu to the user.<br>
	 */
	public void displayMenu();
	
	/**
	 * prompts for user choice for main menu context.
	 */
	public int promptUserChoiceForMenu();
	
	/**
	 * displays a sub context where user can choose between adding a new file, deleting a file or returning to the main context.<br>
	 */
	public void displayListAllfilesContext();
	
	/**
	 * prompts for user choice for list all files sub context
	 */
	public int promptUserChoiceForListAllFilesContext();
	
	/**
	 * displays file manager context
	 */
	
	public void displayFileManagerContext();
	
	/**
	 * displays a sub context where user can choose between listing all files, deleting a file or returning to the main context.<br>
	 */
	public void displaySubContext();
	
	/**
	 * prompts for user choice for add files sub context
	 */
	public int promptUserChoiceForSubContex();
	

	
	/**
	 * loops the current active context
	 */
	public void loopActiveContext();
	
	/**
	 * used to close the initialized resources.<br>
	 */
	public void closeResources();
	
}
