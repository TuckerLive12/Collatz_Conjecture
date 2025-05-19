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
   * @param data, an integer to put into the new node
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
}
