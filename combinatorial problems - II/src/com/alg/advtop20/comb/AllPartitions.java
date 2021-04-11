package com.alg.advtop20.comb;

public class AllPartitions {

	private static void auxPartitions(String in, String out) {
		if (in.length() == 0) {
			System.out.println(out);
			return;
		}
		String sep = "";
		for (int i = 0; i < in.length(); ++i) {
			if (out.length() != 0)
				sep = "+";
			auxPartitions(in.substring(i + 1), out + sep + in.substring(0, i + 1));
		}
	}

	// TC:Theta(2^n) SC:Theta(n)
	public static void partitions(String in) {
		auxPartitions(in, "");
	}

	public static void main(String[] args) {
		partitions(args[0]);

	}

}
