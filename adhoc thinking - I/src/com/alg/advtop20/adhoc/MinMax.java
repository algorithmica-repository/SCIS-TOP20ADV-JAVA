package com.alg.advtop20.adhoc;

import java.util.Arrays;
import java.util.Random;

public class MinMax {

	// ~2n comparsions
	public static void minMax1(int[] in) {
		int min, max;
		if (in[0] < in[1]) {
			min = in[0];
			max = in[1];
		} else {
			min = in[1];
			max = in[0];
		}
		for (int i = 2; i < in.length; ++i) {
			if (in[i] < min)
				min = in[i];
			else if (in[i] > max)
				max = in[i];
		}
		System.out.println(min);
		System.out.println(max);
	}

	// ~1.5n comparsions
	public static void minMax2(int[] in) {
		int min, max;
		if (in[0] < in[1]) {
			min = in[0];
			max = in[1];
		} else {
			min = in[1];
			max = in[0];
		}
		int pmin, pmax, i;
		for (i = 2; i < in.length - 1; i += 2) {
			if (in[i] < in[i + 1]) {
				pmin = in[i];
				pmax = in[i + 1];
			} else {
				pmin = in[i + 1];
				pmax = in[i];
			}
			if (pmin < min)
				min = pmin;
			if (pmax > max)
				max = pmax;
		}
		if (i < in.length) {
			if (in[i] < min)
				min = in[i];
			else if (in[i] > max)
				max = in[i];
		}
		System.out.println(min);
		System.out.println(max);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(2 * n) + 1;
		System.out.println(Arrays.toString(in));
		minMax1(in);
		minMax2(in);
	}

}
