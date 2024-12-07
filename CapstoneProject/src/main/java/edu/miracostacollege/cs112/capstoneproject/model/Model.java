package edu.miracostacollege.cs112.capstoneproject.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * The <code>Model</code> class represents the business logic (data and calculations) of the application.
 * In this app, it either loads burrito from a CSV file (first load) or a binary file (all
 * subsequent loads).  It is also responsible for saving data to a binary file.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Model {

	 static final String BINARY_FILE = "ShoppingCart.dat";

	/**
	 * Determines whether the binary file exists and has data (size/length > 5L bytes).
	 * @return True if the binary file exists and has data, false otherwise.
	 */
	public static boolean binaryFileHasData()
	{
		File binaryFile = new File(BINARY_FILE);
		return (binaryFile.exists() && binaryFile.length() > 5L);
	}

	/**
	 * Populates the list of all vehicles from the binary file. This will be called everytime the application loads,
	 * other than the very first time, since it needs initial data from CSV.
	 *
	 * @return The list of all vehicles populated from the binary file
	 */
	public static ObservableList<allClothes> populateListFromBinaryFile()
	{
		ObservableList<allClothes> allClothes = FXCollections.observableArrayList();
		// TODO: Create a File reference to the binary file
		// TODO: Check to see if the binary file exists
		// TODO: Instantiate an ObjectInputStream reference to the binary file for reading
		// TODO: Create a temp array of Vehicle objects to read from the binary file
		// TODO: Initialize the temp array from the binary file reader.
		// TODO: Add the temp array to the collection of all vehicles (list)
		// TODO: Close the binary file reader.
		File binaryFile = new File(BINARY_FILE);
		if (binaryFileHasData()) {
			try {
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
				allClothes[] tempArray = (allClothes[]) fileReader.readObject();
				allClothes.addAll(tempArray);
				fileReader.close();
			} catch (Exception e) {
				System.err.println("Error opening file: " + BINARY_FILE + " for reading.\nCaused by: " + e.getMessage());
			}
		}
		return allClothes;
	}

	/**
	 * Saves the list of all burritos to the binary file. This will be called each time the application stops,
	 * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
	 * during the stop() method.
	 * @return True if the data were saved to the binary file successfully, false otherwise.
	 */
	public static boolean writeDataToBinaryFile(ObservableList<allClothes> allClothes)
	{
		// TODO: Create a File reference to the binary file
		// TODO: Instantiate an ObjectOutputStream reference to the binary file for writing
		// TODO: Create a temp array of Vehicle objects to read from the binary file (length should match list size)
		// TODO: Loop through the temp array and initialize each element to the corresponding element in the list
		// TODO: Write the temp array object to the binary file writer
		// TODO: Close the binary file writer and return true.
		// TODO: If an exception occurs, print its message and return false.
		File binaryFile = new File(BINARY_FILE);
		try {
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
			allClothes[] tempArray = new allClothes[allClothes.size()];
			allClothes.toArray(tempArray);
			fileWriter.writeObject(tempArray);
			fileWriter.close();
			return true;
		}
		catch (Exception e)
		{
			System.err.println("Error writing binary file: " + BINARY_FILE + "\n" + e.getMessage());
			return false;
		}
	}


}
