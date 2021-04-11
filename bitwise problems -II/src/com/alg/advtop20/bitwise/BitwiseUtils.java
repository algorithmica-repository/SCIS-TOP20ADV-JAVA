package com.alg.advtop20.bitwise;

public class BitwiseUtils {

	public static void showBits(int n) {
		int mask = 1 << 31;
		for (int i = 1; i <= 32; ++i) {
			if ((n & mask) != 0)
				System.out.print("1");
			else
				System.out.print("0");
			mask = mask >>> 1;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		showBits(n);
		showBits(-n);
	}

}
