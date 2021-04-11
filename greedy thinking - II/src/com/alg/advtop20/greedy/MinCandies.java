package com.alg.advtop20.greedy;

import java.util.Arrays;
import java.util.Random;

public class MinCandies {

	// TC:Theta(n) SC:Theta(n)
	public static int minCandies(int[] in) {
		int[] candies = new int[in.length];
		// left to right scan
		candies[0] = 1;
		for (int i = 1; i < in.length; ++i) {
			if (in[i] > in[i - 1])
				candies[i] = candies[i - 1] + 1;
			else
				candies[i] = 1;
		}
		System.out.println(Arrays.toString(candies));
		int total = candies[in.length - 1];
		// right to left scan
		for (int i = in.length - 2; i >= 0; --i) {
			if (in[i] > in[i + 1] && candies[i] <= candies[i + 1])
				candies[i] = candies[i + 1] + 1;
			total += candies[i];
		}
		System.out.println(Arrays.toString(candies));
		return total;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(10) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(minCandies(in));
	}

}