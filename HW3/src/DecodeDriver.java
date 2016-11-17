import java.io.IOException;
import java.util.Scanner;

public class DecodeDriver {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while(running) { //allows user to decode multiple messages
		System.out.println("Enter a file name with an encoded message (q to quit)");
		String next = scan.nextLine();//takes in the name of the decoded message file
		if(next.charAt(0)=='q') {//quits if the user inputs q
			running=false;
			break;
		}
		else{
		String filename = next;
		Decode d1 = new Decode();
		d1.textToArray(filename);//turns the file into an array
		d1.frequencyAnalysis();//performs frequency analysis on the array
		d1.freqMaping();//determines the mapping between letters
		Message m1 = new Message();
		System.out.println("Decoded message printed to " + m1.writeDecoded(d1.ciphToPlain(), filename));//decodes and writes the message
		System.out.println("Message: " + d1.ciphToPlain());//prints the message
		}
	}
	}
}
