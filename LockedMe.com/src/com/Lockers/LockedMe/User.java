package com.Lockers.LockedMe;

import java.io.File;
import java.util.List;

/**
 * Class that implements UserInterface "UI".<br>
 * All the user data and operations are defined in this class.<br>
 */
public class User extends InputHandler implements UI {

	public User(){
		super();
		output.info("Directory Created");
	}

	//	Hover on overridden methods to see documentation.
	@Override
	public void welcome()
	{
		output.info("****************************************\nApplication Name: LockedMe.com\nDeveloped By: Lockers Pvt Ltd.\n****************************************");
	}
	@Override
	public void displayMenu() {
		output.info("Main Menu\n1. Display Files\n2. Add File\n3. Delete File\n4. Search File\n5. Exit");
		handleMenuInput();
	}
	@Override
	public void closeResources() {
		input.close();
	}



	//	Input handling

	private int promptUserChoiceForMenu() 
	{
		output.info("Please enter your choice: ");
		int choice = input.nextInt();
		input.nextLine();

		while(choice < 1 || choice > 5)
		{
			output.info("Please enter a valid choice: ");
			choice = input.nextInt();
		}
		return choice;
	}

	@Override
	protected void handleMenuInput()
	{
		int choice = promptUserChoiceForMenu();
		List<File> files = listAllFiles(filesDirectory);
		switch(choice)
		{
		case 1: 
			if(files.isEmpty())
			{
				output.info("Files directory is empty.");
			}
			else
			{
				files.forEach(file->output.info(file.getName()));
			}
			break;
		case 2: 
			addFile(filesDirectory);
			break;
		case 3:
			deleteFile(filesDirectory);
			break;
		case 4:
			searchFile(filesDirectory);
			break;
		case 5:
			output.info("End of program");
			//	closing all the resources before ending the program.
			this.closeResources();
			System.exit(0);
			break;
		default:
			break;
		}
	}


}
