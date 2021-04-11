package com.alg.advtop20.greedy;

public class MinCoinChange {

	// TC:Theta(n log n) SC:O(1)
	public static int minCoins11(int n, int b, int s) {
		int ncoins = 0;
		for (int i = n - 1; i >= 0 && s > 0; --i) {
			int denom = (int) Math.pow(b, i);
			if (denom <= s) {
				ncoins += (s / denom);
				s = s % denom;
			}
		}
		return ncoins;
	}
	
	// TC:Theta(n) SC:O(1)
	public static int minCoins12(int n, int b, int s) {
		int ncoins = 0;
		int denom = (int) Math.pow(b, n-1);
		while(s > 0) {
			if (denom <= s) {
				ncoins += (s / denom);
				s = s % denom;
			}
			denom /= b;
		}
		return ncoins;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int s = Integer.parseInt(args[2]);
		System.out.println(n + "," + b + "," + s);
		System.out.println(minCoins11(n, b, s));
		System.out.println(minCoins12(n, b, s));
	}

}
