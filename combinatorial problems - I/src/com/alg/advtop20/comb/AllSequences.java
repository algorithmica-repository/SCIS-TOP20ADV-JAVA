package com.alg.advtop20.comb;

public class AllSequences {

	private static void auxAllSeq(int n, String in, String out) {
		if (n == 0) {
			System.out.println(out);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			auxAllSeq(n - 1, in, out+in.charAt(i));
		}
	}

	//TC:Theta(n^n)  SC:Theta(n)
	public static void allSeq(String in) {
		auxAllSeq(in.length(), in, "");
	}

	public static void main(String[] args) {
		allSeq(args[0]);
	}

}
