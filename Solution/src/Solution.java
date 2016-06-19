import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 * Sherlock and The Beast https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * @author: Nazifa Karima*/
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int n_1 = n;
			while (n_1 > 2 && n_1 % 3 != 0) {
				n_1 = n_1 - 5;
			}

			int count_3 = n - n_1;// divisible by 5
			int count_5 = n_1;
			ArrayList<Integer> number = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if ((count_5 % 3) != 0) {
					number.add(-1);
					break;
				} else if (count_3 > 0) {
					number.add(3);
					count_3--;
				} else {
					number.add(5);
				}
			}

			int i = number.size();
			while (i > 0) {
				System.out.print(number.get(i - 1));
				i--;
			}
			System.out.println();
		}

	}
}
