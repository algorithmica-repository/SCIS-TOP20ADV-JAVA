package com.alg.advtop20.comb;

public class AllCombinations {

	private static void auxCombinations1(String in, String out) {
		/*
		 * if (in.length() == 0) { System.out.println(out); return; }
		 */
		System.out.println(out);
		for (int i = 0; i < in.length(); ++i) {
			auxCombinations1(in.substring(i + 1), out + in.charAt(i));
		}
	}

	// TC:Theta(2^n) SC:Theta(n)
	public static void combinations1(String in) {
		auxCombinations1(in, "");
	}

	// -------------------------------------------------------------------
	private static void auxCombinations2(String in, String out) {
		if (in.length() == 0) {
			System.out.println(out);
			return;
		}
		auxCombinations2(in.substring(1), out + in.charAt(0));
		auxCombinations2(in.substring(1), out);
	}

	// TC:Theta(2^n+1) SC:Theta(n)
	public static void combinations2(String in) {
		auxCombinations2(in, "");
	}

	// -------------------------------------------------------------------
	// TC:Theta(n * 2^n) SC:O(1)
	public static void combinations3(String in) {
		int n = in.length();
		for(int i = 0; i < 1<<n; ++i) {
			for(int j = 0; j < n; ++j) {
				if( (i & (1 << j)) != 0) 
					System.out.print(in.charAt(j));				
			}
			System.out.println();			
		}
	}
	// -------------------------------------------------------------------

	public static void main(String[] args) {
		combinations3(args[0]);
	}

}
