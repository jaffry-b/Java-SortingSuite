package sort;
/**
 * @author Bilal Jaffry. 
 * @version Insertion version 1.0, 02/22/18
 * 
 */

/*
* R. Sedgewick and K. Wayne, Algorithms, Fourth Edition. Boston, MA: Pearson Education, Inc., 2011. 
* exch and fundamental ideas for the three versions of insertions sort, were created from textbook examples on page 245 and 251.
* Portion of Binary Search provided by textbook page 47.
*/
public class Insertion{
	

	/**
	 * Insertion Sort using basic structure and setup.
	 * @param inputArr - the input array containing jobs that need to be sorted.
	 */
	public static void sortInsert ( Job[] inputArr ) {
		int n = inputArr.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0  && inputArr[j].getRunTime() < inputArr[j-1].getRunTime(); j--) {
				exch(inputArr, j, j-1);
			}
		}
	}
	
	/**
	 * Insertion sort using Comparable interface using pre made compareTo function in job Class ADT.
	 * @param inputArr - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable (Comparable<Job>[] inputArr, int n ) {
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && inputArr[j].compareTo((Job) inputArr[j-1]) < 0  ; j--) {
				exch(inputArr, j, j-1);
			}
		}
	}
	
	/**
	 * Insertion sort using BinarySearch searching for elements instead of direct element to element comparisons.
	 * @param inputArr - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable<Job>[] inputArr, int n ) {
		int tempBinary;

		Comparable<Job> temp;
	    for (int i = 1; i < n; i++) {
	    tempBinary = BinarySearch (inputArr, 0, i, (Job)inputArr[i]);
	     temp = inputArr[i];
	         for (int j = i - 1; tempBinary<= j; j--)
	                inputArr[j + 1] = inputArr[j];
	         inputArr[tempBinary] = temp;
	        }
	}
	
	/**
	 * Binary Search Algorithm
	 * @param inputArr - the input array containing jobs that need to be sorted.
	 * @param low - the starting index of the Binary Search
	 * @param high - the ending index of the Binary Search
	 * @param key - the key being searched for in Binary Search
	 * @return - returns the location at which the key value is located specified by low or mid. Recursively calls its self to binary search over smaller and smaller portions.
	 */
	private static int BinarySearch (Comparable<Job>[] inputArr, int low, int high, Job key) {
	    if (low == high) {
	    	return low;
	    }
	    
	    int mid = (high + low) / 2;
	    boolean a = key.compareTo((Job)inputArr[mid]) < 0;
	    boolean b = inputArr[mid].compareTo(key) < 0;
	    if (a)
	        return BinarySearch (inputArr, low, mid, key);
	    else if (b)
	        return BinarySearch (inputArr, mid + 1, high, key);
	    
	    return mid;
	}
	/**
	 * Swaps two elements of an array of type Job
	 * @param inputArr - the input array containing jobs.
	 * @param a - the index of a Job array that needs to be swapped.
	 * @param b - the index of a Job array that argument a is being swapped with.
	 */
	private static void exch(Comparable<Job>[] inputArr, int a, int b) {
		Comparable<Job> temp = inputArr[a];
		inputArr[a] = inputArr[b];
		inputArr[b] = temp;
	}
	
	
}
