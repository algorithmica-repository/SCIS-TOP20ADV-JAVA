package com.alg.advtop20.puzzles;

import java.util.Arrays;

public class NqueensSolver {

	private static boolean isValid1(int[] out) {
		for (int i = 1; i < out.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (out[i] == out[j] || Math.abs(i - j) == Math.abs(out[i] - out[j]))
					return false;
			}
		}
		return true;
	}

	private static void auxNqueens1(int q, int[] out) {
		if (q == out.length) {
			if (isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for (int c = 0; c < out.length; ++c) {
			out[q] = c;
			auxNqueens1(q + 1, out);
		}
	}

	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxNqueens1(0, out);
	}

	// ----------------------------------------------------------
	private static boolean isValid2(int q, int c, int[] out) {
		for (int i = 0; i < q; ++i) {
			if (out[i] == c || Math.abs(i - q) == Math.abs(out[i] - c))
				return false;
		}
		return true;
	}

	private static void auxNqueens2(int q, int[] out) {
		if (q == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int c = 0; c < out.length; ++c) {
			if (isValid2(q, c, out)) {
				out[q] = c;
				auxNqueens2(q + 1, out);
			}
		}
	}

	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxNqueens2(0, out);
	}

	// ----------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);
	}

}
