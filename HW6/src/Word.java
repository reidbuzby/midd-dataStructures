import java.util.LinkedList;

public class Word implements Comparable<Word>{
	private String word;//the word pertaining to this object
	private LinkedList<Integer> lines = new LinkedList<Integer>();//a list containing each line number where the word appears
	private int count = 0;//a count variable that counts the number of times the word appears
	
	public Word(String word){//constructor
		this.word=word;
	}
	
	public String toString() {//toString method that returns the word and then the lines where the word appears
		String finl = "";
		for(int x: lines) {
			finl = finl +  x+" ";
		}
		return word +" "+ finl;
	}
	
	public int getCount() {//get method for the count variable
		return count;
	}
	
	public void newLine(Integer e) {//updates the lines list
		if(!lines.contains(e)){
		lines.add(e);//adds the inputed number to the lines list
		}
		count++;//increase count by 1
	}
	
	public int compareTo(Word o) {//returns -1 if this object comes alphabetically before the other object, returns 1 if its the opposite, and 0 if they are the same word
		if(word.equals(o.word)){//if the words are equal
			return 0;
		}
		if((int) word.charAt(0)<(int) o.word.charAt(0)){//checks the alphabetic order of the first letters of each word
			return -1;
		}
		if((int) word.charAt(0)>(int) o.word.charAt(0)){//checks the alphabetic order of the first letters of each word
			return 1;
		}
		else{//if the first letters are the same
			if(word.substring(1).equals("")){//makes sure the first word has more letters after the first letter, if it doesn't return -1
				return -1;
			}
			if(o.word.substring(1).equals("")){//makes sure the second word has more letters after the first letter, if it doesn't return 1
				return 1;
			}
			else{//if they both have more letters after the first letter
				return checkNext(word.substring(1), o.word.substring(1));//calls the checkNext method on both words, with everything but the first letters as inputs
			}
		}
	}
	
	public int checkNext(String a, String b){//basically the same as the compareTo method, but done recursively in order to check each letter of each word against each other to find which one comes first alphabetically. It assists compareTo, but since Java will only use compareTo with certain parameters, the entire recursive function could not be written in just the compareTo method
		if((int) a.charAt(0) < (int) b.charAt(0)){//checks the alphabetic order of the first letters of each word
			return -1;
		}
		if((int) a.charAt(0) > (int) b.charAt(0)){//checks the alphabetic order of the first letters of each word
			return 1;
		}
		else{//if the first letters are the same
			if(a.substring(1).equals("")){//makes sure the first word has more letters after the first letter, if it doesn't return -1
				return -1;
			}
			if(b.substring(1).equals("")){//makes sure the second word has more letters after the first letter, if it doesn't return -1
				return 1;
			}
			else{//if they both have more letters after the first letter
			return checkNext(a.substring(1), b.substring(1));//recursively check the rest of the letters against each other
			}
		}
	}
	

	
}
