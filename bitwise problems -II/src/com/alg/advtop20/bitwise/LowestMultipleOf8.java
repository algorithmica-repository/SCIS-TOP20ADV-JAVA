package com.alg.advtop20.bitwise;

public class LowestMultipleOf8 {
	
	public static int lowest11(int n) {
		return n & ~7;
	}
	public static int lowest12(int n) {
		return n & -8;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(n);
		BitwiseUtils.showBits(n);
		int res = lowest11(n);
		System.out.println(res);
		BitwiseUtils.showBits(res);
		res = lowest12(n);
		System.out.println(res);
		BitwiseUtils.showBits(res);

	}

}
