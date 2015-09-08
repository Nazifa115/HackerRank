import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		long count_pos = 0;
		long count_neg = 0;
		long count_zero = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			if (A[i] == 0) {
				count_zero++;
			} else if (A[i] > 0) {
				count_pos++;
			} else if (A[i] < 0) {
				count_neg++;
			}
		}
		System.out.println(round((count_pos / (double) N), 3));
		System.out.println(round((count_neg / (double) N), 3));
		System.out.println(round((count_zero / (double) N), 3));
	}

	public static BigDecimal round(double d, int pos) {
		BigDecimal bd = new BigDecimal(d).setScale(pos, RoundingMode.HALF_UP);
		return bd;
	}
}