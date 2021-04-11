package com.alg.advtop20.string;

public class AllSubsequences {

	private static void auxSubsequences1(String in, String out) {
		/*
		 * if (in.length() == 0) { System.out.println(out); return; }
		 */
		System.out.println(out);
		for (int i = 0; i < in.length(); ++i) {
			auxSubsequences1(in.substring(i + 1), out + in.charAt(i));
		}
	}

	// TC:Theta(2^n) SC:Theta(n)
	public static void subsequences1(String in) {
		auxSubsequences1(in, "");
	}

	// -------------------------------------------------------------------
	private static void auxSubsequences2(String in, String out) {
		if (in.length() == 0) {
			System.out.println(out);
			return;
		}
		auxSubsequences2(in.substring(1), out + in.charAt(0));
		auxSubsequences2(in.substring(1), out);
	}

	// TC:Theta(2^n+1) SC:Theta(n)
	public static void subsequences2(String in) {
		auxSubsequences2(in, "");
	}

	// -------------------------------------------------------------------
	// TC:Theta(n * 2^n) SC:O(1)
	public static void subsequences3(String in) {
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
		subsequences3(args[0]);
	}

}
