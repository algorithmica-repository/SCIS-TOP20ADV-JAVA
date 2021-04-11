package com.alg.advtop20.trie.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RadixTrie2 implements ITrie {

	private RadixNode root;

	public RadixTrie2() {
		root = new RadixNode();
	}

	@Override
	public void add(String word) {
		RadixNode current = root;
		for (int i = 0; i < word.length(); ++i) {
			if (current.children.get(word.charAt(i)) == null)
				current.children.put(word.charAt(i), new RadixNode());
			current.words.add(word);
			current = current.children.get(word.charAt(i));
		}
		current.isword = true;
		current.words.add(word);
	}

	@Override
	public boolean contains(String word) {
		RadixNode res = findLastNode(word);
		if (res == null)
			return false;
		return res.isword;
	}

	private RadixNode findLastNode(String word) {
		RadixNode current = root;
		for (int i = 0; i < word.length(); ++i) {
			if (current.children.get(word.charAt(i)) == null)
				return null;
			current = current.children.get(word.charAt(i));
		}
		return current;
	}

	@Override
	public List<String> startsWith(String prefix) {
		RadixNode res = findLastNode(prefix);
		if (res == null)
			return null;
		return res.words;
	}

	@Override
	public String lcp(String word) {
		RadixNode current = root;
		int i;
		for (i = 0; i < word.length(); ++i) {
			if (current.children.get(word.charAt(i)) == null)
				break;
			current = current.children.get(word.charAt(i));
		}
		return word.substring(0, i);
	}

	class RadixNode {
		boolean isword;
		HashMap<Character, RadixNode> children;
		List<String> words;

		public RadixNode() {
			isword = false;
			children = new HashMap<Character, RadixTrie2.RadixNode>();
			words = new ArrayList<String>();
		}
	}

	public static void main(String[] args) {
		ITrie trie = new RadixTrie();
		String[] words = { "abc", "ab", "abcd", "ade", "xyz", "bcd", "cat" };
		for (String word : words)
			trie.add(word);
		System.out.println(trie.startsWith(""));
		System.out.println(trie.startsWith("de"));
		System.out.println(trie.startsWith("ab"));
		System.out.println(trie.startsWith("abc"));

		System.out.println(trie.lcp("abxy"));
		System.out.println(trie.lcp("xyz"));
		System.out.println(trie.lcp("pqr"));

		System.out.println(trie.contains("abxy"));
		System.out.println(trie.contains("ab"));

	}

}
