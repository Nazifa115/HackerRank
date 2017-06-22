import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        ArrayList<Integer> runningList = new ArrayList<>();
        for(int i=0; i<= n; i++){
            Integer element = in.nextInt();
            runningList.add(element);
            Collections.sort(runningList);
            double median;
            if(i==0){
            	median = runningList.get(0);
            }
            else if(i%2 != 0){//even
            	int index = i/2;
                median = (double)(runningList.get(index) + runningList.get(index+1))/2.00;
            }
            else{//odd
            	median = (double)runningList.get(i/2);
            }
            System.out.println(median);
        }
    }
}
