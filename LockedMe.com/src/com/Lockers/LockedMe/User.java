package com.Lockers.LockedMe;

import java.io.File;
import java.util.List;

/**
 * Class that implements UserInterface "UI".<br>
 * All the user data and operations are defined in this class.<br>
 */
public class User extends InputHandler implements UI {

	private context active = context.MAIN_MENU;

	public User(){
		super();
	}

	//	Implementing User Interface
	//	Hover on overridden methods to see documentation.

	@Override
	public void welcome()
	{
		output.info(GlobalConstants.STARS + "Application Name: LockedMe.com\nDeveloped By: Lockers Pvt Ltd." + GlobalConstants.STARS);
	}
	@Override
	public void displayMenu() {
		welcome();

		output.info(GlobalConstants.STARS + "Main Menu" + GlobalConstants.STARS + "1. List All Files\n2. Add File\n3. Delete File\n4. Search File\n5. Exit");
		handleMenuInput();
	}
	@Override
	public void closeResources() {
		input.close();
	}

	@Override
	public void displayListAllfilesContext() {
		output.info(GlobalConstants.STARS + "possible actions:" + GlobalConstants.STARS + "1. Add File\n2. Delete File\n3. Search File\n4. Return to Main Menu\n5. Exit");
		handleListAllfilesContextInput();
	}

	@Override
	public void displaySubContext() {
		
		output.info(GlobalConstants.STARS + "possible actions:" + GlobalConstants.STARS + "1. List All Files\n2. Add File\n3. Delete File\n4. Search File\n5. Return to Main Menu\n6. Exit");
		
		handleSubContext();
	}


	@Override
	public void loopActiveContext() {
		while(active != null)
		{
			switch(active)
			{
			case MAIN_MENU:
				displayMenu();
				break;

			case LIST_ALL_FILES:
				displayListAllfilesContext();
				break;

			case ADD_FILE:
				displaySubContext();
				break;

			case DELETE_FILE:
				displaySubContext();
				break;

			case SEARCH_FILE:
				displaySubContext();
				break;
			}			
		}
	}

	//	Input handling

	@Override
	public int promptUserChoiceForMenu() 
	{
		output.info( GlobalConstants.STARS + "Please enter your choice: ");
		int choice = input.nextInt();
		output.info(GlobalConstants.STARS);
		input.nextLine();

		while(choice < 1 || choice > 5)
		{
			output.info(GlobalConstants.STARS + "Please enter a valid choice: ");
			choice = input.nextInt();
			output.info(GlobalConstants.STARS);
		}
		return choice;
	}



	@Override
	protected void handleMenuInput()
	{
		int choice = promptUserChoiceForMenu();
		switch(choice)
		{
		case 1: 
			List<File> files = listAllFiles(filesDirectory);
			if(files.isEmpty())
			{
				output.info(GlobalConstants.STARS + "Files directory is empty." + GlobalConstants.STARS);
			}
			else
			{
				output.info(GlobalConstants.STARS + "Listing All Files" + GlobalConstants.STARS);
				files.forEach(file->output.info(file.getName()));
				output.info(GlobalConstants.STARS);
			}
			active = context.LIST_ALL_FILES;
			break;
		case 2: 
			addFile(filesDirectory);
			active = context.ADD_FILE;
			break;
		case 3:
			deleteFile(filesDirectory);
			active = context.DELETE_FILE;
			break;
		case 4:
			searchFile(filesDirectory);
			active = context.SEARCH_FILE;
			break;
		case 5:
			output.info(GlobalConstants.STARS + "End of program" + GlobalConstants.STARS);
			//	closing all the resources before ending the program.
			this.closeResources();
			System.exit(0);
			break;
		default:
			break;
		}
	}

	@Override
	public int promptUserChoiceForListAllFilesContext() {
		return promptUserChoiceForMenu();
	}

	@Override
	protected void handleListAllfilesContextInput() {
		int choice = promptUserChoiceForListAllFilesContext();
		switch(choice)
		{
		case 1:
			addFile(filesDirectory);
			active = context.ADD_FILE;
			break;
		case 2:
			deleteFile(filesDirectory);
			active = context.DELETE_FILE;
			break;
		case 3:
			searchFile(filesDirectory);
			active = context.SEARCH_FILE;
			break;
		case 4:
			output.info(GlobalConstants.STARS + "Returning to Main Menu" + GlobalConstants.STARS);
			active = context.MAIN_MENU;
			break;
		case 5:
			output.info(GlobalConstants.STARS + "End of program" + GlobalConstants.STARS);
			//	closing all the resources before ending the program.
			this.closeResources();
			System.exit(0);
			break;
		default: 
			break;
		}
	}

	@Override
	public int promptUserChoiceForSubContex() {
		
		output.info( GlobalConstants.STARS + "Please enter your choice: ");
		int choice = input.nextInt();
		output.info(GlobalConstants.STARS);
		input.nextLine();

		while(choice < 1 || choice > 6)
		{
			output.info(GlobalConstants.STARS + "Please enter a valid choice: ");
			choice = input.nextInt();
			output.info(GlobalConstants.STARS);
		}
		return choice;
	}

	@Override
	protected void handleSubContext() {
		int choice = promptUserChoiceForSubContex();
		
		switch(choice)
		{
		case 1:
			List<File> files = listAllFiles(filesDirectory);
			if(files.isEmpty())
			{
				output.info(GlobalConstants.STARS + "Files directory is empty." + GlobalConstants.STARS);
			}
			else
			{
				output.info(GlobalConstants.STARS + "Listing All Files" + GlobalConstants.STARS);
				files.forEach(file->output.info(file.getName()));
				output.info(GlobalConstants.STARS);
			}
			active = context.LIST_ALL_FILES;
			break;
		case 2:
			addFile(filesDirectory);
			active = context.ADD_FILE;
			break;
			
		case 3:
			deleteFile(filesDirectory);
			active = context.DELETE_FILE;
			break;
		case 4:
			searchFile(filesDirectory);
			active = context.SEARCH_FILE;
			break;
		case 5:
			output.info(GlobalConstants.STARS + "Returning to Main Menu" + GlobalConstants.STARS);
			active = context.MAIN_MENU;
			break;
		case 6:
			output.info(GlobalConstants.STARS + "End of program" + GlobalConstants.STARS);
			//	closing all the resources before ending the program.
			this.closeResources();
			System.exit(0);
			break;
		default: 
			break;
		}

	}


	//	getter methods

	public context getActiveContex()
	{
		return this.active;
	}

}
