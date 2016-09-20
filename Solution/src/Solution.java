//Complete this code or write your own from scratch
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		//int n = in.nextInt();
		
		while (in.hasNext()) {
			HashMap<Integer, Integer> numberOfDigit = new HashMap<Integer, Integer>();
			String curString = in.next();
			Integer current = Integer.parseInt(curString);
			while (current > 0) {
				Integer i = current % 10;
				if (numberOfDigit.containsKey(i)) {
					Integer value = numberOfDigit.get(i);
					value++;
					numberOfDigit.put(i, value);
				} else {
					numberOfDigit.put(i, 1);
				}
				current = current / 10;
			}
			StringBuilder builder = new StringBuilder();		
				Set s = numberOfDigit.entrySet();
				Iterator iter = s.iterator();
				while (iter.hasNext()) {
					Map.Entry mapping = (Map.Entry)iter.next();
					String key = mapping.getKey().toString();
					String value = mapping.getValue().toString();
					builder.append(value);
					builder.append(key);
				}
				   
				ArrayList<String> resultStrings = new ArrayList<String>();
				String[] result = new String[resultStrings.size()];
				for (int i = 0; i < resultStrings.size(); i++) {
			        result[i] = resultStrings.get(i).toString();
			    }
		System.out.println(builder.toString());
		}
		in.close();
	}

	public static String interleave(String str1, String str2) {
		int maxLen = str1.length() < str2.length() ? str2.length() : str1
				.length();
		ArrayList<Character> resultList = new ArrayList<Character>();
		char[] str1ToCharArray = str1.toCharArray();
		char[] str2ToCharArray = str2.toCharArray();
		for (int i = 0; i < maxLen; i++) {
			if (i < str1.length())
				resultList.add((Character) str1ToCharArray[i]);
			if (i < str2.length())
				resultList.add((Character) str2ToCharArray[i]);
		}
		StringBuilder builder = new StringBuilder(resultList.size());
		for (Character ch : resultList) {
			builder.append(ch);
		}
		return builder.toString();
	}
}
