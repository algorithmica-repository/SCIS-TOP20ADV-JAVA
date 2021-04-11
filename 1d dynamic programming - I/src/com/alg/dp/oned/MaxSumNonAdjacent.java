package com.alg.dp.oned;

import java.util.Arrays;
import java.util.Random;

public class MaxSumNonAdjacent {

	private static void auxMaxSum1(int i, int psum, MyInteger gmax, int[] in) {
		if (i >= in.length) {
			gmax.setVal(Math.max(psum, gmax.getVal()));
			return;
		}
		auxMaxSum1(i + 2, psum + in[i], gmax, in);
		auxMaxSum1(i + 1, psum, gmax, in);
	}

	// TC:Theta(2^n) SC:Theta(n)
	public static int maxSum1(int[] in) {
		MyInteger gmax = new MyInteger(Integer.MIN_VALUE);
		auxMaxSum1(0, 0, gmax, in);
		return gmax.getVal();
	}

	//----------------------------------------------------------------------------
	private static int auxMaxSum2(int i, int[] in) {
		if (i >= in.length)
			return 0;
		int inclusive = auxMaxSum2(i + 2, in) + in[i];
		int exclusive = auxMaxSum2(i + 1, in);
		return Math.max(inclusive, exclusive);
	}

	// TC:Theta(2^n) SC:Theta(n)
	public static int maxSum2(int[] in) {
		return auxMaxSum2(0, in);
	}

	//----------------------------------------------------------------------------
	private static int auxMaxSum3(int i, int[] mem, int[] in) {
		if (i >= in.length)
			return 0;
		if (mem[i] != 0)
			return mem[i];
		int inclusive = auxMaxSum3(i + 2, mem, in) + in[i];
		int exclusive = auxMaxSum3(i + 1, mem, in);
		mem[i] = Math.max(inclusive, exclusive);
		return mem[i];
	}

	// TC:Theta(n) SC:Theta(n)
	public static int maxSum3(int[] in) {
		int[] mem = new int[in.length];
		return auxMaxSum3(0, mem, in);
	}

	//----------------------------------------------------------------------------
	// TC:Theta(n) SC:Theta(n)
	public static int maxSum4(int[] in) {
		int[] mem = new int[in.length + 2];
		mem[in.length] = mem[in.length + 1] = 0;
		for (int i = in.length - 1; i >= 0; --i) {
			int inclusive = mem[i + 2] + in[i];
			int exclusive = mem[i + 1];
			mem[i] = Math.max(inclusive, exclusive);
		}
		traceOptimalRoute(mem, in);
		return mem[0];
	}

	public static void traceOptimalRoute(int[] mem, int[] in) {
		System.out.println(Arrays.toString(mem));
		for (int i = 0; i < in.length;) {
			if (mem[i] == mem[i + 1])
				i = i + 1;
			else {
				System.out.print(in[i] + " ");
				i = i + 2;
			}
		}
		System.out.println();
	}

	//----------------------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n);
		System.out.println(Arrays.toString(in));
		// System.out.println(maxSum1(in));
		// System.out.println(maxSum2(in));
		// System.out.println(maxSum3(in));
		System.out.println(maxSum4(in));
	}

}
