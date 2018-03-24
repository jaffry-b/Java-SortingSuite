package sort;
/**
 * @author Bilal Jaffry. 
 * @version SortTest version 1.0, 02/22/18
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testSortInsertion.class,testInsertComparable.class,testInsertBinary.class,testHeapSort.class, testMerge.class})
public class SortTest {

}
