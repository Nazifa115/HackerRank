//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> contacts = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            contacts.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            Integer value = contacts.get(s);
            if(value != null)
            	System.out.println(s+"="+value);
            else
            	System.out.println("Not found");
        }
        in.close();
    }
    
    public static String interleave(String str1, String str2) {
        int maxLen = str1.length() < str2.length()? str2.length():str1.length();
        ArrayList<Character> resultList = new ArrayList<Character>();
        char[] str1ToCharArray = str1.toCharArray();
        char[] str2ToCharArray = str2.toCharArray();
        for(int i=0; i< maxLen; i++){
        	if(i < str1.length())
        		resultList.add((Character)str1ToCharArray[i]);
        	if(i < str2.length())
        		resultList.add((Character)str2ToCharArray[i]);
        }
        StringBuilder builder = new StringBuilder(resultList.size());
        for(Character ch: resultList)
        {
            builder.append(ch);
        }
		return builder.toString();
    }
}
