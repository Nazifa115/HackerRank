import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[] input = new int[t]; 
		for (int i = 0; i < t; i++) {
			input[i] = Integer.parseInt(sc.nextLine());
		}
		for (int j = 0; j < input.length; j++) {
			int n = input[j];
			boolean resultFound = false;
			if (isDivisibleByThree(n)) {
				resultFound = true;
				createAndPrintresult(n, 0);
				
			} else if (!resultFound && !isDivisibleByThree(n)) {
				int divisor = n / 3;
				while (divisor > 0) {
					int noOfThree = n - (divisor * 3);
					if (isDivisibleByFive(noOfThree)) {
						resultFound = true;
						createAndPrintresult(n, noOfThree);
					}
					divisor--;
				}
			}
			if (!resultFound) {
				if (isDivisibleByFive(n)) {
					resultFound = true;
createAndPrintresult(n, n);
				}
			}

			if (!resultFound) {
				System.out.println("-1");
			}
		}
	}

	private static void createAndPrintresult(int n, int noOfThree) {
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			if (i < (result.length - noOfThree)) {
				result[i] = 5;
			} else {
				result[i] = 3;
			}
		}
		printResult(result);
	}

	private static void printResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}System.out.println();
	}

	private static boolean isDivisibleByThree(int n) {
		if (n / 3 > 0 && n % 3 == 0)
			return true;
		else
			return false;
	}

	private static boolean isDivisibleByFive(int n) {
		if (n / 5 > 0 && n % 5 == 0)
			return true;
		else
			return false;
	}
}