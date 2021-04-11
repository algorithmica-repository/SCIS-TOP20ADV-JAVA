package com.alg.advtop20.trie.impl;

import java.util.ArrayList;
import java.util.List;

class TSTNode {
	boolean isword;
	TSTNode left, middle, right;
	char data;
	List<String> words;

	public TSTNode() {
		words = new ArrayList<String>();
	}

	public TSTNode(char data) {
		isword = false;
		this.data = data;
		words = new ArrayList<String>();
	}
}

public class TSTTrie implements ITrie {
	private TSTNode root;

	public TSTTrie() {
		root = new TSTNode();
	}

	private TSTNode auxAdd(int i, String word, TSTNode current) {
		if (current == null) {
			current = new TSTNode(word.charAt(i));
		}
		if (word.charAt(i) == current.data) {
			if (i == word.length() - 1)
				current.isword = true;
			if (i < word.length() - 1)
				current.middle = auxAdd(i + 1, word, current.middle);
			current.words.add(word);
		} else if (word.charAt(i) < current.data) {
			current.left = auxAdd(i, word, current.left);
		} else {
			current.right = auxAdd(i, word, current.right);
		}
		return current;
	}

	@Override
	public void add(String word) {
		root.words.add(word);
		TSTNode res = auxAdd(0, word, root.middle);
		if (root.middle == null)
			root.middle = res;
	}

	@Override
	public boolean contains(String word) {
		TSTNode res = findLastNode(word);
		if (res == null)
			return false;
		return res.isword;
	}

	private TSTNode findLastNode(String word) {
		TSTNode current = root.middle;
		for (int i = 0; i < word.length(); ) {
			if (current == null)
				return null;
			if (word.charAt(i) == current.data) {
				if (i < word.length() - 1)
					current = current.middle;
				++i;
			}else if (word.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return current;
	}

	@Override
	public List<String> startsWith(String prefix) {
		if (prefix.length() == 0)
			return root.words;
		TSTNode res = findLastNode(prefix);
		if (res == null)
			return null;
		return res.words;
	}

	@Override
	public String lcp(String word) {
		TSTNode current = root.middle;
		int i;
		for (i = 0; i < word.length(); ) {
			if (current == null)
				break;
			if (word.charAt(i) == current.data) {
				current = current.middle;
				++i;
			}
			else if (word.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return word.substring(0, i);
	}

	private static void auxDisplay(TSTNode root, int nspaces, String annotation) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(" ");
		System.out.println(root.data + "(" + annotation + ")" + root.words);
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.middle, nspaces + 4, "M");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	public void display() {
		auxDisplay(root.middle, 0, "root");
	}

	public static void main(String[] args) {
		TSTTrie trie = new TSTTrie();
		String[] words = { "abc", "ab", "abcd", "ade", "xyz", "bcd", "cat" };
		for (String word : words)
			trie.add(word);
		trie.display();
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
