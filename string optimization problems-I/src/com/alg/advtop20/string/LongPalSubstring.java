package com.alg.advtop20.string;

public class LongPalSubstring {

	private static boolean isPal(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				++start;
				--end;
			} else
				return false;
		}
		return true;
	}

	// TC:O(n^3) SC:O(1)
	public static String longPalSubstr1(String s) {
		for (int i = s.length(); i >= 1; --i) {
			for (int j = 0; j < s.length() - i + 1; ++j) {
				if (isPal(s, j, j + i - 1))
					return s.substring(j, j + i);
			}
		}
		return "";
	}

	// --------------------------------------------------
	// TC:Theta(n^2) SC:Theta(n^2)
	public static String longPalSubstr2(String s) {
		int n = s.length();
		boolean[][] mem = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= i; ++j) {
				mem[i][j] = true;
			}
		}
		int maxlen = 0;
		int pos = 0;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j)) {
					mem[i][j] = mem[i + 1][j - 1];
					if (mem[i][j]) {
						if (j - i + 1 > maxlen) {
							maxlen = j - i + 1;
							pos = i;
						}
					}
				} else {
					mem[i][j] = false;
				}
			}
		}
		return s.substring(pos, pos + maxlen);
	}

	// --------------------------------------------------
	// TC:Theta(n^2) SC:O(1)
	// TODO:Retrieve string by maintaining pos
	public static int longPalSubstr3(String s) {
		int maxlen = 0;

		for (int i = 0; i < s.length(); ++i) {
			int odd = expandPal(s, i - 1, i + 1) + 1;
			int even = expandPal(s, i, i + 1);
			maxlen = Math.max(maxlen, Math.max(odd, even));
		}
		return maxlen;
	}

	private static int expandPal(String s, int i, int j) {
		int len = 0;
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				--i;
				++j;
				len += 2;
			}
			else
				break;
		}
		return len;
	}

	// -----------------------------------------------------
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(longPalSubstr2(args[0]));
		System.out.println(longPalSubstr3(args[0]));
	}

}
