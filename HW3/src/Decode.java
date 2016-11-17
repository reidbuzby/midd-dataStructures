import java.io.*;
import java.util.*;


public class Decode {
	
	private char[] textArray;
	private int[] freqArray;
	private char[] mapArray;
	
	
	public void textToArray(String filename) throws IOException {
		Scanner fileReader = new Scanner(new File(filename));
		String finl = "";
		while(fileReader.hasNext()){//puts every letter or punctuation from the message into a string
			String next = fileReader.nextLine();
			finl = finl + (next);
		}
		textArray = new char[finl.length()];
		for(int i =0;i<finl.length();i++) {//creates an array called textArray with each element as an individual letter or punctuation from the message
			textArray[i]=finl.charAt(i);
		}
		fileReader.close();	
	}
	
	public void frequencyAnalysis() {
		freqArray = new int[26];//creates a new array called freqArray with a length of 26
		for(int i = 0;i<textArray.length;i++) {//checks through the message for letters, every time it sees a letter it increases the count for that letter by 1 in the freqArray
			if(Character.isLetter(textArray[i])) {
			int i2 = ((int) textArray[i]) - 97;
			freqArray[i2]++;
		}//the final array has a count for how many times every letter appears
		}
	}
	
	public void freqMaping() {
		mapArray = new char[26];
		int[] sortedFreqArray = freqArray.clone();
		Arrays.sort(sortedFreqArray);//duplicates freqArray and sorts it so the minimum letter occurrences comes first
		String freq1 = "etaoinshrdlucmfwypvbgkqjxz";//a string with the frequency of letters in the alphabet in decending order 
		char[] freq = freq1.toCharArray();
		int maximum;
		for(int i=0;i<freq.length;i++) {//checks for the letter with the max number of occurrences and sets that coded letter to the plaintext letter with the same amount of occurrences in a new array called mapArray
			int maxnum = 0;
			maximum = sortedFreqArray[25-i];
			for(int k=0;k<freqArray.length;k++) {
				if(freqArray[k]==maximum) {
					maxnum = k;
				}
			}
			mapArray[maxnum] = freq[i];
			freqArray[maxnum] = 0;
		}
	}
	
	public String ciphToPlain() {
		String finl2 = "";
		char[] finl = new char[textArray.length];
		for(int i=0; i<textArray.length;i++) {//goes through the original message and changes each letter to the plaintext equivalent based on the mapping done in the freqMapping() method
			if(Character.isLetter(textArray[i])) {
			int i2 = ((int) textArray[i]) -97;
			finl[i] = mapArray[i2];
			}
			else {
				finl[i] = textArray[i];
			}
		}
		for(int i=0;i<finl.length;i++) {//converts the message from an array to a string
			finl2 = finl2 + finl[i];
		}
		return finl2;
	}
	
	
}