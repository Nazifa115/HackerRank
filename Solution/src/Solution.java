import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();

		while (loop > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int beforeClass = 0;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				if (tmp <= 0) {
					beforeClass++;
				}
			}
			if (beforeClass < k) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			loop--;
		}
	}
}