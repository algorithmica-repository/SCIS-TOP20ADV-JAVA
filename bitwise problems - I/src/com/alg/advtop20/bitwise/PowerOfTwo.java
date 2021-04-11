package com.alg.advtop20.bitwise;

public class PowerOfTwo {

	public static boolean powerOfTwo1(int n) {
		int mask = 1 << 31;
		int n_ones = 0;
		for (int i = 1; i <= 32; ++i) {
			if ((n & mask) != 0)
				++n_ones;
			mask = mask >>> 1;
		}
		if (n_ones == 1)
			return true;
		return false;
	}

	public static boolean powerOfTwo2(int n) {
		if (n == 0)
			return false;
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(powerOfTwo1(n));
		System.out.println(powerOfTwo2(n));
	}

}
