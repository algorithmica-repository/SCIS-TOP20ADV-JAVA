package com.alg.advtop20.treedp;

import java.util.Arrays;
import java.util.Random;

public class MaxHierarchyLevels {
	
	private static int depth(int i, int[] in) {
		if(i == in[i])
			return 1;
		return 1 + depth(in[i], in);
	}
	public static int maxLevels1(int[] in) {
		int res = 0;
		for(int i = 0; i < in.length; ++i) {
			int  d = depth(i, in);
			res = Math.max(res, d);
		}
		return res;
	}
	//--------------------------------------
	private static int depth2(int i, int[] in, int[] mem) {
		if(i == in[i])
			return 1;
		if(mem[i] != 0) return mem[i];
		return mem[i] = 1 + depth2(in[i], in, mem);
	}
	public static int maxLevels2(int[] in) {
		int res = 0;
		int [] mem = new int[in.length];
		for(int i = 0; i < in.length; ++i) {
			int  d = depth2(i, in, mem);
			res = Math.max(res, d);
		}
		return res;
	}


 
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int i;
		for(i = 0; i < n-1; ++i)
			in[i] = i+1;
		int rind = new Random().nextInt(n);
		in[rind] = 0;
		System.out.println(Arrays.toString(in));
		System.out.println(maxLevels1(in));
		System.out.println(maxLevels2(in));
	}

}
