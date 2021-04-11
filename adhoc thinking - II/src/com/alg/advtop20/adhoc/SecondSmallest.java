package com.alg.advtop20.adhoc;

import java.util.Arrays;
import java.util.Random;

public class SecondSmallest {
	
	private static void update(int[] tt, int[] in, int i, int j) {
		if(in[tt[i]] < in[tt[j]])
			tt[(i-1)/2] = tt[i];
		else
			tt[(i-1)/2] = tt[j];
	}

	// 1 4 3 2
	// 0 0 0 0 1 2 3
	public static int secondSmallest(int[] in) {
		int[] tt = new int[2 * in.length - 1];
		int ind = tt.length - 1;
		for (int i = in.length - 1; i >= 0; --i)
			tt[ind--] = i;

		//construct tournament tree and find first smallest element
		ind = tt.length - 1;
		while (ind > 0) {
			if (in[tt[ind]] < in[tt[ind - 1]])
				tt[(ind - 1) / 2] = tt[ind];
			else
				tt[(ind - 1) / 2] = tt[ind - 1];
			ind -= 2;
		}
		System.out.println(Arrays.toString(tt));
		System.out.println(in[tt[0]]);

		//find second smallest element
		in[tt[0]] = Integer.MAX_VALUE;
		ind = tt[0] + in.length - 1;
		while (ind > 0) {
			if (ind % 2 == 0)
				update(tt, in, ind, ind - 1);
			else
				update(tt, in, ind, ind + 1);
			ind = (ind-1)/2;
		}
		System.out.println(Arrays.toString(tt));
		return in[tt[0]];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(2 * n) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(secondSmallest(in));

	}

}
