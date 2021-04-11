package com.alg.advtop20.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class MinCostMerging {

	// TC:Theta(n log n) SC:Theta(n)
	public static int minCostMerge(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		System.out.println(pq);
		int tot = 0;
		while (pq.size() > 1) {
			int smallest1 = pq.remove();
			int smallest2 = pq.remove();
			tot += (smallest1 + smallest2);
			pq.add(smallest1 + smallest2);
		}
		//tot += pq.remove();
		return tot;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(10) + 1;
		System.out.println(Arrays.toString(in));
		System.out.println(minCostMerge(in));
	}

}
