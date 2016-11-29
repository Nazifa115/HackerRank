import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		Integer k = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (Integer i = 0; i < n; i++) {
			input.add(sc.nextInt());
		}
		Collections.sort(input);
		Collections.reverse(input);

		Integer sum = 0;
		for (Integer i = 0; i < n; i++) {
			sum+= (i/k + 1) * input.get(i);
		}
		System.out.println(sum);
	}
}