package com.alg.advtop20.adhoc;

import java.util.Arrays;
import java.util.Random;

public class NextPermutation {

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	private static void reverse(int[] in, int i, int j) {
		while (i < j) {
			swap(in, i, j);
			++i;
			--j;
		}
	}

	// 4 5 3 2 1
	// 5 4 3 2 1
	// TC:Theta(n) SC:O(1)
	public static void nextPerm(int[] in) {
		int i;
		for (i = in.length - 2; i >= 0; --i) {
			if (in[i] < in[i + 1])
				break;
		}
		if (i < 0)
			return;
		int min_ind = i;
		for (int j = i + 1; j < in.length; ++j) {
			if (in[j] > in[i])
				min_ind = j;
			else
				break;
		}
		swap(in, i, min_ind);
		reverse(in, i + 1, in.length - 1);

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		nextPerm(in);
		System.out.println(Arrays.toString(in));
		nextPerm(in);
		System.out.println(Arrays.toString(in));
		nextPerm(in);
		System.out.println(Arrays.toString(in));
	}

}
