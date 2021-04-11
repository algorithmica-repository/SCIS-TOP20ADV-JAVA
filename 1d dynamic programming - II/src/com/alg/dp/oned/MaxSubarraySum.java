package com.alg.dp.oned;

import java.util.Arrays;
import java.util.Random;

public class MaxSubarraySum {

	// TC:Theta(n) SC:Theta(n)
	public static int maxSubArraySum(int[] in) {
		int[] mem = new int[in.length + 1];
		mem[mem.length - 1] = 0;
		int gmax = Integer.MIN_VALUE;
		int pos = in.length;
		for (int i = mem.length - 2; i >= 0; --i) {
			mem[i] = Math.max(in[i], in[i] + mem[i + 1]);
			if (mem[i] > gmax) {
				gmax = mem[i];
				pos = i;
			}
		}
		System.out.println(pos);
		return gmax;
	}

	// TC:Theta(n) SC:O(1)
	public static int maxSubArraySumOpt(int[] in) {
		int res = 0;
		int gmax = Integer.MIN_VALUE;
		int pos = in.length;
		for (int i = in.length - 1; i >= 0; --i) {
			res = Math.max(in[i], in[i] + res);
			if (res > gmax) {
				gmax = res;
				pos = i;
			}
		}
		System.out.println(pos);
		return gmax;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(n) + 1;
			if (r.nextInt(2) == 0)
				in[i] *= -1;
		}
		System.out.println(Arrays.toString(in));
		System.out.println(maxSubArraySum(in));
		System.out.println(maxSubArraySumOpt(in));
	}

}
