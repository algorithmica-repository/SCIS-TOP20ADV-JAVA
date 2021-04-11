package com.alg.advtop20.twod;

import java.util.Arrays;
import java.util.Random;

public class MaxCoins {

	private static void auxMaxCoins1(int i, int j, int psum, MyInteger gmax, int[][] in) {
		if (i >= in.length || j >= in.length)
			return;
		if (i == in.length - 1 && j == in.length - 1) {
			gmax.setVal(Math.max(gmax.getVal(), psum + in[i][j]));
			return;
		}
		auxMaxCoins1(i + 1, j, psum + in[i][j], gmax, in);
		auxMaxCoins1(i, j + 1, psum + in[i][j], gmax, in);
	}

	// TC:Theta(2^2n) SC:Theta(n)
	public static int maxCoins1(int[][] in) {
		MyInteger gmax = new MyInteger(0);
		auxMaxCoins1(0, 0, 0, gmax, in);
		return gmax.getVal();
	}

	// -----------------------------------------------------------------------
	private static int auxMaxCoins2(int i, int j, int[][] in) {
		if (i >= in.length || j >= in.length)
			return 0;
		int bsum = auxMaxCoins2(i + 1, j, in);
		int rsum = auxMaxCoins2(i, j + 1, in);
		return Math.max(bsum, rsum) + in[i][j];
	}

	// TC:Theta(2^2n) SC:Theta(n)
	public static int maxCoins2(int[][] in) {
		return auxMaxCoins2(0, 0, in);
	}

	// -----------------------------------------------------------------------
	private static int auxMaxCoins3(int i, int j, int[][] mem, int[][] in) {
		if (i >= in.length || j >= in.length)
			return 0;
		if (mem[i][j] != 0)
			return mem[i][j];
		int bsum = auxMaxCoins3(i + 1, j, mem, in);
		int rsum = auxMaxCoins3(i, j + 1, mem, in);
		mem[i][j] = Math.max(bsum, rsum) + in[i][j];
		return mem[i][j];
	}

	// TC:Theta(n^2) SC:Theta(n^2)
	public static int maxCoins3(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		return auxMaxCoins3(0, 0, mem, in);
	}

	// -----------------------------------------------------------------------
	// TC:Theta(n^2) SC:Theta(n^2)
	public static int maxCoins4(int[][] in) {
		int n = in.length;
		int[][] mem = new int[n + 1][n + 1];
		for (int i = 0; i < n; ++i) {
			mem[n][i] = 0;
			mem[i][n] = 0;
		}
		for (int i = n - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				int bsum = mem[i + 1][j];
				int rsum = mem[i][j + 1];
				mem[i][j] = Math.max(bsum, rsum) + in[i][j];
			}
		}
		traceOptimalRoute(mem, in);
		return mem[0][0];
	}

	private static void traceOptimalRoute(int[][] mem, int[][] in) {
		int i = 0, j = 0;
		while (i < in.length && j < in.length) {
			System.out.print(in[i][j] + " ");
			if (mem[i + 1][j] > mem[i][j + 1]) {
				++i;
			} else {
				++j;
			}
		}
		System.out.println();
	}

	// ----------------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(n) + 1;
			}
		}
		for (int[] tmp : in)
		 System.out.println(Arrays.toString(tmp));
		// System.out.println(maxCoins1(in));
		// System.out.println(maxCoins2(in));
		// System.out.println(maxCoins3(in));
		System.out.println(maxCoins4(in));

	}

}
