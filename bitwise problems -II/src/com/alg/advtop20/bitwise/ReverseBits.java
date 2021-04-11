package com.alg.advtop20.bitwise;

public class ReverseBits {

	public static int reverse(int n) {
		BitwiseUtils.showBits(n);
		n = ((n & 0x55555555) << 1) | ((n >>> 1) & 0x55555555);
		BitwiseUtils.showBits(n);
		n = ((n & 0x33333333) << 2 ) | ((n >>> 2) & 0x33333333);
		BitwiseUtils.showBits(n);
		n = ((n & 0x0F0F0F0F) << 4 ) | ((n >>> 4) & 0x0F0F0F0F);
		BitwiseUtils.showBits(n);
		n = ((n & 0x00FF00FF) << 8 ) | ((n >>> 8) & 0x00FF00FF);
		BitwiseUtils.showBits(n);
		n = ((n & 0x0000FFFF) << 16 ) | ((n >>> 16) & 0x0000FFFF);
		BitwiseUtils.showBits(n);
		return n;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		reverse(n);
	}

}
