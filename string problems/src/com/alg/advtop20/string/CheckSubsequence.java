package com.alg.advtop20.string;

public class CheckSubsequence {

	// TC:Theta(n) SC:O(1)
	public static boolean isSubseq(String s1, String s2) {
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				++i;
			}
			++j;
		}
		if (i < s1.length())
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(isSubseq(args[0], args[1]));

	}

}
