import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* Contains static methods to test and write for stats the Collatz Conjecture.
*
* Last Modified: May 19, 2025
* @auther Jack Kucera, Will Kucera
**/
public class CollatzConjecture {

	/**
   * This method adds a new node at the beginning of LinkedList with the value inputed. 
   *  Increases size by one.
   *
   * @param start, A long which indicates what number to start testing the Collatz Conjecture
   * @param end, A long which indicates what number to end testing the Collatz Conjecture. If end is 0, never stops.
   * @param write, A boolean (Will you finish this)
   * @param showEachOperation, A boolean indicating whether to print each operation
   * @throws IOException, If an IOExcpetion has taken place
   * @return void
   */
    @SuppressWarnings("ConvertToTryWithResources")
    public static void collatzConjecture(long start, long end, boolean write, boolean showEachOperation) throws IOException {
		File file = new File("Collatz_Conjecture/CollatzConjecture.txt");
		FileWriter fwriter = new FileWriter(file, true);
		if (!write) fwriter.close();
		if (write) {
			FileWriter clear = new FileWriter(file, false);
			clear.write("");
			clear.close();
		}
		

        long numOp;
		for (long collatzNum = start; collatzNum <= end; collatzNum++) {
			numOp = 0;
			if (showEachOperation) {
				System.out.println("Starting number: " + collatzNum);
			}
			for (long i = collatzNum; i != 1;) {
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = (3 * i) + 1;
				}
				numOp += 1;
				if (showEachOperation) {
					System.out.println("Operation: " + numOp + ", Current number: " + i);
				}
			}
			//System.out.println("Starting number: " + collatzNum + "\nNumber of Operations: " + numOp + "\n");
			if (write) {
				fwriter.write(collatzNum + ": " + numOp +"\n");
			}
		}
		fwriter.close();
    }

	/**
   * This method... The method assumes that the numbers before the starting number have been checked (word better).
   *
   * @param start, A long which indicates what number to start testing the Collatz Conjecture
   * @param end, A long which indicates what number to end testing the Collatz Conjecture. If end is 0, never stops.
   * @param iterationToPrint, An int which indicates after how many iterations to print the numbering being tested. If 0, never print. Recommended to pick a number greater than 100,000,000.
   * @throws IllegalArgumentException, If a paramter is not what is expected
   * @return void
   */
	public static void collatzConjectureEfficent (long start, long end, long iterationToPrint) {
		// Checking if start is valid
		if (start < 1) throw new IllegalArgumentException("Start parameter must be greater than 0");

		// Checking if end in valid
		if (end < 0) throw new IllegalArgumentException("End parameter must be positive");

		// If end is 0, set end to its maximum value
		if (end == 0) end = Long.MAX_VALUE;

		// Checking if interationToPrint is vaild
		if (iterationToPrint < 0) throw new IllegalArgumentException("interationToPrint parameter must be positive");

		// If start is even, make it odd by subtracting by 1 for the for-loop later
		if (start % 2 == 0) start -= 1;

		// If iterationToPrint equals 0, make it never print
		if (iterationToPrint == 0) {
			iterationToPrint = iterationToPrint-1; // This will make whenPrint == iterationToPrint never possible
		
		// Else if iterationToPrint equals 1, set iterationToPrint to 1
		} else if (iterationToPrint == 1) {
			iterationToPrint = 1;

		// Else, divide iterationToPrint by 2 for collatz number being tested and iterations to match
		} else {
			iterationToPrint /= 2;
		}

		// For printing numbers in for-loop
		long whenPrint = 0;

		// This for-loop efficantly goes through every Collatz number to check if it goes to 1.
		// Skips even numbers because even numbers will be divided by 2, making the number one that has already been checked.
		for (long collatzNum = start; collatzNum <= end; collatzNum += 2) {

			// This while-loop efficantly iterates through the starting number until the number is garrenteed to go to 1
			// If during the iterations i goes below collatzNum, it ends the loop since that number has already been checked
			long i = collatzNum; 
			while (i > collatzNum) { // Equivalent to if (i < collatzNum) break;

				// If even, divide by 2, else (odd), times by 3 and add one.
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = (3 * i) + 1;
				}
			}

			

			// If whenPrint equals iterationToPrint, print collatzNum tested and set whenPrint to 0.
			if (whenPrint == iterationToPrint) {
				System.out.println("Number Tested: " + String.format("%,d", collatzNum));
				whenPrint = 0;
			} 

			// whenPrint goes up by 1 every loop
			whenPrint++;	
	
		}

		// Simple print statement to indicate method is done
		System.out.println("Method finished running. Final Number Tested: " + String.format("%,d", end));

	}

	/**
   * This method is for testing different code for collatzConjectureEfficent()
   *
   * @param start, A long which indicates what number to start testing the Collatz Conjecture
   * @param end, A long which indicates what number to end testing the Collatz Conjecture. If end is 0, never stops.
   * @param iterationToPrint, An int which indicates after how many iterations to print the numbering being tested. If 0, never print. Recommended to pick a number greater than 100,000,000.
   * @throws IllegalArgumentException, If a paramter is not what is expected
   * @return void
   */
	public static void collatzConjectureEfficentTest (long start, long end, long iterationToPrint) {
		// Checking if start is valid
		if (start < 1) throw new IllegalArgumentException("Start parameter must be greater than 0");

		// Checking if end in valid
		if (end < 0) throw new IllegalArgumentException("End parameter must be positive");

		// If end is 0, set end to its maximum value
		if (end == 0) end = Long.MAX_VALUE;

		// Checking if interationToPrint is vaild
		if (iterationToPrint < 0) throw new IllegalArgumentException("interationToPrint parameter must be positive");

		// If start is even, make it odd by subtracting by 1 for the for-loop later
		if (start % 2 == 0) start -= 1;

		// If iterationToPrint equals 0, make it never print
		if (iterationToPrint == 0) {
			iterationToPrint = iterationToPrint-1; // This will make whenPrint == iterationToPrint never possible
		
		// Else if iterationToPrint equals 1, set iterationToPrint to 1
		} else if (iterationToPrint == 1) {
			iterationToPrint = 1;

		// Else, divide iterationToPrint by 2 for collatz number being tested and iterations to match
		} else {
			iterationToPrint /= 2;
		}

		// For printing numbers in for-loop
		long whenPrint = 0;

		// For testing runtime
		ArrayList<Long> milliseconds = new ArrayList<Long>(1000);
		long endTime;
		long startTime = System.nanoTime();
		
		// This for-loop efficantly goes through every Collatz number to check if it goes to 1.
		// Skips even numbers because even numbers will be divided by 2, making the number one that has already been checked.
		for (long collatzNum = start; collatzNum <= end; collatzNum += 2) {
	

			// This while-loop efficantly iterates through the starting number until the number is garrenteed to go to 1
			// If during the iterations i goes below collatzNum, it ends the loop since that number has already been checked
			long i = collatzNum; 
			while (i > collatzNum) { // Equivalent to if (i < collatzNum) break;

				// If even, divide by 2, else (odd), times by 3 and add one.
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = (3 * i) + 1;
				}
			}

			

			// If whenPrint equals iterationToPrint, print collatzNum tested and set whenPrint to 0.
			if (whenPrint == iterationToPrint) {
				// For testing runtime
				endTime = System.nanoTime();
				long duration = (endTime - startTime) / 1_000_000;
				System.out.println("Execution time: " + duration + " ms");
				milliseconds.add(duration);

				System.out.println("Number Tested: " + String.format("%,d", collatzNum));
				whenPrint = 0;

				// For testing runtime
				startTime = System.nanoTime();
			} 

			// whenPrint goes up by 1 every loop
			whenPrint += 1;	
	
		}

		// For testing runtime
		long average = 0;
		
		for (long num : milliseconds) {
			average += num;
		}

		System.out.println("Total Execution time: " + average + " ms");
		System.out.println("Average Execution time: " + average/milliseconds.size() + " ms");

		// Simple print statement to indicate method is done
		System.out.println("Method finished running. Final Number Tested: " + String.format("%,d", end));

	}
}
