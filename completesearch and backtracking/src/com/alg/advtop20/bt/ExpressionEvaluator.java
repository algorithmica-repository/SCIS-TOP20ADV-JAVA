package com.alg.advtop20.bt;

public class ExpressionEvaluator {
	// TODO: fillup the expression evaluation logic
	private static int eval(String expr) {
		return 0;
	}

	private static void auxEval1(String in, String out, int target) {
		if (in.length() == 0) {
			if (eval(out) == target)
				System.out.println(out);
			return;
		}
		auxEval1(in.substring(1), out + "+" + in.charAt(0), target);
		auxEval1(in.substring(1), out + "-" + in.charAt(0), target);
	}

	// TC:Theta(n*2^n-1) SC:Theta(n)
	public static void eval1(String in, int target) {
		auxEval1(in.substring(1), "" + in.charAt(0), target);
	}

	// -------------------------------------------------------------------
	private static void auxEval2(String in, String out, int target, int res) {
		if (in.length() == 0) {
			if (res == target)
				System.out.println(out);
			return;
		}
		auxEval2(in.substring(1), out + "+" + in.charAt(0), target, res + (in.charAt(0) - '0'));
		auxEval2(in.substring(1), out + "-" + in.charAt(0), target, res - (in.charAt(0) - '0'));
	}

	// TC:Theta(2^n-1) SC:Theta(n)
	public static void eval2(String in, int target) {
		auxEval2(in.substring(1), "" + in.charAt(0), target, in.charAt(0) - '0');
	}
	// -------------------------------------------------------------------

	public static void main(String[] args) {
		int target = Integer.parseInt(args[1]);
		eval2(args[0], target);
	}

}
