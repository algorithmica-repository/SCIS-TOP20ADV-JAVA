package com.alg.advtop20.bt;

import java.util.Arrays;

public class BeautifulArrangements {

	private static boolean isValid1(int[] out) {
		for (int i = 0; i < out.length; ++i) {
			if (i == 0 || i % 2 == 0) {
				if (out[i] % 2 != 0)
					return false;
			} else {
				if (out[i] % 3 != 0)
					return false;
			}
		}
		return true;
	}

	private static void auxArrangements1(int i, int[] out) {
		if (i == out.length) {
			if (isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for (int d = 1; d <= 9; ++d) {
			out[i] = d;
			auxArrangements1(i + 1, out);
		}
	}

	// TC:Theta(9^n) SC:Theta(n)
	public static void arrangements1(int n) {
		int[] out = new int[n];
		auxArrangements1(0, out);
	}

	// --------------------------------------------------------------
	private static boolean isValid2(int i, int d) {
		if (i == 0 || i % 2 == 0) {
			if (d % 2 != 0)
				return false;
		} else {
			if (d % 3 != 0)
				return false;
		}
		return true;
	}

	private static void auxArrangements2(int i, int[] out) {
		if (i == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int d = 1; d <= 9; ++d) {
			if (isValid2(i, d)) {
				out[i] = d;
				auxArrangements2(i + 1, out);
			}
		}
	}

	// TC:Theta(4^n) SC:Theta(n)
	public static void arrangements2(int n) {
		int[] out = new int[n];
		auxArrangements2(0, out);
	}

	// --------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		arrangements2(n);
	}

}
