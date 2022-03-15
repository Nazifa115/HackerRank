import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Ignore
    @Test
    public void getRowReturnsPascalsTriangle(){

        List<Integer> actual = solution.getRow(2);
        assertThat(actual.get(0), is(1));
    }

//    @Test
//    public  void sortedInsertReturnsPointerToSortedDoublyLinkedList(){
//        Solution.DoublyLinkedListNode result = solution.sortedInsert(null, 0);
//    }

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

    @Test
    public void permutationEquationReturnsCorrectPermutation(){
        int[] actual = solution.permutationEquation(new int[]{5,2,1,3,4});
        int[] expected = new int[]{4,2,5,1,3};
        assertThat(actual, is(expected));
    }

    @Test
    public void signalClassificationClassifiesSignalCorrectly(){
        List<Integer> actual = solution.classifySignals(newArrayList(7, 1, 12, 9, 15), newArrayList(2, 9, 2000, 13, 4));
        List<Integer> expected = newArrayList(2,4,5,3,1);
        assertThat(actual, is(expected));
        actual = solution.classifySignals(newArrayList(2, 3, 1, 4, 8), newArrayList(1, 5, 6));
        expected = newArrayList(3,4,5);
        assertThat(actual, is(expected));
    }

    @Test
    public void countingPairs(){
        Solution.countPairs(newArrayList(1,1,2,2,3,3), 1);
    }

    @Test
    public void finalInstances(){
        Solution.finalInstances(5, newArrayList(30,5,4,8,19,89));
        Solution.finalInstances(2, newArrayList(25, 23,1,2,3,4,5,6,7,8,9,10,76,80));
        Solution.finalInstances(174, newArrayList(81,49,94,88,86,78,77,16,73,81,40,40,97,52,70,88,82,3,60,19,37,75,18,79,46,2,90,83,79,74,9,38,42,99,68,89,5,12,39,70,94,40,12,97,62,11,37,28,49,67,27,86,54,96,87,14,51,51,37,4,71,5,33,58,98,12,97,37,67,60,40,35,18,11,79,21,93,79,0,50,33,75,9,68,12,33,1,27,56,80,90,98,79));
        Solution.finalInstances(174, newArrayList(81,41,77,2,18,54,15,64,86,63,91,49,94,18,39,68,69,38,44,69,18,93,97,88,82,80,52,57,89,8,7,1,89,3,86,16,72,37,77,24,47,4,69,44,82,78,74,76,22,70,15,8,53,60,33,20,77,49,49,23,75,11,21,99,1,83,41,16,58,23,38,70,89,10,46,64,93,15,73,6,71,12,36,87,8,23,28,16,77,81,25,7,84,48,0,7,89,61,29,66,40,40,97,29,73,0,87,45,41,13,42,66,83,52,70,4,72,80,54,27,18,90,70,99,71,88,72,44,52,33,24,72,95,20,59,46,82,78,73,98,85,56,91,51,55,26,35,3,76,93,15,29,33,3,90,95,64,64,60,19,82,75,52,11,78,91,96,60,96,63,37,75,58,93,97,85,10,86,65,33,64,88,18,88,17,96,49,4,76,74,97,3,67,79,26,74,22,45,88,97,56,89,38,70,46,2,75,17,68,32,85,18,24,27,44,93,90,61,29,1,90,81,84,85,28,89,46,83,1,11,79,77,32,39,51,12,72,0,79,47,41,48,3,21,26,70,5,27,36,74,32,12,6,49,87,49,4,30,64,6,9,11,52,42,55,13,35,80,8,64,27,38,42,99,82,79,75,70,89,23,36,55,12,58,68,6,14,66,40,4,51,88,10,38,29,89,50,92,39,84,3,72,13,75,38,31,5,39,64,22,16,48,93,80,11,9,29,12,75,0,98,4,68,9,82,81,96,80,39,70,99,80,84,1,63,34,61,9,3,54,94,45,41,52,44,69,22,9,24,95,49,40,12,67,92,92,83,94,14,59,69,64,35,97,23,96,42,78,72,46,36,48,44,31,62,44,84,59,60,6,98,79,51,98,70,11,88,34,81,99,78,66,84,98,87,71,37,28,49,67,26,0,11,24,2,64,5,91,37,36,27,86,70,88,34,41,90,6,7,38,54,51,54,96,57,53,50,45,54,41,91,14,3,85,87,86,73,64,75,85,87,33,41,52,76,14,86,62,22,39,56,17,60,65,44,69,51,51,37,4,79,70,35,23,84,24,82,87,36,83,71,8,19,71,12,38,60,77,30,45,37,5,90,54,71,95,85,94,30,69,49,40,33,58,98,25,72,93,94,47,16,38,3,97,4,12,29,57,15,34,32,29,8,58,54,78,97,24,53,7,83,64,3,15,7,73,56,37,67,15,12,61,79,79,77,83,46,74,43,60,40,35,18,14,98,61,12,21,64,0,92,31,93,11,10,4,12,18,92,2,34,96,8,2,79,56,11,52,78,51,17,7,15,1,93,21,99,62,48,22,11,39,82,83,72,93,93,20,99,96,92,89,27,91,78,45,4,79,83,48,58,61,38,32,33,85,61,30,0,89,66,30,51,53,42,34,62,20,31,50,33,75,46,21,33,4,33,75,92,98,13,72,9,95,47,9,61,2,94,76,15,54,21,68,10,90,25,49,95,43,25,88,21,19,12,15,97,55,42,20,93,23,91,84,44,33,1,86,15,35,36,20,23,17,90,29,94,27,56,80,70,30,27,3,16,96,87,75,93,44,90,11,67,68,7,31,9,67,77,84,20,98,34,13,93,22,69,52,19,73,60,73,79,65,41,70,16));
    }

    @Test
    public void  floodfillTest(){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        solution.floodFill(image, 1, 1, 2);
    }

    @Test
    public void storageTest(){
        solution.storage(6,6,newArrayList(4),newArrayList(2));
    }

    @Test
    public void addTwoDigitsTest(){
        assertEquals(24,solution.addDigits(2985));
    }

    @Test
    public void twoSumTest(){
        int[] input = new int[]{3,2,4};
        assertEquals(solution.twoSum(input, 6)[0], 1);
        assertEquals(solution.twoSum(input, 6)[1], 2);
    }

    @Test
    public void sortedSquareTest(){
        int[] input = new int[]{-4,-1,0,3,10};
        assertEquals(solution.sortedSquares(input)[2],3);
        input = new int[]{-7,-3,2,3,11};
        assertEquals(solution.sortedSquares(input)[2],3);
    }

    @Test
    public void maxProfitTest() {
        //int[] input = new int[]{7,1,5,3,6,4};
        //int[] input = new int[]{2,1,4};
        //int[] input = new int[]{2,1,2,1,0,1,2};
        //int[] input = new int[]{3,3,5,0,0,3,1,4};
        int[] input = new int[]{4,11,2,1,7};
        assertEquals(solution.maxProfit(input), 7);

    }

    @Test
    public void containsDuplicateTest(){
        int[] input = new int[]{1,2,3,1};
        assertEquals(solution.containsDuplicate(input), true);
    }

    @Test
    public void sleepSortTest(){
        //int[] input = new int[]{7,1,5,3,6,4};
        int[] input = new int[]{1,2,3,1};
        List<Integer> expected = Solution.sleepSort(input);
        try {
            Thread.sleep(7000);
            assertEquals(java.util.Optional.ofNullable(expected.get(0)), 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
