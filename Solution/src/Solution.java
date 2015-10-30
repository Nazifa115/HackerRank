import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String givenTime = sc.next();
		String[] token = givenTime.split(":");
		//String hour = givenTime.substring(0, 1);
		String a = givenTime.substring(8, 10);
		System.out.println(a);
		Integer h = Integer.parseInt(token[0]);
		if (a.contentEquals("PM")) {
			if (h != 12)
			{
				int tmp = h + 12;
				token[0] = Integer.toString(tmp);
			}
		}else {
			if (h == 12) {
				token[0] = "00";
			}
		}
		String last = token[2].substring(0, 2);
		System.out.println(token[0] + ":" + token[1] + ":" + last);
	}

}