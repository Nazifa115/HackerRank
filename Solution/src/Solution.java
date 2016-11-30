import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */ 
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Long fac = factorial(n);
        System.out.println(fac);
    }
    public static Long factorial(int n){
        if(n == 1)
            return (long) 1;
        else return (n*factorial(n-1));
    }
}