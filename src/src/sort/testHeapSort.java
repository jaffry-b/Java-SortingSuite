package sort;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Bilal Jaffry. 
 * @version testHeapSort version 1.0, 02/22/18
 */
public class testHeapSort {
	/**
	 * Initializes 2-D array for jobs per line of  a1_in.txt
	 */
	Job[][] jobs;
	/**
	 * Initializes 1-D array for jobs for each job on a given line in a1_in.txt
	 */
	Job[] newJob;
	/**
	 * Reads the a1_in.txt file.
	 */
	@Before
	public void setUp() throws Exception {
		String line = new String();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(new File("data\\a1_in.txt"));
		jobs = new Job[7][];
		for (int i = 0; i < 7; i++) {
			line = in.nextLine();
			String [] jobValues = line.split(",");
			int itemLength = jobValues.length;
			newJob = new Job[itemLength/2];
			int j = 0;
			while(j < itemLength) {
				newJob[j/2] = new Job(jobValues[j].substring(1),Integer.parseInt(jobValues[j+1].substring(0, jobValues[j+1].length()- 1)));
				j = j + 2;
			}
			jobs[i] = newJob;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortHeap() {
		int count = 2;
		for(int i = 0; i < 5 ;i++) {
			count+=2;
			
		Stopwatch timer2 = new Stopwatch();
		Heap.sortHeap(jobs[i],jobs[i].length);
		System.out.printf("%.5f seconds. 2^%d for sortHeap\n",timer2.elapsedTime() ,count);
			for(int j = 0; j< (jobs[i].length-1)/20;j++) {
				String string1 = jobs[i][j].getJobID();
				String string2 = jobs[i][j+1].getJobID();
				assertTrue (!(string1.compareTo(string2) ==  0) );
				assertTrue(jobs[i][j].getRunTime()<=jobs[i][j+1].getRunTime());
			}
		}
		System.out.println();
	}

}
