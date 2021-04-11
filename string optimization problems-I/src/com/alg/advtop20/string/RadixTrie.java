package com.alg.advtop20.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RadixTrie {

	private RadixNode root;

	public RadixTrie() {
		root = new RadixNode();
	}


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


	public List<String> startsWith(String prefix) {
		RadixNode res = findLastNode(prefix);
		if (res == null)
			return null;
		return res.words;
	}

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
			children = new HashMap<Character, RadixNode>();
			words = new ArrayList<String>();
		}
	}

}
