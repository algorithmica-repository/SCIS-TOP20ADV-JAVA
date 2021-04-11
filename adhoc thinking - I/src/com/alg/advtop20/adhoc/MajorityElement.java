package com.alg.advtop20.adhoc;

import java.util.Arrays;
import java.util.Random;

public class MajorityElement {

	// TC:Theta(n) SC:O(1)
	public static int majority(int[] in) {
		int maj = Integer.MAX_VALUE;
		int count = 1;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] == maj)
				++count;
			else {
				--count;
				if (count == 0) {
					maj = in[i];
					count = 1;
				}
			}
		}
		return maj;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		int maj = r.nextInt(n) + 1;
		for (int i = 0; i < n / 2 + 1; ++i)
			in[i] = maj;
		for (int i = n / 2 + 1; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(majority(in));
	}

}
