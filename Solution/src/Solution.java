//Complete this code or write your own from scratch
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
					
	in.close();
	}
	class Board{
		int dim;
		Cell[][] board;
		public Board(int N, int[][] lamps) {
			this.dim = N;
			board =  new Cell[dim][dim];
			for (int i = 0; i < dim; i++) {
				for (int j = 0; j < dim; j++) {
					Cell c = new Cell(i, j, false);
				}
			}
			for (int p = 0; p < lamps.length; p++) {
				int lamp_x = lamps[p][0]-1;
				int lamp_y = lamps[p][1]-1;	
				for (int i = 0; i < dim; i++) {
					for (int j = 0; j < dim; j++) {
						Cell c = board[i][j];
						if(c.x == lamp_x) c.illuminated = true;
						else if(c.y == lamp_y) c.illuminated = true;
						else {
							int dia_x = Math.abs(c.x-lamp_x);
							int dia_y = Math.abs(c.y-lamp_y);
							if(dia_x == dia_y) c.illuminated = true;						
						}
					}
				}
				
			}
		}
		
		class Cell{
			int x, y;
			boolean illuminated;
			public Cell(int coord_x, int coord_y, boolean lit) {
				this.x = coord_x;
				this.y = coord_y;
				this.illuminated = lit;
			}
		}
		
		
	}

	 String[] checkIllumination(int N, int[][] lamps, int[][] queries) {
        String[] results = null;
        Board board = new Board(0, lamps);
        int i = queries[0].length;
        return results;
    }
	
	public static String interleave(String str1, String str2) {
		int maxLen = str1.length() < str2.length() ? str2.length() : str1
				.length();
		ArrayList<Character> resultList = new ArrayList<Character>();
		char[] str1ToCharArray = str1.toCharArray();
		char[] str2ToCharArray = str2.toCharArray();
		for (int i = 0; i < maxLen; i++) {
			if (i < str1.length())
				resultList.add((Character) str1ToCharArray[i]);
			if (i < str2.length())
				resultList.add((Character) str2ToCharArray[i]);
		}
		StringBuilder builder = new StringBuilder(resultList.size());
		for (Character ch : resultList) {
			builder.append(ch);
		}
		return builder.toString();
	}
}
