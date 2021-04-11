package com.alg.advtop20.string;

public class AllSubStrings {

	// TC:Theta(n^2) SC:O(1)
	public static void substr1(String s) {
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 0; j < s.length() - i + 1; ++j) {
				System.out.println(s.substring(j, j + i));
			}
		}
	}
	
	// TC:Theta(n^2) SC:O(1)
	public static void substr2(String s) {
		for (int i = 0; i < s.length(); ++i) {
			for (int j = i+1; j <= s.length(); ++j) {
				System.out.println(s.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		substr1(args[0]);
		substr2(args[0]);
	}

}
