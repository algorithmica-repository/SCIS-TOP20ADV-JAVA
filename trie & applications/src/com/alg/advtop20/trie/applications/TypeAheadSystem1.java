package com.alg.advtop20.trie.applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TypeAheadSystem1 {
	private HashMap<String, HashSet<String>> index;

	public TypeAheadSystem1() {
		index = new HashMap<String, HashSet<String>>();
	}

	public void build(String[] names) {
		for (String name : names) {
			for (int i = 0; i < name.length(); ++i) {
				for (int j = i + 1; j <= name.length(); ++j) {
					String key = name.substring(i, j);
					// System.out.println(key);
					HashSet<String> values = index.get(key);
					if (values == null) {
						values = new HashSet<String>();
						index.put(key, values);
					}
					values.add(name);
				}
			}
		}
	}

	public void display() {
		System.out.println(index);
	}

	public List<String> query(String text) {
		HashSet<String> values = index.get(text);
		if (values == null)
			return null;

		List<String> res = new ArrayList<String>();
		for (String v : values)
			res.add(v);
		return res;
	}

	public static void main(String[] args) {
		String[] names = { "krishna", "jesus", "yoga", "karma yoga", "lord", "bhakti yoga" };
		TypeAheadSystem1 system = new TypeAheadSystem1();
		system.build(names);
		system.display();
		System.out.println(system.query(args[0]));

	}

}
