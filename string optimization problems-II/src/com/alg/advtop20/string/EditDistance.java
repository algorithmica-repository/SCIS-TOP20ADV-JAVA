package com.alg.advtop20.string;

import java.util.Arrays;

public class EditDistance {

	private static void traceOptimalRoute(String s1, String s2, int[][] mem) {
		int i = 0, j = 0;
		int n = s1.length();
		int m = s2.length();
		while (i < n && j < m) {
			if (s1.charAt(i) == s2.charAt(j)) {
				++i;
				++j;
			} else {
				int ic = mem[i][j + 1];
				int dc = mem[i + 1][j];
				int rc = mem[i + 1][j + 1];
				if (ic < dc) {
					if (ic < rc) {
						System.out.println("Insert " + s2.charAt(j));
						++j;
					} else {
						System.out.println("Replace " + s1.charAt(1) + "with " + s2.charAt(j));
						++i;
						++j;
					}
				} else {
					if (dc < rc) {
						System.out.println("Delete " + s1.charAt(i));
						++i;
					} else {
						System.out.println("Replace " + s1.charAt(1) + " with " + s2.charAt(j));
						++i;
						++j;
					}
				}
			}
		}
		if (i < n) {
			System.out.println("Delete characters " + s1.substring(i));
		}
		if (j < m) {
			System.out.println("Insert characters " + s2.substring(j));
		}
	}

	// TC:Theta(mn) SC:Theta(mn)
	public static int editDistance(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] mem = new int[n + 1][m + 1];

		for (int j = 0; j <= m; ++j)
			mem[n][j] = m - j;
		for (int i = 0; i <= n; ++i)
			mem[i][m] = n - i;

		for (int i = n - 1; i >= 0; --i) {
			for (int j = m - 1; j >= 0; --j) {
				if (s1.charAt(i) == s2.charAt(j))
					mem[i][j] = mem[i + 1][j + 1];
				else
					mem[i][j] = Math.min(mem[i + 1][j], Math.min(mem[i][j + 1], mem[i + 1][j + 1])) + 1;
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		traceOptimalRoute(s1, s2, mem);
		return mem[0][0];
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(editDistance(args[0], args[1]));

	}

}
