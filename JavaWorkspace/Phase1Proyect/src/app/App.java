package app;

import java.util.Scanner;

import types.Developer;
import types.Thread1;

public class App {

	public static Developer setUpDev() {
		Developer d1 = new Developer();
		d1.setName("Ignacio");
		d1.setSurname("Navarro");
		return d1;
	}

	public static void printWelcome() {
		System.out.println(
				"\n \n\nPress: \n 1: List all documents in asc. order     2: File operations     3:Close");
	}
	
	public static void printWelcomeBusines() {
		System.out.println(
				"\n \n\nPress: \n 4: Add new document     5: Delete document      6: Search document     7:Back");
	}



	public static void main(String[] args) {
		Developer d1 = setUpDev();
		System.out.println("Welcome to FileManager!");
		System.out.println("Developed by: " + d1.printDeveloper());

		Scanner scanner = new Scanner(System.in);
		Thread t = null;
			t = new Thread1(); 
	        t.start(); 

	}
}