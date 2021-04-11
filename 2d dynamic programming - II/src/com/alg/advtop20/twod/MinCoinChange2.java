package com.alg.advtop20.twod;

import java.util.Arrays;

public class MinCoinChange2 {

	private static void traceOptimalRoute(int[] in, int[][] mem) {
		int i = mem.length - 1;
		int j = 0;
		while (i > 0 && j < in.length) {
			if (in[j] > i)
				j = j + 1;
			else {
				int inclusive = mem[i - in[j]][j] == Integer.MAX_VALUE ? mem[i - in[j]][j] : mem[i - in[j]][j] + 1;
				int exclusive = mem[i][j + 1];
				if (inclusive < exclusive) {
					System.out.print(in[j] + "+");
					i = i - in[j];
				} else
					j = j + 1;
			}
		}
		System.out.println();
	}

	// TC:Theta(nS) SC:Theta(nS)
	public static int minCoinChange(int[] in, int s) {
		int n = in.length;
		int[][] mem = new int[s + 1][n + 1];
		for (int j = 0; j <= n; ++j)
			mem[0][j] = 0;
		for (int i = 1; i <= s; ++i)
			mem[i][n] = Integer.MAX_VALUE;

		for (int i = 1; i <= s; ++i) {
			for (int j = n - 1; j >= 0; --j) {
				if (in[j] > i)
					mem[i][j] = mem[i][j + 1];
				else {
					int inclusive = mem[i - in[j]][j] == Integer.MAX_VALUE ? mem[i - in[j]][j] : mem[i - in[j]][j] + 1;
					int exclusive = mem[i][j + 1];
					mem[i][j] = Math.min(inclusive, exclusive);
				}
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		traceOptimalRoute(in, mem);
		return mem[s][0];
	}

	public static void main(String[] args) {
		int[] in = { 1, 3, 4 };
		int s = 6;
		System.out.println(Arrays.toString(in));
		System.out.println(s);
		System.out.println(minCoinChange(in, s));
	}

}
