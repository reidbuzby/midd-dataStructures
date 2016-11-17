import java.util.Scanner;

public class ManipulateStrings {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter phrase: ");
		String input = scan.nextLine();
		System.out.print("Enter integer: ");
		int len = scan.nextInt();
		if (input.length() < len) {
			System.out.println("integer exceeds length of string (" + input.length() + ")");
		}
		else {
			System.out.println("New phrase: " + input.substring(0, len));
		}
		scan.close();
	}
}
