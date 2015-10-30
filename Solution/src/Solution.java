import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = N-i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("#");
			}
			System.out.println("");;
		}

	}

	public static BigDecimal round(double d, int pos) {
		BigDecimal bd = new BigDecimal(d).setScale(pos, RoundingMode.HALF_UP);
		return bd;
	}
}