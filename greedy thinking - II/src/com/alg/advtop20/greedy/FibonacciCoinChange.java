package com.alg.advtop20.greedy;

public class FibonacciCoinChange {

	//TC:Theta(log S)  SC:O(1)
	public static int minCoins(int s) {
		int f1 = 0;
		int f2 = 1;
		while (f2 <= s) {
			System.out.print(f2+ " ");
			int tmp = f1 + f2;
			f1 = f2;
			f2 = tmp;
		}
		System.out.println();
		int ncoins = 0;
		while (s > 0) {
			if (f1 <= s) {
				ncoins += (s / f1);
				s %= f1;
			}
			int tmp = f2 - f1;
			f2 = f1;
			f1 = tmp;
		}
		return ncoins;
	}

	public static void main(String[] args) {
		int s = Integer.parseInt(args[0]);
		System.out.println(s);
		System.out.println(minCoins(s));

	}

}
