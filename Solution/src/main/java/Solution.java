// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<Integer> results = cellCompete(new int[]{1,0,0,0,0,1,0,0}, 1);
        System.out.println();
    }
    //Get state of list of cells after a certain number of days. A cell turns inactive iff both of it's adjacent cells have the same state (both are inactive or b oth are active) on the previous day.

    public static List<Integer> cellCompete(int[] states, int days) {
        for (int day = 0; day < days; day++) {
            List<Integer> previousStates = Arrays.stream(states).boxed().collect(Collectors.toList());

            for (int i = 0; i <= states.length-1; i++) {
                if( i == 0){
                    states[i] = previousStates.get(i+1).equals(1)? 1:0;
                } else if ( i == states.length -1){
                    states[i] = previousStates.get(i-1).equals(1)? 1:0;
                } else{
                    states[i] = (previousStates.get(i-1).equals(0) && previousStates.get(i+1).equals(0)) || (previousStates.get(i-1).equals(1) && previousStates.get(i+1).equals(1))? 0:1;
                }
            }

        }
        List<Integer> results = Arrays.stream(states).boxed().collect(Collectors.toList());
        return results;
    }
}