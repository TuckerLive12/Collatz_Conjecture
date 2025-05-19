import java.io.IOException;
import java.util.Scanner;

//went to 10 billion
public class Driver {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("Write to file or test?\n");
		String toTest = input.nextLine();
		boolean write = (toTest.equalsIgnoreCase("Write to file"));
		if (write) System.out.print("Write");
		System.out.println("Test:\n=======================================\n");
		System.out.println("Enter the number to start at. (Must be a natrual number)");
		long startNum = input.nextLong();
		System.out.println("\nEnter the desired number to end at. (Must be a natrual number)");
		long desiredNum = input.nextLong();
		input.nextLine();
		System.out.println("Show each operation? (yes/no)");
		boolean showOp = input.nextLine().equalsIgnoreCase("yes");
		input.close();
		CollatzConjecture.collatzConjecture(startNum,desiredNum,write,showOp);

		System.out.println("Program Done!");
	}
}   