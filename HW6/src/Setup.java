import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Setup {

	public static AvlTree TREE = new AvlTree();//creates a tree that holds the words
	public static int line = 0; //a counter that keeps track of what line the reader is on
	
	public static void readFile(String filename) throws IOException{
		Scanner fileReader = new Scanner(new File(filename));//creates a scanner to read the file
		while(fileReader.hasNext()){//while there are still words in the file
			String wordline = fileReader.nextLine();//create a string that is the entire line
			line++;//increment the line number by 1
			String[] words = wordline.split(" ");//split the string of the entire line into separate words that are each an element of a list
			for(String x: words) {//apply the following function to every item x in the list of words
			if(!x.equals("")){//check if x is not blank
			if(Character.isLetter(x.charAt(0))) {//check if x is a word
				if(!Character.isLetter(x.charAt(x.length()-1))) {//check if there is punctuation attached to x
					x = x.substring(0, x.length()-1);//if there is remove it
				}
				Word newword = new Word(x);//create a new Word object called newword
				
				if(TREE.find(newword)!=null){//check to see if that Word is already in the tree
					Word dup = (Word) TREE.find(newword);//name that Word that is already in the tree dup
					dup.newLine(line);//update the Word's lines list because the same word appeared again in a new line
				}
				else {
					newword.newLine(line);//update the newword Word's lines list to include the current line
					TREE.insert(newword);//insert that Word into the AVL Tree
				}
			}
		}}
		}
	}
	
	public static void searchTree(String word){
		Word check = new Word(word);//create a new Word with the input word
		if(TREE.find(check)!=null){//check if the Word is in the AVL Tree
			System.out.println(TREE.find(check).toString());//print that Word
		}
		else {
			System.out.println(word +" is not in the file");//if it isn't in the tree, say so
		}
	}
	
	public static void count(String word) {
		Word check = new Word(word);//create a new Word with the input word
		if(TREE.find(check)!=null){//check if the Word is in the AVL Tree
			Word finl = (Word) TREE.find(check);//set finl to the Word object called for by the input
			int times = finl.getCount();//get how many times the word appeared in the file
			System.out.println(word +" appears " + times +" times");//print the number of times
		}
		else {
			System.out.println(word +" is not in the file");//if it isn't in the tree, say so
		}
	}
}
