package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileActions {
	
	public void createFile() {
		
		try {
			File myFile= new File("C:\\a.txt");
				if(myFile.createNewFile()) {
					System.out.println("File created successfully"+ myFile.getName());
				}
				else {
					System.out.println("File already exists");
				}
			
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file");
			
			
		}
		
	}
	
	public void writeFile() {
		
		try {
			FileWriter writeFile = new FileWriter("C:\\a.txt");
				writeFile.write("megatesting");
				writeFile.close();
				System.out.println("File content successfully written");
			}
		catch (IOException e) {
			System.out.println("An error occurred while writing");
			e.printStackTrace();
			
		}
	}

}
