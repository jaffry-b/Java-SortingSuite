package sort;


/*
 * R. Sedgewick and K. Wayne, Algorithms, Fourth Edition. Boston, MA: Pearson Education, Inc., 2011. 
 * Stopwatch taken from textbook. Page 175.
 */


public class Stopwatch { 

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

   }
 
