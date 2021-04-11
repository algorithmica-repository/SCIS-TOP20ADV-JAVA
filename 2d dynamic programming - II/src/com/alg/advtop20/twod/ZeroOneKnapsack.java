package com.alg.advtop20.twod;

import java.util.Arrays;
import java.util.Random;

public class ZeroOneKnapsack {

	private static void auxKnapsack1(int start, int[] in, int m, int csum, MyInteger gmax) {
		if (m < 0)
			return;
		gmax.setVal(Math.max(gmax.getVal(), csum));
		for (int i = start; i < in.length; ++i) {
			if (in[i] <= m)
				auxKnapsack1(i + 1, in, m - in[i], csum + in[i], gmax);
		}
	}

	// TC:O(2^n) SC:O(n)
	public static int knapsack1(int[] in, int m) {
		MyInteger gmax = new MyInteger(0);
		auxKnapsack1(0, in, m, 0, gmax);
		return gmax.getVal();
	}
	//----------------------------------------------------------
	private static void traceOptimalRoute(int[] in, int[][] mem) {
		int i = mem.length - 1;
		int j = 0;
		while (i > 0 && j < in.length) {
			if (in[j] > i)
				j = j + 1;
			else {
				int inclusive = mem[i - in[j]][j] + in[j];
				int exclusive = mem[i][j + 1];
				if (inclusive > exclusive) {
					System.out.print(in[j] + "+");
					i = i - in[j];
					j = j + 1;
				} else
					j = j + 1;
			}
		}
		System.out.println();
	}

	// TC:Theta(nm) SC:Theta(nm)
	public static int knapsack3(int[] in, int m) {
		int n = in.length;
		int[][] mem = new int[m + 1][n + 1];
		for (int j = 0; j <= n; ++j)
			mem[0][j] = 0;
		for (int i = 1; i <= m; ++i)
			mem[i][n] = 0;

		for (int i = 1; i <= m; ++i) {
			for (int j = n - 1; j >= 0; --j) {
				if (in[j] > i)
					mem[i][j] = mem[i][j + 1];
				else {
					int inclusive = mem[i - in[j]][j+1]  + in[j];
					int exclusive = mem[i][j + 1];
					mem[i][j] = Math.max(inclusive, exclusive);
				}
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		traceOptimalRoute(in, mem);
		return mem[m][0];
	}
	//---------------------------------------------------------------------------

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(2*n) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(m);
		System.out.println(knapsack1(in, m));
		System.out.println(knapsack3(in, m));

	}

}
