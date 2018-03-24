package sort;
/**
 * @author Bilal Jaffry. 
 * @version Heap version 1.0, 02/22/18
 */

/*
* R. Sedgewick and K. Wayne, Algorithms, Fourth Edition. Boston, MA: Pearson Education, Inc., 2011. 
* “Heap.java,” Princeton University. [Online]. Available: https://algs4.cs.princeton.edu/24pq/Heap.java.html. [Accessed: 20-Feb-2018].
* Textbook site and physical copy used for heapsort implementation, with changes made to aspects for Job ADT and other smaller refinements.
* Textbook pages 314 - 318
*/
public class Heap {
	
    /**
	 * Heap sort main function called in testHeap. Using comparable interface for Job ADT.
	 * @param inputArr - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
    public static void sortHeap(Comparable<Job>[] inputArr, int n) {
        for (int key = n/2; key >= 1; key--)
            sink(inputArr, key, n);
        while (n > 1) {
            swap(inputArr, 1, n--);
            sink(inputArr, 1, n);
        }
    }

    /**
	 * Sinks a Job element into its proper position in the entire Max binary heap. 
	 * @param inputArr - the input array containing jobs.
	 * @param key - the index of a Job array that is being compared.
	 * @param n - the size of the Job array.
	 */
    private static void sink(Comparable<Job>[] inputArr, int key , int n) {
        while (2*key <= n) {
            int j = 2*key;
            if (j < n && inputArr[j-1].compareTo((Job) inputArr[j]) < 0) {
            	j++;
            }
            if (!(inputArr[key-1].compareTo((Job) inputArr[j-1]) < 0)) {
            	break;
            }
            swap(inputArr, key, j);
            key = j;
        }
    }
    
    /**
	 * Swaps two values from Job data type used in sink function.
	 * @param inputArr - the input array containing jobs.
	 * @param a - the index of a Job array that needs to be swapped.
	 * @param b - the index of a Job array that argument a is being swapped with.
	 */
    private static void swap(Comparable<Job>[] inputArr, int a, int b) {
       Comparable<Job> temp = inputArr[a-1];
        inputArr[a-1] = inputArr[b-1];
        inputArr[b-1] = temp;
    }
}
