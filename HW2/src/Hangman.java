import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

	private String[] words = new String[10];
	private String dispWord = "_______";
	private char[] dispArray = dispWord.toCharArray();
	private String gameWord;
	private char[] gameArray;
	private StringBuffer incorrectGuesses = new StringBuffer("");
	private int wrongGuesses =0;
	
	
	public int getWrongGuesses() {//returns the number of incorrect guesses
		return wrongGuesses;
	}
	
	public String selectGameWord() {//randomly chooses a word from the given list to use for the game
		Random rand = new Random();
		int num = rand.nextInt(10);
		gameWord = words[num];
		System.out.println(gameWord);
		gameArray = gameWord.toCharArray();
		return gameWord;
	}
	
	public String getGameWord() {//returns the word being used in the game
		return gameWord;
	}
	
	public String getCurrentWord() {//returns the current word based on the guesses inputed by the player, letters that haven't been guessed are displayed as underscores  
		StringBuilder builder = new StringBuilder();
		for(char s : dispArray) {
		    builder.append(s);
		}
		return builder.toString().toUpperCase();
    }
	
	public StringBuffer getIncorrectGuesses() {//returns the string of incorrect guesses
		return incorrectGuesses;
	}
	
	public boolean guessLetter(char guess) {//takes in the players guess and updates the display word if the guess is correct
		int temp = 0;
		for(int i=0;i<dispWord.length();i++) {
			if(gameArray[i]==guess) {
				temp = 1;
				dispArray[i] = guess;
			}
		}

		if(temp == 1) {
			return true;
		}
		else {
			if(wrongGuesses==0) {
				incorrectGuesses.append(guess);
				wrongGuesses++;
				return false;
			}
			else {
				incorrectGuesses.append(", " +guess);
				wrongGuesses++;
				return false;
			}
		}
	}
	
	public void showMan(int numParts)//displays the hangman based on the number of incorrect guesses
	{

		if (numParts == 0){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 1){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 2){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}

		if (numParts == 3){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|      __|");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 4){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 5){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 6){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 7){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       /");
			System.out.println("|      /  ");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
			
		if (numParts == 8){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
			
		if (numParts == 9){
				
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|    O/    ");
			System.out.println("|");
			System.out.println("____");
		
		}
		if (numParts == 10){
			
		System.out.println("________");
		System.out.println("|       |");
		System.out.println("|      ____");
		System.out.println("|     / .. \\");
		System.out.println("|    <   .  >");
		System.out.println("|     \\__^_/");
		System.out.println("|        |");
		System.out.println("|     o__|__o");
		System.out.println("|     	 |");
		System.out.println("|       / \\");
		System.out.println("|      /   \\");
		System.out.println("|    O/     \\O");
		System.out.println("|");
		System.out.println("____");
		}
		
	}
	

	public void setWords()//sets a list of words
	{
		
		words[0] = "notions";
		words[1] = "measure";
		words[2] = "product";
		words[3] = "foliage";
		words[4] = "garbage";
		words[5] = "minutes";
		words[6] = "chowder";
		words[7] = "recital";
		words[8] = "concoct";
		words[9] = "brownie";		
	}

	public String[] getWords()//returns the list of words
	{
		return words;
	}
	
	
}