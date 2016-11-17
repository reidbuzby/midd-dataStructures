import java.util.Random;
import java.util.Scanner;

public class HiLo {
	public static void main(String[] args) {
		boolean playing2 = true;
		while(playing2) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome! Enter integer for end of range (must be > 0):");
		int max = scan.nextInt();
		int count = 0;
		boolean playing = true;
		Random rand = new Random();
		int num = rand.nextInt(max);
		while(playing) {
		System.out.println("Enter guess or 0 to quit: ");
		int guess = scan.nextInt();
		if (guess == 0) {
			playing = false;
			System.out.println("You quit!");
		}
		else {
		if (guess > num) {
			System.out.println("Too high.");
			count++;
		}
		if (guess < num) {
			System.out.println("Too low.");
			count++;
		}
		if (guess == num) {
			count++;
			System.out.println("Correct! That took you "+count+" guesses.");
			playing = false;
		}
		}
		
	}
		System.out.println("Play again (y/n)?");
		Scanner scan2 = new Scanner(System.in);
		int yn = scan2.next().charAt(0);
		if(yn == 'y') {
			playing2 = true;
			playing = true;
		}
		if(yn == 'n') {
			System.out.println("Thanks for playing!");
			playing2 = false;
			playing = false;
		}
		scan.close();
		scan2.close();
		
}

}
}