import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            String numString = String.valueOf(n);
            char[] digits = numString.toCharArray();
            int count = 0;
            for (int i = 0; i < digits.length; i++) {
           	int x = Character.getNumericValue(digits[i]);
            	if(x != 0 && n%x == 0){
            		count++;
            	}
			}
            System.out.println(count);
        }

    }
}
