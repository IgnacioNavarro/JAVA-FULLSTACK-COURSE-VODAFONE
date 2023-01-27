package types;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import types.Thread2;

public class Thread1 extends Thread{
	
    public Object lock = this;
    public boolean pause = false;
    
    public void pause()
    {
        pause = true;
    }

    public void isContinue()
    {
    	pause = false;
    	 synchronized (lock)
         {
             lock.notifyAll();
         }
     }
    
    private void pauseThread () throws InterruptedException
    {
        synchronized (lock)
        {
            if (pause)
                lock.wait(); // Note that this can cause an InterruptedException
        }
    }
	
	
	public static void printWelcome() {
		System.out.println(
				"\n \n\nPress: \n 1: List all documents in asc. order     2: File operations     3:Close");
	}

	
	public static void listDoc() {
		File folder = new File("src/files");
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		System.out.println("Files sorted in asc. order:");
		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	
	
	@SuppressWarnings("resource")
	public void run() {
		Scanner scanner = new Scanner(System.in);
		Thread t = null;
		while (true) {
			printWelcome();
			String selections = scanner.next();
			try {
				int selection = Integer.parseInt(selections);
				
				if (selection == 3) {
					if (t != null && t.isAlive()) {
						t.interrupt();
					}
					System.out.println("Goodbye! Aplication ended.");
					break;
				}
				if (selection == 2) {
					try {
						pauseThread();
						if (t != null && t.isAlive()) {
							t.interrupt();
						}
						t = new Thread2(); 
				        t.start(); 
				        break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				} else if (selection == 1) {
					listDoc();
				} else {
					System.out.println("Select a number from the list.");
	   
				}
			}catch(Exception e){
				System.out.println("Select a number.");
			}
			
			
			

		}
	}

}
