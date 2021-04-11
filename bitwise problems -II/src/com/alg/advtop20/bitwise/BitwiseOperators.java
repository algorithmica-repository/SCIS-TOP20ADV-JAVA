package com.alg.advtop20.bitwise;

public class BitwiseOperators {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		BitwiseUtils.showBits(n);
		BitwiseUtils.showBits(m);
		BitwiseUtils.showBits(n&m);
		BitwiseUtils.showBits(n|m);
		BitwiseUtils.showBits(n^m);
		BitwiseUtils.showBits(n<<1);
		BitwiseUtils.showBits(n>>>1);
		BitwiseUtils.showBits(n>>1);
		BitwiseUtils.showBits(~n);
	}

}
