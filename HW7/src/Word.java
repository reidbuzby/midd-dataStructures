import java.util.LinkedList;

public class Word implements Comparable<Word> {
	
	private Driver spd = new Driver();
	private SeparateChainingHashTable dictionary = spd.dictionary;
	private String name;
	private boolean isMisspelled;
	private LinkedList<Integer> line = new LinkedList<Integer>();
	private boolean ignore;
	private LinkedList<String> newWords = new LinkedList<String>();
	private boolean skip = false;
	
	public Word(String name) {//constructor
		this.name = name;
	}
	
	public void setSkip(boolean skip) {//set a boolean for whether or not to skip a word
		this.skip=skip;
	}
	
	public boolean getSkip() {//getter for skip
		return skip;
	}
	
	public void setName(String name) {//set the name
		this.name = name;
	}
	
	public void setSpelling(boolean spell) {//boolean for whether the word is correctly spelled
		isMisspelled = spell;
	}
	
	public boolean getSpelling() {//getter for spelling
		return isMisspelled;
	}
	
	public void addLineInt(Integer line) {//add a line where the word appears
		this.line.add(line);
	}
	
	public void setLineList(LinkedList<Integer> list) {//set the list of lines
		line = list;
	}
	
	public String getLineString() {//get the list of lines as a string
		String finl = "";
		for(int x: line) {
			finl = finl +" "+ x;
		}
		return finl;
	}
	
	public LinkedList<Integer> getLineList() {//get the list of lines as a list
		return line;
	}
	
	public void setIgnore(boolean ig) {//boolean for whether to ignore or not
		ignore = ig;
	}
	
	public boolean isIgnore() {//getter for ignore
		return ignore;
	}
	
	public String toString() {//toString method
		return name;
	}
	
	public LinkedList<String> spellCheck() {//performs all the spell check methods
		this.checkSwap();
		this.checkDelete();
		this.checkInsert();
		this.checkReplace();
		this.checkSplit();
		return newWords;
	}
	
	public LinkedList<String> checkSwap() {//swaps every subsequent letter and returns a list of possible correctly spelled words
		Driver spd2 = new Driver();
		for(int i=0;i<name.length()-1;i++) {
			if(i==0) {
			String temp = name;
			temp = name.charAt(i+1) + "" + name.charAt(i) + "" + name.substring(i+2);
			if(dictionary.contains(temp)&&!newWords.contains(temp)) {
				newWords.add(temp);
				}
			}
			else {
				String temp = name;
				temp = name.substring(0, i+1) + "" + name.charAt(i+1) + "" + name.charAt(i) + "" + name.substring(i+2);
				if(dictionary.contains(temp)&&!newWords.contains(temp)) {
					newWords.add(temp);
					}
				}
		}
		return newWords;
	}
	
	public LinkedList<String> checkInsert() {//inserts every uppercase and lowercase letter in every possible spot and returns a list of correctly spelled possibilities
		
		char[] alphabet = {'a','b','c','d','e','f','g','e','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(char x: alphabet) {
			if(dictionary.contains(x + "" + name)&&!newWords.contains(x + "" + name)) {
				newWords.add(x + "" + name);
			}
		}
		for(char x: upper) {
			if(dictionary.contains(x + "" + name)&&!newWords.contains(x + "" + name)) {
				newWords.add(x + "" + name);
			}
		}
		for(char x: alphabet) {
			if(dictionary.contains(name + "" + x)&&!newWords.contains(name + "" + x)) {
				newWords.add(name + "" + x);
			}
		}
		for(int i=0;i<name.length()-1;i++){
			for(char x: alphabet) {
				String temp = name.substring(0, i+1) + "" + x + "" + name.substring(i+1);
				if(dictionary.contains(temp)&&!newWords.contains(temp)){
					newWords.add(temp);
				}
			}
		}
		return newWords;
	}
	
	public LinkedList<String> checkDelete() {//deletes each subsequent letter
		
		String temp = name.substring(0, name.length()-1);
		if(dictionary.contains(temp)&&!newWords.contains(temp)) {
			newWords.add(temp);
		}
		temp = name.substring(1);
		if(dictionary.contains(temp)&&!newWords.contains(temp)){
			newWords.add(temp);
		}
		for(int i=0;i<name.length()-2;i++) {
			if(dictionary.contains(name.substring(0, i+1)+""+name.substring(i+2))&&!newWords.contains(name.substring(0, i+1)+""+name.substring(i+2))){
				newWords.add(name.substring(0, i+1)+""+name.substring(i+2));
			}
		}
		return newWords;
	}
	
	public LinkedList<String> checkReplace() {//replaces every letter with each letter in the alphabet
		char[] alphabet = {'a','b','c','d','e','f','g','e','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(char x: upper) {
		String temp = x + "" +name.substring(1);
		if(dictionary.contains(temp)&&!newWords.contains(temp)) {
			newWords.add(temp);
		}
		}
		for(int i=0;i<name.length();i++) {
			for(char x: alphabet) {
				if(i==0) {
					String temp = x + "" +name.substring(1);
					if(dictionary.contains(temp)&&!newWords.contains(temp)) {
						newWords.add(temp);
					}
				}
				else {
				String temp = name.substring(0, i) + "" + x + "" + name.substring(i+1);
				if(dictionary.contains(temp)&&!newWords.contains(temp)) {
					newWords.add(temp);
				}
			}
			}
		}
		return newWords;
	}
	
	public LinkedList<String> checkSplit() {//splits the word in two at every point
		
		for(int i=0;i<name.length()-2;i++) {
		String[] twoWords = new String[2];
		twoWords[0] = name.substring(0, i+1);
		twoWords[1] = name.substring(i+2);
		if(dictionary.contains(twoWords[0])&&dictionary.contains(twoWords[1])&&!newWords.contains(twoWords[0]+" "+twoWords[1])){
			newWords.add(twoWords[0]+" "+twoWords[1]);
		}
		}
		return newWords;
	}
	
	public int compareTo(Word o) {//returns -1 if this object comes alphabetically before the other object, returns 1 if its the opposite, and 0 if they are the same word
		if(name.equals(o.name)){//if the words are equal
			return 0;
		}
		if((int) name.charAt(0)<(int) o.name.charAt(0)){//checks the alphabetic order of the first letters of each word
			return -1;
		}
		if((int) name.charAt(0)>(int) o.name.charAt(0)){//checks the alphabetic order of the first letters of each word
			return 1;
		}
		else{//if the first letters are the same
			if(name.substring(1).equals("")){//makes sure the first word has more letters after the first letter, if it doesn't return -1
				return -1;
			}
			if(o.name.substring(1).equals("")){//makes sure the second name has more letters after the first letter, if it doesn't return 1
				return 1;
			}
			else{//if they both have more letters after the first letter
				return checkNext(name.substring(1), o.name.substring(1));//calls the checkNext method on both words, with everything but the first letters as inputs
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

	

