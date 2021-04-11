package com.alg.dp.oned;

import java.util.Arrays;
import java.util.Random;

public class MinCostFrogJumping {

	public static int minCostJump(int[] in) {
		int[] mem = new int[in.length + 1];
		mem[mem.length - 1] = 0;
		mem[mem.length - 2] = in[in.length - 1];
		for (int i = mem.length - 3; i >= 0; --i) {
			mem[i] = Math.min(mem[i + 1], mem[i + 2]) + in[i];
		}
		traceOptimalRoute(mem, in);
		return mem[0];
	}

	private static void traceOptimalRoute(int[] mem, int[] in) {
		for (int i = 0; i < in.length;) {
			System.out.print(in[i] + " ");
			if (mem[i] == mem[i + 1] + in[i])
				i = i + 1;
			else
				i = i + 2;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(minCostJump(in));
	}

}
