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






/* 
		if (!toTest.equalsIgnoreCase("Write to file")) {
	
			System.out.println("\nTest:\n=======================================\n");
			System.out.println("Enter the number to start at. (Must be a natrual number)");
			long startNum = input.nextLong();
			System.out.println("\nEnter the desired number to end at. (Must be a natrual number)");
			long desiredNum = input.nextLong();
			input.nextLine();
			System.out.println("Show each operation? (yes/no)");
			boolean showOp = input.nextLine().equalsIgnoreCase("yes");
			input.close();
			CollatzConjecture.collatzConjecture(startNum,desiredNum,false,showOp);

		} else {
			System.out.println("\nWrite to file:\n=======================================\n");
			System.out.println("Enter the number to start at. (Number must be a natrual number)");
			long startNum = input.nextLong();
			System.out.println("\nEnter the desired number to end at. (Number must be a natrual number)");
			long desiredNum = input.nextLong();
			input.close();

			if (startNum < 1) {
				System.out
						.println("\nTerminating program due to error.\nStarting number must be a natrual number.");
				System.exit(0);
			}

			try {
				String fileName = "CollatzConjecture.txt";
				FileWriter writer = new FileWriter(fileName, true);
				String toWrite = "New start.\n";
				writer.append(toWrite);
				toWrite = "";
				long numOp = 0;

				for (long collatzNum = startNum; collatzNum <= desiredNum; collatzNum++) {
					numOp = 0;
					for (long i = collatzNum; i != 1;) {
						if (i % 2 == 0) {
							i = i / 2;
						} else {
							i = (3 * i) + 1;
						}
						numOp += 1;
					}
					System.out.println("The starting number is " + collatzNum + ".");
					toWrite += collatzNum + ": " + numOp + "\n";
					if (collatzNum % 10 == 0) {
						writer.append(toWrite);
						toWrite = "";
					}
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		*/
		System.out.println("Program Done!");
	}
}   