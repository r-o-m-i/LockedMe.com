package com.Lockers.LockedMe;

import java.io.File;
import java.io.IOException;
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
	
	@Override
	public String promptFileName() {
		output.info("Please enter a file name: ");
		return input.nextLine();
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
		List<File> files = listAllFiles();
		String fileName = null;
		
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
			fileName = promptFileName();
			File newFile = new File("Files/" + fileName);
			if(files.contains(newFile))
			{
				output.info(fileName + " already exists.");
			}
			else
			{
				try {
					boolean creationSuccessful = newFile.createNewFile();
					if(creationSuccessful)
					{
						output.info(fileName + " added successfully.");
					}
					else
					{
						output.info(fileName + " file can not be added.");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case 3:
			fileName = promptFileName();
			files = listAllFiles();
			File trash = new File("Files/" + fileName);
			
			if(files.contains(trash))
			{
				try {
				if(files.get(files.indexOf(trash)).delete())
					output.info(fileName + " deleted successfully.");
				else
					output.info("Cannot delete file: " + fileName);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				output.info("File: \"" + fileName + "\" does not exist.");
			}
			break;
		case 4:
			fileName = promptFileName();
			files = listAllFiles();
			File findFile = new File("Files/" + fileName);
			
			if(files.contains(findFile))
			{
				output.info(fileName + " exists at: " + files.get(files.indexOf(findFile)).getAbsolutePath());
			}
			else
			{
				output.info("File: \"" + fileName + "\" does not exist.");
			}
			
			break;
		case 5:
			output.info("End of program");
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	
}
