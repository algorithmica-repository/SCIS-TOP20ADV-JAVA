package com.alg.advtop20.greedy;

import java.util.Arrays;
import java.util.Random;

public class OptimalScheduling {

	// TC:Theta(n log n) SC:O(1)
	public static int minWaitingTime(int[] in) {
		Arrays.sort(in);
		int total_wt = 0;
		int job_wt = 0;
		for (int i = 1; i < in.length; ++i) {
			job_wt = job_wt + in[i - 1];
			total_wt += job_wt;
		}
		return total_wt;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(minWaitingTime(in));

	}

}
