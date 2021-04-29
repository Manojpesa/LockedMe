package com.simplilearn.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	public void addFile(String directory, String name) {

		try {
			File file = new File(directory + "\\" + name);

			boolean result = file.createNewFile(); // creates a new file
			if (result) {
				System.out.println("File is created " + file.getCanonicalPath());

			} else {
				System.out.println("File already exist at location: " + file.getCanonicalPath());
			}
		} catch (IOException e) {
			System.out.println("Exception while adding this file: " + e.getMessage());
		}

	}

	public void deleteFile(String directory, String name) {
		try {
			File file = new File(directory + "\\" + name);

			boolean result = file.delete();
			if (result) {
				System.out.println(file.getName() + " is deleted");

			} else {
				System.out.println("Failed, please try again with a valit directory and file name.");
			}
		} catch (Exception e) {
			System.out.println("Exception while deleting this file: " + e.getMessage());
		}
	}

	public boolean renameFile(String directory, String name1, String name2) {
		File oldName = new File(directory + "\\" + name1);
		File newName = new File(directory + "\\" + name2);

		return oldName.renameTo(newName);
	}

	public void contentsOfFile(String directory, String name) {
		try {
			File file = new File(directory + "\\" + name);

			FileReader fileReader = new FileReader(file); // reads the file
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			bufferReader.close();
			System.out.println("Contents of File:\n");
			System.out.println(stringBuffer.toString());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void editFile(String directory, String name, String text) {
		try {

			File file = new File(directory + "\\" + name);

			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

			bufferWriter.write(text);
			bufferWriter.flush();
			bufferWriter.close();
			System.out.println("file is succesfully Edited");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String[] getFilesList(String directory) {

		File file = new File(directory);
		String[] files = file.list();

		if (files == null) {
			System.out.println("There are no files in the provided Directory" + "\nTry again");
			return null;
		}
		return files;
	}

}
