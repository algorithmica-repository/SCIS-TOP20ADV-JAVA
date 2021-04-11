package com.alg.advtop20.trie.applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RadixTrie {

	private RadixNode root;

	public RadixTrie() {
		root = new RadixNode();
	}

	public void add(String word, String val) {
		RadixNode current = root;
		for (int i = 0; i < word.length(); ++i) {
			if (current.children.get(word.charAt(i)) == null)
				current.children.put(word.charAt(i), new RadixNode());
			current.words.add(val);
			current = current.children.get(word.charAt(i));
		}
		current.isword = true;
		current.words.add(val);
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
		RadixNode node = findLastNode(prefix);
		if (node == null)
			return null;
		List<String> res = new ArrayList<String>();
		for (String w : node.words)
			res.add(w);
		return res;
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
		Set<String> words;

		public RadixNode() {
			isword = false;
			children = new HashMap<Character, RadixTrie.RadixNode>();
			words = new HashSet<String>();
		}
	}

}
