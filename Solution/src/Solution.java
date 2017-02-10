import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */ 
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger fac = factorial(n);
        System.out.println(fac);
    }
    public static BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.ONE))
            return  BigInteger.ONE;
        else 
        return (n.multiply(factorial(n.subtract(BigInteger.ONE))));
        	
        
    }
}