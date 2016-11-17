My program uses 3 classes, Word.java Driver.java and Setup.java. The word class keeps track of the word itself, a list 
containing what lines the word shows up in, and how many times the word appears. Words are compared based on 
alphabetizing. In order to compare every letter in two words against each other, I wrote a separate method outside of the
compareTo method called checkNext that assists compareTo by recursively checking every letter. The toString method returns 
the words followed by each line number where that word appears. 

The Setup class contains a method called readFile that reads the inputed file, and sets up the AVL Tree. The searchTree method
checks if a word is in the AVL tree and if it is, prints that word along with its line numbers. The count method also checks
if the word is in the tree and if it is reports the amount of times that word appears. 

The driver class then calls the methods from the Setup class depending on the situation.