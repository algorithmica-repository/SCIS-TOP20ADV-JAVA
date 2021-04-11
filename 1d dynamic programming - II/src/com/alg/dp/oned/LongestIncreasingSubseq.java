package com.alg.dp.oned;

import java.util.Arrays;
import java.util.Random;

public class LongestIncreasingSubseq {

	// TC:O(n * 2^n) SC:O(1)
	public static int lis1(int[] in) {
		return 0;
	}

	//----------------------------------------------------------------------------
	private static void auxLis2(int i, int plen, MyInteger gmax, int[] in) {
		/*
		 * if (i == in.length - 1) { gmax.setVal(Math.max(plen + 1, gmax.getVal()));
		 * return; }
		 */
		for (int j = i + 1; j < in.length; ++j) {
			if (in[j] > in[i])
				auxLis2(j, plen + 1, gmax, in);
		}
		gmax.setVal(Math.max(plen + 1, gmax.getVal()));
	}

	// TC:O(n * n+1) SC:Theta(n)
	public static int lis2(int[] in) {
		MyInteger gmax = new MyInteger(1);
		for (int i = 0; i < in.length; ++i)
			auxLis2(i, 0, gmax, in);
		return gmax.getVal();
	}

	//----------------------------------------------------------------------------
	private static int auxLis3(int i, int[] in) {
		/*
		 * if (i == in.length - 1) return 1;
		 */
		int max = 1;
		for (int j = i + 1; j < in.length; ++j) {
			if (in[j] > in[i]) {
				int res = auxLis3(j, in) + 1;
				max = Math.max(res, max);
			}
		}
		return max;
	}

	// TC:O(n * n+1) SC:Theta(n)
	public static int lis3(int[] in) {
		int gmax = 0;
		for (int i = 0; i < in.length; ++i)
			gmax = Math.max(gmax, auxLis3(i, in));
		return gmax;
	}

	//----------------------------------------------------------------------------
	private static int auxLis4(int i, int[] mem, int[] in) {
		/*
		 * if (i == in.length - 1) return 1;
		 */
		if (mem[i] != 0)
			return mem[i];
		int max = 1;
		for (int j = i + 1; j < in.length; ++j) {
			if (in[j] > in[i]) {
				int res = auxLis4(j, mem, in) + 1;
				max = Math.max(res, max);
			}
		}
		mem[i] = max;
		return mem[i];
	}

	// TC:O(n^2 ) SC:Theta(n)
	public static int lis4(int[] in) {
		int gmax = 0;
		int[] mem = new int[in.length];
		for (int i = 0; i < in.length; ++i)
			gmax = Math.max(gmax, auxLis4(i, mem, in));
		return gmax;
	}

	//----------------------------------------------------------------------------
	// TC:O(n^2 ) SC:Theta(n)
	public static int lis5(int[] in) {
		int gmax = 0;
		int[] mem = new int[in.length];
		mem[in.length - 1] = 1;
		int mpos = 0;
		for (int i = in.length - 2; i >= 0; --i) {
			int max = 1;
			for (int j = i + 1; j < in.length; ++j) {
				if (in[j] > in[i]) {
					int res = mem[j] + 1;
					max = Math.max(res, max);
				}
			}
			mem[i] = max;
			if(mem[i] > gmax) {
				gmax = mem[i];
				mpos = i;
			}
		}
		traceOptimalRoute(mpos, mem, in);
		System.out.println();
		return gmax;
	}
	
	private static void traceOptimalRoute(int i, int[] mem, int[] in) {
		while( i < mem.length) {
			System.out.print(in[i] + " ");
			boolean end = true;
			for (int j = i + 1; j < in.length; ++j) {
				if (in[j] > in[i]) {
					end = false;
					if(mem[i] == mem[j]+1) {
						i = j;
						break;
					}
				}
			}
			if(end)
				break;
		}
		
	}

	//----------------------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n);
		// in[i] = i;
		System.out.println(Arrays.toString(in));
		// System.out.println(lis2(in));
		// System.out.println(lis3(in));
		// System.out.println(lis4(in));
		System.out.println(lis5(in));
	}

}
