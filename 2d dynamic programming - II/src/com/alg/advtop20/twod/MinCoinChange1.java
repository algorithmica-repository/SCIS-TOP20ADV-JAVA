package com.alg.advtop20.twod;

import java.util.Arrays;

public class MinCoinChange1 {

	private static void traceOptimalRoute(int[] in, int[] mem) {
		int i = mem.length - 1;
		while (i > 0) {
			for (int j = 0; j < in.length; ++j) {
				if (in[j] <= i) {
					if (mem[i - in[j]] + 1 == mem[i]) {
						System.out.print(in[j] + "+");
						i = i - in[j];
						break;
					}
				}
			}
		}
		System.out.println();
	}

	// TC:Theta(nS) SC:Theta(S)
	public static int minCoinChange(int[] in, int s) {
		int[] mem = new int[s + 1];
		mem[0] = 0;
		for (int i = 1; i <= s; ++i) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < in.length; ++j) {
				if (in[j] <= i)
					min = Math.min(min, mem[i - in[j]] + 1);
			}
			mem[i] = min;
		}
		System.out.println(Arrays.toString(mem));
		traceOptimalRoute(in, mem);
		return mem[s];
	}

	public static void main(String[] args) {
		int[] in = { 1, 3, 4 };
		int s = 15;
		System.out.println(Arrays.toString(in));
		System.out.println(s);
		System.out.println(minCoinChange(in, s));
	}

}
