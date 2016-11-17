import java.util.Scanner;

public class HangmanDriver {
	static char nextGuess;   //player guess as a char
	static String nextGuess2; //player guess as a word
	
	public boolean promptGuess() { //prompts the player to guess a leter or word
		Scanner scan = new Scanner(System.in);
		System.out.println("Type L to guess a letter or W to guess a word: ");
		if(scan.next().charAt(0) == 'l') {
			scan.nextLine();
			System.out.println("Enter your letter guess: ");
			nextGuess = scan.nextLine().charAt(0);
			return true;
		}
		else {
			scan.nextLine();
			System.out.println("Enter your word guess: ");
			nextGuess2 = scan.nextLine();
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hangman");
		boolean playing = true; //allows the game to loop if the player wants to play multiple games
		while(playing) {
		boolean win = false; //checks if the player has won or not
		Scanner scan = new Scanner(System.in);
		HangmanDriver d1 = new HangmanDriver();
		Hangman h1 = new Hangman();
		h1.setWords();
		String secretWord = h1.selectGameWord();
		System.out.println("Your secret word is: " + h1.getCurrentWord());
		h1.showMan(h1.getWrongGuesses());
		System.out.println("Incorrect guesses: " + h1.getIncorrectGuesses());
		while(! win) { //allows the player to keep guessing until they have won or lost
		if(h1.getWrongGuesses()==10) {
			win = true;
			System.out.println("You lost...");
			break;
		}
		if(d1.promptGuess()) {
			if(h1.guessLetter(nextGuess)) { //if the letter guess is correct
				System.out.println("Correct!");
				System.out.println(h1.getCurrentWord());
				h1.showMan(h1.getWrongGuesses());
				System.out.println("Incorrect guesses: " + h1.getIncorrectGuesses());
				
				if(h1.getCurrentWord().equals(h1.getGameWord())) {
					win = true;
				}
			}
			else { //if the letter guess is incorrect
				System.out.println("Incorrect");
				System.out.println(h1.getCurrentWord());
				h1.showMan(h1.getWrongGuesses());
				System.out.println("Incorrect guesses: " + h1.getIncorrectGuesses());
			
			}
		}
		else {
			if(nextGuess2.equals(h1.getGameWord())) {//if the word guess is correct
				System.out.println("Correct!");
				win = true;
			}
			else {//if the word guess is incorrect
				System.out.println("Incorrect. You lost.");
				win = true;
			}
		}
		}
		System.out.println("Play again? (y/n)");//asking the player if they want to play another game
		char yn = scan.next().charAt(0);
		if(yn == 'n') {
			System.out.println("Goodbye");
			playing = false;
		}
	}
}
}
