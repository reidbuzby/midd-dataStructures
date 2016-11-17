import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TimeTest {
	static String filename;
	
	public static long LinkdList(String filename) throws IOException { //choice 1
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		LinkedList<String> list = new LinkedList<String>();//creates a new LinkedList
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			if(input.charAt(0)=='i') {//checks for insertion
				list.add(finl);//inserts the number
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				list.remove(finl);//deletes the number
			}
		}
		return ((System.currentTimeMillis()-time));//returns total runtime
	}
	
	public static long StckArrayList(String filename) throws IOException { //choice 2 (imported)
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		Stack<Integer> stack = new Stack<Integer>();//creates a new Stack
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			int finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				stack.push((int) finlInt);//pushes the number on the stack
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				stack.pop();//pops the top element
			}
		}
		return ((System.currentTimeMillis()-time));//returns total run time
	}
	
	public static long StackLinkedList(String filename) throws IOException, Underflow { //choice 3 (implements StackLi class)
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		StackLi stack = new StackLi();//creates a new StackLi object
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			int finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				stack.push(finlInt);//pushes the number on the stack
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				stack.pop();//pops the top element
			}
	}
		return ((System.currentTimeMillis()-time)); //returns total runtime
	}
	
	public static double QueueLinkedList(String filename) throws IOException{//choice 4 (implements QueueLi class)
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		QueueLi queue = new QueueLi();//creates a new QueueLi object
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			int finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				queue.enqueue(finlInt);//enqueues the number
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				queue.dequeue();//dequeues the first element
			}
		}
			return System.currentTimeMillis()-time; //returns total runtime
	}
	
	public static long ArryList(String filename) throws IOException { //choice 5
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		ArrayList<Integer> arraylist = new ArrayList<Integer>();//creates a new ArrayList
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			long finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				arraylist.add((int) finlInt);//adds the number
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				arraylist.remove(finlInt);//removes the number
			}
		}
		return  ((System.currentTimeMillis()-time));//returns total runtime
	}
	
	public static long Arry(String filename) throws IOException {//choice 6
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		int[] array = new int[250000];//creates a new array of size 250000
		long count =0;//keeps track of how many indexes are used
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			long finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				array[(int) count] = (int) finlInt;//adds the number at index number
				count++;//increments count because 1 element was added
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				array[(int) finlInt]=-1;//sets element number to -1
				count--;//decrements count because 1 element was deleted
			}
		}
		return (System.currentTimeMillis()-time);//returns total runtime
	}
	
	public static long BinarySearchTree(String filename) throws IOException {//choice 7
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		BinarySearchTree BST = new BinarySearchTree();//creates a new BST
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			long finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				BST.insert(finlInt);
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				BST.remove(finlInt);
			}
		}
		return (System.currentTimeMillis()-time);//returns total runtime
	}
	
	public static long AVLTree(String filename) throws IOException{//choice 8
		Scanner fileReader = new Scanner(new File(filename));
		long time = System.currentTimeMillis();//sets initial time
		AvlTree avl = new AvlTree();//creates a new AVL Tree
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String input = fileReader.next();
			String finl = input.substring(1);//stores the number inputed
			long finlInt = Integer.parseInt(finl);
			if(input.charAt(0)=='i') {//checks for insertion
				avl.insert(finlInt);
			}
			else if(input.charAt(0)=='d') {//checks for deletion
				avl.remove(finlInt);
			}
		}
		return (System.currentTimeMillis()-time);//returns total runtime
	}
	
	public static void main(String[] args) throws IOException, Underflow {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter filename: ");
		filename = input.nextLine();
		while(running) {
			System.out.print("     ADT Menu     \n 0. Quit \n 1. LinkedList (insert at end) \n 2. StackArray \n 3. StackList \n 4. QueueList \n 5. ArrayList \n 6. array \n 7. Binary Search Tree \n 8. AVL Tree \n Your Choice: ");
			int choice = input.nextInt();
			if(choice==0) {
				System.out.println("Goodbye");
				running = false;
			}
			if(choice==1) {
				System.out.println("Running time: " + LinkdList(filename));//calls LinkedList
			}
			if(choice==2) {
				System.out.println("Running time: " + StckArrayList(filename));//calls StackArray
			}
			if(choice==3) {
				System.out.println("Running time: " + StackLinkedList(filename));//calls StackList
			}
			if(choice==4) {
				System.out.println("Running time: " + QueueLinkedList(filename));//calls Queue
			}
			if(choice==5) {
				System.out.println("Running time: " + ArryList(filename));//calls ArrayList
			}
			if(choice==6) {
				System.out.println("Running time: " + Arry(filename));//calls array
			}
			if(choice==7){
				System.out.println("Running time: " + BinarySearchTree(filename));//calls BST
			}
			if(choice==8){
				System.out.println("Running time: " + AVLTree(filename));//calls AVL Tree
			}
		}
	}
}
