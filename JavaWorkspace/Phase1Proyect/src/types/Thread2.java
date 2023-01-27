package types;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Thread2 extends Thread {
	
	public static void printWelcomeBusines() {
		System.out.println(
				"\n \n\nPress: \n 4: Add new document     5: Delete document      6: Search document     7:Back");
	}

	public static void addDoc(Scanner scanner) {
		System.out.println("Enter the name of the file:");
		String fileName = scanner.next();
		fileName = fileName + ".txt";
		System.out.println("Enter the body of the file:");
		try {
			PrintWriter writer = new PrintWriter("src/files/" + fileName, "UTF-8");
			scanner.nextLine();
			String fileBody = scanner.nextLine();
			writer.println(fileBody);
			writer.close();
			System.out.println("File saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readFile(String fileName) {
		File file = new File("src/files/" + fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void delDoc(Scanner scanner) {
		System.out.println("Enter the name of the file to delete:");
		String fileName = scanner.next();
		fileName = fileName + ".txt";
		File file = new File("src/files/" + fileName);
		if (file.delete()) {
			System.out.println("File deleted successfully!");
		} else {
			System.out.println("Failed to delete the file!");
		}
	}

	public static void searchDoc(Scanner scanner) {
		System.out.println("Enter the name of the file to search:");
		String fileName = scanner.next();
		fileName = fileName + ".txt";
		File file = new File("src/files/" + fileName);
		if (file.exists()) {
			System.out.println("File Found!");
			readFile(fileName);
		} else {
			System.out.println("File Not Found!");
		}
	}

	public void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			printWelcomeBusines();
			
			
			try {
				int subSelection = scanner.nextInt();
				
				
				Thread t = null;
				if (subSelection == 7) {
					System.out.println("Going back to main menu...");
					t = new Thread1(); 
			        t.start(); 
					break;
				}
				if (subSelection == 4) {
					addDoc(scanner);
				} else if (subSelection == 5) {
					delDoc(scanner);
				} else if (subSelection == 6) {
					searchDoc(scanner);
				} else {
					System.out.println("Select a number from the list.");
				}
			}catch (Exception e) {
				System.out.println("Select a number.");
			}
			
		}
	}

}
