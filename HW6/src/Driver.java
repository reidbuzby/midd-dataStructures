import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a filename: ");//ask for the file to analyze
		String filename = scan.nextLine();
		Setup setup = new Setup();
		setup.readFile(filename);//calls the readFile method in the Setup class which creates the AVL Tree containing every word in the file
		boolean running = true;
		while(running){
		System.out.println("Please enter a command (a, s, c, or q)");//ask how to analyze the file
		char choice = scan.nextLine().charAt(0);
		switch(choice) {
		case 'a': setup.TREE.printTree(); //simply print the entire tree. Because it prints in a sorted way, it will be alphabetical
				  break;
		case 's': System.out.println("Word to find: ");//ask for what word to search for
				  String word = scan.nextLine();
				  setup.searchTree(word);//calls the searchTree method in the Setup class which finds and returns the lines that word appears in
				  break;
		case 'c': System.out.println("Word to find: ");//ask for what word to search for
		  		  String word2 = scan.nextLine();
			      setup.count(word2);//calls the count method in the Setup class which finds and returns the number of times that word appears
			      break;
		case 'q': System.out.println("Goodbye");
				  running = false;//quit
				  break;
		}
		}
		
	}
}

