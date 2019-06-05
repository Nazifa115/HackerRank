import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution solution = new Solution();

    @Ignore
    @Test
    public void getRowReturnsPascalsTriangle(){

        List<Integer> actual = solution.getRow(2);
        assertThat(actual.get(0), is(1));
        /*actual = solution.getRow(2);
        assertThat(actual.size(), is(3));
        actual = solution.getRow(4);
        assertThat(actual.get(2), is(6));*/
    }

    @Test
    public  void sortedInsertReturnsPointerToSortedDoublyLinkedList(){
        Solution.DoublyLinkedListNode result = solution.sortedInsert(null, 0);
    }

    @Test
    public void reverseStringReturnsCharArrayInReverse(){
        char[] array = new char[] {'h', 'k', 'e', 'l', 'j', 'o'};
        solution.reverseString(array);
        assertThat(array[0], is('o'));
        assertThat(array[5], is('h'));
    }

    @Test
    public void removeElementReturnsCorrectArray(){
        assertThat(solution.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2), is(5));
    }

    @Test
    public void sockMerchantReturnsCorrectCountOfPair(){
        assertThat(solution.sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}), is(3));
    }

}