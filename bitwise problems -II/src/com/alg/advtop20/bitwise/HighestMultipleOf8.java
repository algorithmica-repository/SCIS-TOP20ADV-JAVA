package com.alg.advtop20.bitwise;

public class HighestMultipleOf8 {

	public static int highest11(int n) {
		return (n + 7) & ~7;
	}

	public static int highest12(int n) {
		return (n + 7) & -8;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(n);
		BitwiseUtils.showBits(n);
		int res = highest11(n);
		System.out.println(res);
		BitwiseUtils.showBits(res);
		res = highest12(n);
		System.out.println(res);
		BitwiseUtils.showBits(res);

	}

}
