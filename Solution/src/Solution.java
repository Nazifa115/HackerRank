import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			array.add(sc.nextInt());
		}

		Collections.rotate(array, k);

		for (int i = 0; i < q; i++) {
			int query = sc.nextInt();
			System.out.println(array.get(query));
		}
	}
}