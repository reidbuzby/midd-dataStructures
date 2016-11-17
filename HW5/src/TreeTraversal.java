import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class TreeTraversal {

	static BinarySearchTree tree;
	
	public static void main(String[] args) throws IOException
	{
		tree = new BinarySearchTree();
		
		String file = "temps.txt";
		
		readFile(file);
		
		getUserChoice();
		
	}
	
	public static void readFile(String file)throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringTokenizer st;
		String mo;
		int temp;
		String line = br.readLine();
	  	Temp tempobj;
	  	
		while(line != null ){
		
			st = new StringTokenizer(line);		  
			mo = st.nextToken();
		  
			temp = Integer.parseInt(st.nextToken());
			  
			tempobj = new Temp(mo, temp);
		  
			tree.insert(tempobj);  
		
			line = br.readLine();
	 
		}
	}
	 
	
	public static void getUserChoice()
	{
		Scanner reader = new Scanner(System.in); 
		int choice, value1, value2;
		
		System.out.println("Level Order: ");
	  
		tree.levelorder();

	  
		do{
		
			System.out.println("Type of traversal:\n0. Done.\n1. Preorder.\n2. Inorder.\n3. Postorder.\nYour choice: ");
	  
		  
			choice = Integer.parseInt(reader.nextLine());
	  
		  
			if(choice >0 && choice <4){
			
				System.out.println("Min bounding value: ");
	  

				value1 = Integer.parseInt(reader.nextLine());
	  

				System.out.println("Max bounding value: ");
			  

				value2 = Integer.parseInt(reader.nextLine());
	

				Temp mint = new Temp(null, value1);
			  
				Temp maxt = new Temp(null, value2);
			  

				switch(choice) {
			  		case 1: tree.preorder(mint, maxt); break;
			  		case 2: tree.inorder(mint, maxt); break;
			  		case 3: tree.postorder(mint, maxt); break;
				}
			}
		}while(choice > 0);
		System.out.println("Goodbye");
	
	}
			
	}
	