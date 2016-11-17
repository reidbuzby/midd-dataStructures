import java.util.Scanner;

public class Statistics {
	Scanner scan = new Scanner(System.in);
	public int[] getIntegers() {
		System.out.println("How many positive integers would you like to enter?");
		int num = scan.nextInt();
		int[] nums = new int[num];
		for(int i=0;i<num;i++) {
			System.out.println("Please enter integer "+(i+1)+": ");
			nums[i] = scan.nextInt();
		}
		return nums;
	}
	
	public double getAverage(int[] array) {
		double average = 0.0;
		for(int x: array) {
			average = average + x;
		}
		return (average/(array.length));
	}
	
	public int getMax(int[] array) {
		int maximum = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]>=maximum) {
				maximum = array[i];
			}
		}
		return maximum;
	}
	
	public int getMin(int[] array) {
		int minimum = array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]<minimum) {
				minimum = array[i];
			}
		}
		return minimum;
	}
	
	public int getRange(int[] nums) {
		int maximum = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=maximum) {
				maximum = nums[i];
			}
		}
		int minimum = nums[0];
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<minimum) {
				minimum = nums[i];
			}
		}
		return maximum-minimum;
	}
	
	public int getMode(int[] nums) {
		int finl = 0;
		int[] count = new int[(nums.length)*2];
		for(int i=0;i<nums.length;i++) {
			for(int k=0;k<nums.length;k++){
				if(nums[i] == nums[k]) {
					count[i*2] = nums[i];
					count[(i*2)+1] = count[(i*2)+1]+1;
				}
		}
	}
		int maxx = 0;
		for(int i=1;i<count.length;i+=2) {
			if(count[i]>=maxx) {
				maxx = count[i];
			}
		}
		for(int i=1;i<count.length;i+=2) {
			if(count[i]==maxx) {
				finl = count[i-1];
	}
		}
		return finl;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		boolean running2 = true;
		boolean running3 = true;
		while(running) {
		running2 = true;
		running3 = true;
		System.out.println("Enter positive integers(1) or quit(0)");
		int yn = scan.nextInt();
			if(yn == 1) {
				while(running2) {
					Statistics p1 = new Statistics();
					int[] list = p1.getIntegers();
					while(running3) {
						System.out.println("Please choose an option:");
						System.out.println("(1) average");
						System.out.println("(2) maximum");
						System.out.println("(3) minimum");
						System.out.println("(4) range");
						System.out.println("(5) mode");
						System.out.println("(0) quit");
						int choice = scan.nextInt();
						
						if (choice == 0) {
							running2 = false;
							running3 = false;
						}
						else {
			
						if(choice == 1){
							System.out.println("Average is: "+p1.getAverage(list));
						}
						if(choice == 2){
							System.out.println("Max is: "+p1.getMax(list));
						}
						if(choice == 3){
							System.out.println("Minimum is: "+p1.getMin(list));
						}
						if(choice == 4){
							System.out.println("Range is: "+p1.getRange(list));
						}
						if(choice == 5) {
							System.out.println("Mode is: "+p1.getMode(list));
								}
							}
						}
						
					
				}
			}
			if(yn == 0) {
				System.out.println("Goodbye!");
				running = false;
			}
		}
		scan.close();
	}
}
