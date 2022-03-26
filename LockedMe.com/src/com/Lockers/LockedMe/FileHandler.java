package com.Lockers.LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Performs all the file handling operations required by the user
 */
public abstract class FileHandler {
	
	/**
	 * lists all the files contained in the files directory
	 * @return 
	 * returns the List containing all the file names that are sorted in ascending order
	 */
	protected List<File> listAllFiles(File parentDirectory)
	{
		List<File> files = Arrays.asList(parentDirectory.listFiles());
		files.sort((f1,f2)->f1.getName().compareTo(f2.getName()));
		return files;
	}
	
	/**
	 * prompts for file name and returns it
	 * @return
	 */
	private String promptFileName() {
		UI.output.info("Please enter a file name: ");
		return User.input.nextLine();
	}
	
	/**
	 * adds a new file to the parent directory.<br>
	 * @param filesDirectory 
	 * Directory to which new file is added
	 */
	protected void addFile(File filesDirectory)
	{
		List<File> files = listAllFiles(filesDirectory);
		String fileName = promptFileName();
		File newFile = new File("Files/" + fileName);
		if(files.contains(newFile))
		{
			UI.output.info(fileName + " already exists.");
		}
		else
		{
			try {
				boolean creationSuccessful = newFile.createNewFile();
				if(creationSuccessful)
				{
					UI.output.info(fileName + " added successfully.");
				}
				else
				{
					UI.output.info(fileName + " file can not be added.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * deletes the specified file from the files directory.<br>
	 * @param filesDirectory
	 * Directory from which files are deleted.
	 */
	protected void deleteFile(File filesDirectory)
	{
		List<File> files = listAllFiles(filesDirectory);
		String fileName = promptFileName();
		File trash = new File("Files/" + fileName);
		
		if(files.contains(trash))
		{
			try {
			if(files.get(files.indexOf(trash)).delete())
				UI.output.info(fileName + " deleted successfully.");
			else
				UI.output.info("Cannot delete file: " + fileName);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			UI.output.info("File: \"" + fileName + "\" does not exist.");
		}
	}
	
	/**
	 * Searches for a specified file in the given files directory.<br>
	 * @param filesDirectory
	 * directory in which files are searched.
	 */
	protected void searchFile(File filesDirectory)
	{
		List<File> files = listAllFiles(filesDirectory);
		String fileName = promptFileName();
		File findFile = new File("Files/" + fileName);
		
		if(files.contains(findFile))
		{
			UI.output.info(fileName + " exists at: " + files.get(files.indexOf(findFile)).getAbsolutePath());
		}
		else
		{
			UI.output.info("File: \"" + fileName + "\" does not exist.");
		}
	}
	
}
