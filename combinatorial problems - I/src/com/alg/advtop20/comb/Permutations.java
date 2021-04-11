package com.alg.advtop20.comb;

public class Permutations {

	private static boolean isValid1(String out) {
		for (int i = 1; i < out.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (out.charAt(i) == out.charAt(j))
					return false;
			}
		}
		return true;
	}

	private static void auxPermutations1(int n, String in, String out) {
		if (n == 0) {
			if (isValid1(out))
				System.out.println(out);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			auxPermutations1(n - 1, in, out + in.charAt(i));
		}
	}

	// TC:Theta(n^n+1) SC:Theta(n)
	public static void permutations1(String in) {
		auxPermutations1(in.length(), in, "");
	}

	// --------------------------------------------------------------------
	private static boolean isValid2(char c, String out) {
		for (int i = 0; i < out.length(); ++i) {
			if (c == out.charAt(i))
				return false;
		}
		return true;
	}

	private static void auxPermutations2(int n, String in, String out) {
		if (n == 0) {
			System.out.println(out);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			if (isValid2(in.charAt(i), out))
				auxPermutations2(n - 1, in, out + in.charAt(i));
		}
	}

	// TC:Theta(n^n) SC:Theta(n)
	public static void permutations2(String in) {
		auxPermutations2(in.length(), in, "");
	}

	// -----------------------------------------------------------------------
	private static void auxPermutations3(String in, String out) {
		if (in.length() == 0) {
			System.out.println(out);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			auxPermutations3(in.substring(0, i) + in.substring(i + 1), out + in.charAt(i));
		}
	}

	// TC:Theta(n^n) SC:Theta(n)
	public static void permutations3(String in) {
		auxPermutations3(in, "");
	}
	// -----------------------------------------------------------------------

	public static void main(String[] args) {
		permutations3(args[0]);

	}

}
