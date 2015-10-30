import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int[] input = new int[n];
		int noZero = 0 , noPos = 0, noNeg =0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num < 0) {
				noNeg++;
			}else if (num == 0) {
				noZero++;
			}else if (num > 0) {
				noPos++;
			}
		}
		System.out.println(round((double)noPos/n, 3));
		System.out.println(round((double)noNeg/n, 3));
		System.out.println(round((double)noZero/n, 3));

	}

	public static BigDecimal round(double d, int pos) {
		BigDecimal bd = new BigDecimal(d).setScale(pos, RoundingMode.HALF_UP);
		return bd;
	}
}