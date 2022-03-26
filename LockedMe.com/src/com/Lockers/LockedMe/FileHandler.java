package com.Lockers.LockedMe;

import java.io.File;
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
	protected abstract List<File> listAllFiles();
	
}
