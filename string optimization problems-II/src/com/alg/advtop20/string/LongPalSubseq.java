package com.alg.advtop20.string;

import java.util.Arrays;

public class LongPalSubseq {

	private static void traceOptimalRoute(String s, int[][] mem) {
		int i = 0, j = s.length() - 1;
		StringBuffer res = new StringBuffer();
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				res.append(s.charAt(i));
				i += 1;
				j -= 1;
			} else if (mem[i + 1][j] > mem[i][j - 1]) {
				i += 1;
			} else {
				j -= 1;
			}
		}
		if (i == j)
			System.out.println(res.toString() + s.charAt(i) + res.reverse());
		else
			System.out.println(res.toString() + res.reverse());
	}

	// TC:Theta(n^2) SC:Theta(n^2)
	public static int longPalSubseq(String s) {
		int n = s.length();
		int[][] mem = new int[n][n];

		for (int i = 0; i < n; ++i)
			mem[i][i] = 1;

		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j))
					mem[i][j] = 2 + mem[i + 1][j - 1];
				else
					mem[i][j] = Math.max(mem[i + 1][j], mem[i][j - 1]);
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		traceOptimalRoute(s, mem);
		return mem[0][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(longPalSubseq(args[0]));
	}

}
