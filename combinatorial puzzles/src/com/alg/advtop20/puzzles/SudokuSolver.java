package com.alg.advtop20.puzzles;

import java.util.Arrays;

public class SudokuSolver {

	// TODO: Fill the rules
	private static boolean isValid1(int[][] out) {
		return true;
	}

	private static void auxSudokuSolver1(int r, int c, int[][] in, int[][] out) {
		if (r == 9) {
			if (isValid1(out)) {
				for (int[] tmp : out)
					System.out.println(Arrays.toString(tmp));
				System.out.println();
			}
			return;
		}
		if (in[r][c] != 0) {
			auxSudokuSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
		} else {
			for (int d = 1; d <= 9; ++d) {
				out[r][c] = d;
				auxSudokuSolver1(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
			}
		}
	}

	public static void sudokuSolver1(int[][] in) {
		int[][] out = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				out[i][j] = in[i][j];
			}
		}
		auxSudokuSolver1(0, 0, in, out);
	}

	// ---------------------------------------------------------------------------
	private static boolean isValid2(int r, int c, int d, int[][] out) {
		// row check
		for (int j = 0; j < 9; ++j)
			if (out[r][j] == d)
				return false;
		// column check
		for (int i = 0; i < 9; ++i)
			if (out[i][c] == d)
				return false;
		// subgrid check
		int sr = r / 3 * 3;
		int sc = c / 3 * 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (out[sr + i][sc + j] == d)
					return false;
			}
		}
		return true;
	}

	private static void auxSudokuSolver2(int r, int c, int[][] in, int[][] out) {
		if (r == 9) {
			for (int[] tmp : out)
				System.out.println(Arrays.toString(tmp));
			System.out.println();
			return;
		}
		if (in[r][c] != 0) {
			auxSudokuSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
		} else {
			for (int d = 1; d <= 9; ++d) {
				if (isValid2(r, c, d, out)) {
					out[r][c] = d;
					auxSudokuSolver2(c == 8 ? r + 1 : r, (c + 1) % 9, in, out);
				}
			}
			out[r][c] = 0;
		}
	}

	public static void sudokuSolver2(int[][] in) {
		int[][] out = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				out[i][j] = in[i][j];
			}
		}
		auxSudokuSolver2(0, 0, in, out);
	}

	// ---------------------------------------------------------------------------
	public static void main(String[] args) {
		int[][] in =  { 
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 9, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 7, 8, 5 },
				{ 0, 0, 7, 0, 4, 8, 0, 5, 0 }, 
				{ 0, 0, 1, 3, 0, 0, 0, 0, 0 },
				{ 0, 0, 6, 0, 7, 0, 0, 0, 0 }, 
				{ 8, 6, 0, 0, 0, 0, 9, 0, 3 },
				{ 7, 0, 0, 0, 0, 5, 0, 6, 2 }, 
				{ 0, 0, 3, 7, 0, 0, 0, 0, 0 } 
			};
		for(int[] tmp:in)
			System.out.println(Arrays.toString(tmp));
		System.out.println();
		sudokuSolver2(in);
	}

}
