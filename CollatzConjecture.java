import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Contains code for a singly Linked List. Contains two inner classes, SingleLinkNode and
*  Iterator. Implements the methods addNode, removeNode, printList, and size.
*
* Last Modified: May 9, 2025
* @auther Jack Kucera
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
   * @param iterationToPrint, An int which indicates after how many iterations to print the numbering being tested. Does this by modulating the number being tested, if 0, print. Recommended to pick a high power of 2
   * @throws IllegalArgumentException, If a paramter is not what is expected
   * @return void
   */
	public static void collatzConjectureEfficent (long start, long end, int iterationToPrint) {
		// Checking if start is valid
		if (start < 1) throw new IllegalArgumentException("Start parameter must be greater than 0");

		// Checking if end in valid
		if (end < 0) throw new IllegalArgumentException("End parameter must be positive");

		// If end is 0, set end to its maximum value
		if (end == 0) end = Long.MAX_VALUE;

		// Checking if interationToPrint is vaild
		if (iterationToPrint < 1) throw new IllegalArgumentException("interationToPrint parameter must be greater than 0");

		// If start is even, make it odd by subtracting by 1 for the for-loop later
		if (start % 2 == 0) start -= 1;

		// This for-loop efficantly goes through every Collatz number to check if it goes to 1.
		// Skips even numbers because even numbers will be divided by 2, making the number one that has already been checked.
		for (long collatzNum = start; collatzNum <= end; collatzNum += 2) {

			// This for-loop efficantly iterates through the starting number until the number is garrenteed to go to 1
			// If during the iterations, the number goes below the starting number it breaks the loop since that number has already been checked
			for (long i = collatzNum; i != 1;) {

				// If even, divide by 2, else (odd), times by 3 and add one.
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = (3 * i) + 1;
				}

				// If i is ever less than the collatzNum, i is garenteed to go to 1 since that number has been checked
				if (i < collatzNum) break;
			}

			// If the collatzNum is divisable by iterationToPrint, print the collatzNum
			if (collaztNum % iterationToPrint == 0) System.out.println("Number Tested: " + collatzNum);
	
		}

		// Simple print statement to indicate method is done
		System.out.println("Method finished running.");

	}
}
