package com.alg.advtop20.trie.applications;

import java.util.List;

public class TypeAheadSystem2 {
	private RadixTrie index;

	public TypeAheadSystem2() {
		index = new RadixTrie();
	}

	public void build(String[] names) {
		for (String name : names) {
			for (int i = 0; i < name.length(); ++i) {
				String key = name.substring(i);
				index.add(key, name);
			}
		}
	}

	public void display() {
		System.out.println(query(""));
	}

	public List<String> query(String text) {
		return index.startsWith(text);
	}

	public static void main(String[] args) {
		String[] names = { "krishna", "jesus", "yoga", "karma yoga", "lord", "bhakti yoga" };
		TypeAheadSystem2 system = new TypeAheadSystem2();
		system.build(names);
		system.display();
		System.out.println(system.query(args[0]));
	}

}
