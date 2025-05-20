import java.io.IOException;
import java.util.Scanner;

//went to 10 billion
public class Driver {

    @SuppressWarnings("ConvertToTryWithResources")
	public static void main(String[] args) throws IOException {

		// 1-1,000,000,000,000 :
		// Total: 2971678 ms, Average 2974 ms
		//
		// 1,000,000,000,000-2,000,000,000,000:
		// Total: 2851900 ms, Average 2854 ms
		CollatzConjecture.collatzConjectureEfficent(1,0, 10_000_000_000L);
		System.exit(0);

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


		// This commented code chunk is for testing the runtime of different methods
		// NO NOT DELETE
		/** 
		CollatzConjecture.collatzConjectureEfficent(1,1_000_000_000, 100_000_000);
		CollatzConjecture.collatzConjectureEfficent(1,1_000_000_000, 100_000_000);

		long[] milliseconds = new long[100];
		long average1 = 0;
		for (int i = 0; i < milliseconds.length; i++) {
			long startTime = System.nanoTime();
				CollatzConjecture.collatzConjectureEfficent(1,1_000_000_000, 1_000_000_000);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
			System.out.println("Execution time: " + duration + " ms");
			milliseconds[i] = duration;	
		}
		for (long num : milliseconds) {
			average1 += num;
		}
		

		long average2 = 0;
		for (int i = 0; i < milliseconds.length; i++) {
			long startTime = System.nanoTime();
				CollatzConjecture.collatzConjectureEfficentTest(1,1_000_000_000, 1_000_000_000);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
			System.out.println("Execution time: " + duration + " ms");
			milliseconds[i] = duration;	
		}
		for (long num : milliseconds) {
			average2 += num;
		}
		System.out.println("Average Execution time: " + average1/milliseconds.length + " ms");
		System.out.println("Average Execution time: " + average2/milliseconds.length + " ms");

		// Stops running code
		System.exit(0);
		*/
	}
}   