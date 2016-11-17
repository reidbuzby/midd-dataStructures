import java.util.Scanner;

public class TimeConverter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input time: ");
		int input = scan.nextInt();
		int seconds = input % 60;
		int minutes = (input / 60) % 60;
		int hours = ((input/60) / 60) % 60;
		System.out.println(input + " seconds is equivalent to " + hours +" hours, " + minutes + " minutes, and " + seconds + " seconds");
		scan.close();
	}
}
