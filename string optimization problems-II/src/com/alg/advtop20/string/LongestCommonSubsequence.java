package com.alg.advtop20.string;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void traceOptimalSolution(String s1, String s2, int[][] mem) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				System.out.print(s1.charAt(i));
				++i;
				++j;
			} else {
				if (mem[i][j + 1] > mem[i + 1][j])
					++j;
				else
					++i;
			}
		}
		System.out.println();
	}

	// TC:Theta(mn) SC:Theta(mn)
	public static int longComSubseq(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] mem = new int[n + 1][m + 1];

		for (int i = 0; i <= n; ++i)
			mem[i][m] = 0;
		for (int j = 0; j <= m; ++j)
			mem[n][j] = 0;

		for (int i = n - 1; i >= 0; --i) {
			for (int j = m - 1; j >= 0; --j) {
				if (s1.charAt(i) == s2.charAt(j))
					mem[i][j] = 1 + mem[i + 1][j + 1];
				else
					mem[i][j] = Math.max(mem[i][j + 1], mem[i + 1][j]);
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		traceOptimalSolution(s1, s2, mem);
		return mem[0][0];
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(longComSubseq(args[0], args[1]));

	}

}
