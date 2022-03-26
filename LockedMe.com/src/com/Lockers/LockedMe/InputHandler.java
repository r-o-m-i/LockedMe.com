package com.Lockers.LockedMe;

import java.io.File;

/**
 *Handles user input and produces appropriate output
 */

public abstract class InputHandler extends FileHandler {

	protected File filesDirectory;
	protected boolean newFilesDirectoryCreated;

	protected InputHandler(){
		filesDirectory = new File("Files");

		//	Creates a Files directory if it doesnt exist
		if(!filesDirectory.exists())
		{
			newFilesDirectoryCreated = filesDirectory.mkdir();
		}
	}

	//	Getter methods 
	public File getFilesDirectory() {
		return filesDirectory;
	}

	public boolean isNewFilesDirectoryCreated() {
		return newFilesDirectoryCreated;
	}
	
	
	/**
	 * prompts for and handles the user input.
	 */
	protected abstract void handleMenuInput();
	
	
}
