package com.alg.advtop20.greedy;

import java.util.Arrays;
import java.util.Random;

public class MaxMatchings {

	public static int maxMatchings(int[] tea_cups, int[] saucers) {
		Arrays.sort(tea_cups);
		Arrays.sort(saucers);
		int i = 0, j = 0, nmatches = 0;
		while (i < tea_cups.length && j < saucers.length) {
			if (tea_cups[i] <= saucers[j]) {
				nmatches++;
				i++;
				j++;
			} else
				j++;
		}
		return nmatches;
	}

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		int[] tea_cups = new int[m];
		int[] saucers = new int[n];

		Random r = new Random();
		for (int i = 0; i < m; ++i)
			tea_cups[i] = r.nextInt(10) + 1;
		for (int i = 0; i < n; ++i)
			saucers[i] = r.nextInt(10) + 1;
		System.out.println(Arrays.toString(tea_cups));
		System.out.println(Arrays.toString(saucers));

		System.out.println(maxMatchings(tea_cups, saucers));

	}

}
