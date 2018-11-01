import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = Integer.valueOf(sc.nextLine());
		String regExpattern = "^[Hh][Ii]\\s[^Dd]";
		for(int i=0; i<=n; i++){
			String input = sc.nextLine();
			if(myMatcher(regExpattern,input)) System.out.println(input);
		}
	}

	public static boolean myMatcher(String regexPattern, String toMatch){
		Pattern p = Pattern.compile("^(?i)(hi\\s[^d])");
		Matcher m = p.matcher(toMatch);
		if (m.find()) {
			return true;
		}
		return false;
	}
}