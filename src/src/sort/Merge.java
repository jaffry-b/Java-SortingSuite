package sort;


/*
 * R. Sedgewick and K. Wayne, Algorithms, Fourth Edition. Boston, MA: Pearson Education, Inc., 2011. 
 * Merge Sort Code was used in part from textbook with changes made for comparable interface and for the pre-made Job ADT.
 */

/**
 * @author Bilal Jaffry. 
 * @version Merge version 1.0, 02/22/18
 */
public class Merge {
	/**
	 * Primary method called for Mergesort, called in testMerge.
	 * @param inputArr - input array being initially sorted, with a Comparable interface for the Job ADT.
	 * @param n - size of the input array
	 */
    public static void sortMerge(Comparable<Job>[] inputArr, int n) {
        Comparable<Job>[] tempArr = new Job[n];
        sort(inputArr, tempArr, 0, n - 1);
    }
	
	/**
	 * Separates array into two equal halves, recursively until base case of one element is left, merging each layer. No return statement is needed for sorting module.
	 * @param inputArr - input array being initially sorted, with a Comparable interface for the Job ADT.
	 * @param tempArr - temporary auxiliary array passed through for sorting.
	 * @param low - the first index of given portion of the initial array.
	 * @param high - the last index of given portion of the initial array.
	 */
    private static void sort(Comparable<Job>[] inputArr, Comparable<Job>[] tempArr, int low, int high) {
        if (low >= high) return; 
        int m = (high + low) / 2;
        sort(inputArr, tempArr, low, m);    
        sort(inputArr, tempArr, m + 1, high); 
        merge(inputArr, tempArr, low, m, high);
    }
    
    /**
	 * Merging two sub-arrays using Comparable. No return statement is needed for sorting module.
	 * @param inputArr - input array being initially sorted, with a Comparable interface for the Job ADT.
	 * @param tempArr - auxiliary array used for comparing and swaping halved portions of merge sort.
	 * @param low - the first index of given portion of the initial array.
	 * @param mid - the middle index of given portion of the initial array.
	 * @param high - the last index of given portion of the initial array.
	 */
	private static void merge(Comparable<Job>[] inputArr, Comparable<Job>[] tempArr, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
        	tempArr[i] = inputArr[i]; 
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
            	inputArr[k] = tempArr[j++]; 
            }
            else if (j > high) {
            	inputArr[k] = tempArr[i++]; 
            }
            else if (tempArr[j].compareTo((Job) tempArr[i]) < 0) {
            	inputArr[k] = tempArr[j++]; 
            }
            else {
            	inputArr[k] = tempArr[i++]; 
            }
        }
    }
	
}
