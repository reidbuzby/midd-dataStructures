import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver {
	
	public static int line = 0;
	public static SeparateChainingHashTable dictionary = new SeparateChainingHashTable();
	
	public static void main(String[] args) throws IOException {
		boolean loopingFile = true;
		while(loopingFile) {
		Scanner filereader = new Scanner(new File(args[0]));//read in the dictionary
		while(filereader.hasNext()) {
			String input = filereader.next();
			dictionary.insert(input);//add each word into a dictionary hash table
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file to spell check: ");
		String filename = scan.nextLine();
		Scanner filereader2 = new Scanner(new File(filename));
		LinkedList<Word> words = new LinkedList<Word>();//creates a linked list that stores every word in the file
		while(filereader2.hasNextLine()) {
			String wordline = filereader2.nextLine();//create a string that is the entire line of text
			line++;//increment the line number by 1
			String[] wordarray = wordline.split(" ");//split each word into an element of an array
			for(String x: wordarray) {
				Word word = new Word(x);
				word.addLineInt(line);
				if(dictionary.contains(x)) {//for each word check if it is spelled correctly or not and update its spelling boolean
					word.setSpelling(true);
				}
				else {
					word.setSpelling(false);
				}
				words.add(word);
			}
			Word line = new Word("\n");
			words.add(line);
		}
		LinkedList<Word> wrongWords = new LinkedList<Word>();//create a list of incorrectly spelled words
		for(Word x: words) {
			if(x.getSpelling()==false||x.toString().equals("\n")) {
				wrongWords.add(x);//add all the wrong words to the list
			}
		}
		LinkedList<Word> wrongWordsTemp = new LinkedList<Word>();//create a temporary list of wrong words
		for(Word x: wrongWords) {
			Word word = new Word(x.toString());
			word.setLineList(x.getLineList());
			wrongWordsTemp.add(word);
		}
		while(loopingFile) {
		System.out.println("Print words(p), or quit(q)?");
		char answer = scan.nextLine().charAt(0);
		LinkedList<String> alreadyChecked = new LinkedList<String>();
		switch(answer) {
		case 'p': for(Word x: wrongWords) {//user chooses to print the words
				  String nameTemp = x.toString();
				  if(alreadyChecked.contains(x.toString())||x.toString().equals("\n")) {
				  }
				  else {
				  	System.out.println("--" + x + " " + x.getLineString());
				  	System.out.println("ignore all(i), replace all(r), next(n)?");
				  	char choice = scan.nextLine().charAt(0);
				  	switch(choice) {
				  	case 'i': alreadyChecked.add(x.toString());//if user chooses to ignore the word
				  			  break;
				  	
				  	case 'r': String temp = "";//if the user chooses to replace the word
				  			  int count = 1;
				  			  for(String y: x.spellCheck()) {//get all of the possible spellings
				  				 temp = temp + " (" + count + ")" + " " + y;//print them
				  				 count++;
				  			  }
				  			  System.out.println("Replace with" + temp + ", or next(n)?");
				  			  String answer2 = scan.nextLine();
				  			  if(Character.isLetter(answer2.charAt(0))) {
				  				  if(answer2.charAt(0)=='n') {//if the user skips
				  					  
				  				  }
				  			  }
				  			  else {//else change the spelling to what they choose
				  				  x.setName(x.spellCheck().get(Integer.parseInt(answer2)-1));
				  				  for(Word y: wrongWords) {
				  					  if(y.toString().equals(nameTemp)) {
				  						  y.setName(y.spellCheck().get(Integer.parseInt(answer2)-1));
				  						  alreadyChecked.add(y.toString());
				  					  }
				  				  }
				  			  }
				  			  break;
				  	
				  	case 'n': break;//user skips the word
				  	}
				  }
				}
		        System.out.println("Spell check complete");
		        break;
				
		case 'q': System.out.println("Goodbye");
		  String outfile = filename.substring(0, filename.length()-4) + "_corrected.txt"; 
		  Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile)));
		  for(Word x: words) {//write all of the new words on a file
			  if(x.toString().equals("\n")) {
				  writer.write("\n");
			  }
			  else {
				  writer.write(x + " ");
			  }
		  }
		  writer.close();
		  String outfile2 = filename.substring(0, filename.length()-4) + "_sorted.txt"; 
		  Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile2)));
		  LinkedList<Word>[] bucket = new LinkedList[52];//creates hash table to contain all incorrect words
		  LinkedList<String> alreadyUsed = new LinkedList<String>();
		  LinkedList<Integer> delete = new LinkedList<Integer>();
		  for(int i=0;i<wrongWords.size();i++) {//change the list of incorrect words so their are no duplicates and every instance where the word appears is correctly represented in the Word class
			  for(int j=0;j<wrongWords.size();j++) {
				  if(wrongWords.get(i).toString().equals("\n")||wrongWords.get(j).toString().equals("\n")){
				  }
				  else if(wrongWords.get(i).toString().equals(wrongWords.get(j).toString())&&i!=j&&!delete.contains(i)&&!delete.contains(j)) {
					  wrongWords.get(i).addLineInt(wrongWords.get(j).getLineList().get(0));
					  wrongWords.get(j).setSkip(true);
					  delete.add(j);
				  }
			  }
		  }
		  for(Word x: wrongWords) {//add each word to the hash table based on its first letter
			  if(x.toString().equals("\n")){
				  
			  }
			  else if(!x.getSkip()) {
			  if(!alreadyUsed.contains(x.toString())){
				  
				  int letter;
			  
				  if(Character.isUpperCase(x.toString().charAt(0))) {
					  letter = ((int) x.toString().charAt(0))-65;
				  }
				  
				  else{
					  letter = ((int) x.toString().charAt(0)-71); 
				  }
			  
				  if(bucket[letter]==null) {
					  bucket[letter] = new LinkedList<Word>();
				  }
			  
				  alreadyUsed.add(x.toString());
				  bucket[letter].add(x);
			  }
		  }
		  }
		 for(LinkedList<Word> x: bucket) {//for each bucket in the hash table
			 if(x!=null) {
				 if(x.size()==1) {//if the bucket is size 1 do nothing
					 
				 }
				 
				 else if(x.size()==2) {//if the bucket is size two order them alphabetically
					 Word minimum = new Word(null);
					 Word maximum = new Word(null);
					 if(x.get(0).compareTo(x.get(1))==-1) {
						 
					 }
					 else {
						 minimum.setName(x.get(1).toString());
						 minimum.setLineList(x.get(1).getLineList());
						 maximum.setName(x.get(0).toString());
						 maximum.setLineList(x.get(0).getLineList());
						 x.get(0).setName(minimum.toString());
						 x.get(0).setLineList(minimum.getLineList());
						 x.get(1).setName(maximum.toString());
						 x.get(1).setLineList(maximum.getLineList());
					 }
					 
				 }
					 
				 else if(x.size()==3) {//if the bucket is size 3 compare each and order them alphabetically
					 Word minimum = new Word(null);
					 Word middle = new Word(null);
					 Word maximum = new Word(null);
					 if(x.get(0).compareTo(x.get(1))==-1&&x.get(0).compareTo(x.get(2))==-1) {//0<1 0<2
							 minimum.setName(x.get(0).toString());
							 minimum.setLineList(x.get(0).getLineList());
							 if(x.get(1).compareTo(x.get(2))==-1){//1<2
								 middle.setName(x.get(1).toString());
								 middle.setLineList(x.get(1).getLineList());
								 maximum.setName(x.get(2).toString());
								 maximum.setLineList(x.get(2).getLineList());
							 }
							 else {//2<1
								 middle.setName(x.get(2).toString());
								 middle.setLineList(x.get(2).getLineList());
								 maximum.setName(x.get(1).toString());
								 maximum.setLineList(x.get(1).getLineList());
							 }
						 }
					 else if(x.get(1).compareTo(x.get(0))==-1&&x.get(1).compareTo(x.get(2))==-1){//1<0 1<2
						 minimum.setName(x.get(1).toString());
						 minimum.setLineList(x.get(1).getLineList());
						 if(x.get(0).compareTo(x.get(2))==-1) {//0<2
							 middle.setName(x.get(0).toString());
							 middle.setLineList(x.get(0).getLineList());
							 maximum.setName(x.get(2).toString());
							 maximum.setLineList(x.get(2).getLineList());
						 }
						 else {//2<0
							 middle.setName(x.get(2).toString());
							 middle.setLineList(x.get(2).getLineList());
							 maximum.setName(x.get(0).toString());
							 maximum.setLineList(x.get(0).getLineList());
						 }
					 }
					 else if(x.get(2).compareTo(x.get(0))==-1&&x.get(2).compareTo(x.get(1))==-1) {//2<0 2<1
						 minimum.setName(x.get(2).toString());
						 minimum.setLineList(x.get(2).getLineList());
						 if(x.get(0).compareTo(x.get(1))==-1) {//0<1
							 middle.setName(x.get(0).toString());
							 middle.setLineList(x.get(0).getLineList());
							 maximum.setName(x.get(1).toString());
							 maximum.setLineList(x.get(1).getLineList());
						 }
						 else {//1<0
							 middle.setName(x.get(1).toString());
							 middle.setLineList(x.get(1).getLineList());
							 maximum.setName(x.get(0).toString());
							 maximum.setLineList(x.get(0).getLineList());
						 }
					 }
					 x.get(0).setName(minimum.toString());
					 x.get(0).setLineList(minimum.getLineList());
					 x.get(1).setName(middle.toString());
					 x.get(1).setLineList(middle.getLineList());
					 x.get(2).setName(maximum.toString());
					 x.get(2).setLineList(maximum.getLineList());
				 }
				 
				 else {//if the bucket has a size bigger than 3 apply quick sort on it using the quicksort class that I wrote 
					 QuickSort sort = new QuickSort(x);
					 sort.quickSort(0, x.size()-1);
					 LinkedList<Word> finl = new LinkedList<Word>();
					 for(Word y: sort.getList()) {
						 finl.add(y);
					 }
					 x = finl;
				 }
				 
			 }
			  
		  }
		  for(LinkedList<Word> x: bucket) {//write all of the incorrect words in a file
			  if(x!=null) {
				  for(Word y: x) {
					  writer2.write(y + " " + y.getLineString()+"\n");
			  }
		  }
		  }
		  
		  writer2.close();
		  loopingFile = false;
		  break;

	}
	}
}
}


}