import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CollatzConjecture {
    public static void collatzConjecture(long start, long end, boolean write, boolean showeachoperation) throws IOException {
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
				if (showeachoperation) {
					System.out.println("Starting number: " + collatzNum);
				}
				for (long i = collatzNum; i != 1;) {
					if (i % 2 == 0) {
						i = i / 2;
					} else {
						i = (3 * i) + 1;
					}
					numOp += 1;
					if (showeachoperation) {
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
