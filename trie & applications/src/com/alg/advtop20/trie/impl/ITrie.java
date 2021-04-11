package com.alg.advtop20.trie.impl;

import java.util.List;

public interface ITrie {
	void add(String word);

	boolean contains(String word);

	List<String> startsWith(String prefix);

	String lcp(String word);

}
