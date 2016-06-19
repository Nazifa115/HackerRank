import java.util.Scanner;

public class Solution {

	public static void insertIntoSorted(int[] ar) {
		int pivot = ar[ar.length - 1];
		int i = ar.length - 2;
		while (i >= 0 && pivot < ar[i]) {
			ar[i+1] = ar[i];	
			printArray(ar);
			i--;
		}
		if(i<0)
			ar[0] = pivot;
		else
			ar[i+1]=pivot;
		printArray(ar);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
