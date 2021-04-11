package com.alg.advtop20.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;

class TreeNode {
	char character;
	int freq;
	TreeNode left;
	TreeNode right;

	public TreeNode(char character, int freq, TreeNode left, TreeNode right) {
		super();
		this.character = character;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

}

class MyComparator implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		return o1.freq - o2.freq;
	}

}

public class HuffmanEncoderDecoder {
	private TreeNode root;

	private static void auxDisplay(TreeNode root, int nspaces, String annotation) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(" ");
		System.out.println(root.character + "(" + root.freq + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	private static void display(TreeNode root) {
		auxDisplay(root, 0, "root");
	}

	public void buildTree(String in) {
		// find the frquencies of characters
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < in.length(); ++i) {
			Integer val = freq.get(in.charAt(i));
			if (val == null)
				freq.put(in.charAt(i), 1);
			else
				freq.put(in.charAt(i), val + 1);
		}
		System.out.println(freq);

		// build the huffman tree
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(new MyComparator());
		for (Entry<Character, Integer> e : freq.entrySet())
			pq.add(new TreeNode(e.getKey(), e.getValue(), null, null));

		while (pq.size() > 1) {
			TreeNode smallest1 = pq.remove();
			TreeNode smallest2 = pq.remove();
			pq.add(new TreeNode('#', smallest1.freq + smallest2.freq, smallest1, smallest2));
		}
		root = pq.remove();
		display(root);
	}

	private void auxEncode(TreeNode root, String code, HashMap<Character, String> enc) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			enc.put(root.character, code);
			return;
		}
		auxEncode(root.left, code + "0", enc);
		auxEncode(root.right, code + "1", enc);
	}

	public String encode(String in) {
		// get the encodings
		HashMap<Character, String> enc = new HashMap<Character, String>();
		auxEncode(root, "", enc);
		System.out.println(enc);

		// encode the input string
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < in.length(); ++i)
			res.append(enc.get(in.charAt(i)));
		return res.toString();
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public String decode(String in) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < in.length();) {
			TreeNode current = root;
			while (!isLeaf(current)) {
				if (in.charAt(i++) == '0')
					current = current.left;
				else
					current = current.right;
			}
			res.append(current.character);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		StringBuilder in = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in.append((char) ('a' + r.nextInt(26)));
		}
		System.out.println(in);

		HuffmanEncoderDecoder enc_dec = new HuffmanEncoderDecoder();
		enc_dec.buildTree(in.toString());
		String enc = enc_dec.encode(in.toString());
		System.out.println(enc);
		System.out.println(enc_dec.decode(enc));

	}

}
