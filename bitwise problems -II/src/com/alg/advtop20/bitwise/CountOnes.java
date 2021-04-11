package com.alg.advtop20.bitwise;

public class CountOnes {

	public static int countOnes1(int n) {
		int mask = 1 << 31;
		int n_ones = 0;
		for (int i = 1; i <= 32; ++i) {
			if ((n & mask) != 0)
				++n_ones;
			mask = mask >>> 1;
		}
		return n_ones;
	}

	public static int countOnes2(int n) {
		int n_ones = 0;
		while (n > 0) {
			n = n & (n - 1);
			++n_ones;
		}
		return n_ones;
	}

	public static int countOnes3(int n) {
		int ones[] = { 0, 1, 1, 2 };
		int n_ones = 0;
		while (n > 0) {
			n_ones += ones[n & 3];
			n = n >>> 2;
		}
		return n_ones;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitwiseUtils.showBits(n);
		System.out.println(countOnes1(n));
		System.out.println(countOnes2(n));
		System.out.println(countOnes3(n));
	}

}
