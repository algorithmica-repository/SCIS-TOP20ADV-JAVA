package com.alg.advtop20.minisd.cassandra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;

public class MiniCassandra {
	private HashMap<String, TreeMap<Integer, String>> store;

	public MiniCassandra() {
		store = new HashMap<String, TreeMap<Integer, String>>();
	}

	public void put(String key, String val, int ts) {
		TreeMap<Integer, String> user_messages = store.get(key);
		if (user_messages == null) {
			user_messages = new TreeMap<Integer, String>();
			store.put(key, user_messages);
		}
		user_messages.put(ts, val);
	}

	public Entry<Integer, String> get(String key, int ts) {
		TreeMap<Integer, String> user_messages = store.get(key);
		if (user_messages == null)
			return null;
		return user_messages.floorEntry(ts);
	}

	public List<Entry<Integer, String>> query(String key, int ts_start, int ts_end) {
		TreeMap<Integer, String> user_messages = store.get(key);
		if (user_messages == null)
			return null;
		SortedMap<Integer, String> tmp = user_messages.subMap(ts_start, ts_end);
		List<Entry<Integer, String>> res = new ArrayList<Entry<Integer, String>>();
		for (Entry<Integer, String> e : tmp.entrySet())
			res.add(e);
		return res;
	}

	public void display() {
		System.out.println(store);
	}

	public static void main(String[] args) {
		MiniCassandra cassandra = new MiniCassandra();
		Random r = new Random();
		for (int ts = 0; ts < 20; ++ts) {
			int rid = r.nextInt(5);
			cassandra.put("user" + rid, "message" + rid + "_" + ts, ts);
		}
		cassandra.display();
		for (int i = 0; i < 5; ++i) {
			int rid = r.nextInt(5);
			int rts = r.nextInt(20);
			System.out.println("user" + rid + "," + rts);
			System.out.println(cassandra.get("user" + rid, rts));
		}
		for (int i = 0; i < 5; ++i) {
			int rid = r.nextInt(5);
			System.out.println("user" + rid + "(4, 10)");
			System.out.println(cassandra.query("user" + rid, 4, 10));
		}

	}

}
