package com.alg.advtop20.string;

import java.util.Arrays;

public class LongCommonSubstring {

	private static int commonPrefix(String s1, String s2, int i, int j) {
		int len = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				++j;
				++i;
				++len;
			} else
				break;
		}
		return len;
	}

	// TC:O(n^3) SC:O(1)
	public static int longCommSubstr2(String s1, String s2) {
		int maxlen = 0;
		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0; j < s2.length(); ++j) {
				int clen = commonPrefix(s1, s2, i, j);
				maxlen = Math.max(maxlen, clen);
			}
		}
		return maxlen;
	}

	// TC:O(n^2 log n) SC:Theta(n^2)
	public static int longCommSubstr3(String s1, String s2) {
		String[] suffix_array = new String[s1.length() + s2.length()];
		int i;
		for (i = 0; i < s1.length(); ++i)
			suffix_array[i] = s1.substring(i) + "#";
		for (int j = 0; j < s2.length(); ++j)
			suffix_array[i + j] = s2.substring(j) + "$";

		Arrays.sort(suffix_array);
		// System.out.println(Arrays.toString(suffix_array));
		int maxlen = 0;
		for (i = 1; i < suffix_array.length; ++i) {
			if ((suffix_array[i - 1].endsWith("#") && suffix_array[i].endsWith("$"))
					|| (suffix_array[i - 1].endsWith("$") && suffix_array[i].endsWith("#"))) {
				int clen = commonPrefix(suffix_array[i - 1], suffix_array[i], 0, 0);
				maxlen = Math.max(maxlen, clen);
			}
		}
		return maxlen;
	}

	// TC:O(n^2) SC:Theta(n^2)
	public static int longCommSubstr4(String s1, String s2) {
		RadixTrie trie = new RadixTrie();
		for (int i = 0; i < s1.length(); ++i)
			trie.add(s1.substring(i));

		int maxlen = 0;
		for (int i = 0; i < s2.length(); ++i) {
			String res = trie.lcp(s2.substring(i));
			maxlen = Math.max(maxlen, res.length());
		}
		return maxlen;
	}

	// TC:O(n^2) SC:Theta(n^2)
	public static int longCommSubstr5(String s1, String s2) {
		int maxlen = 0;
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];
		for (int j = 0; j < s1.length(); ++j)
			mem[s1.length()][j] = 0;
		for (int i = 0; i < s2.length(); ++i)
			mem[i][s2.length()] = 0;
		for (int i = s1.length() - 1; i >= 0; --i) {
			for (int j = 0; j < s2.length(); ++j) {
				if (s1.charAt(i) == s2.charAt(j)) {
					mem[i][j] = 1 + mem[i + 1][j + 1];
					maxlen = Math.max(maxlen, mem[i][j]);
				} else
					mem[i][j] = 0;
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(longCommSubstr5(args[0], args[1]));

	}

}
