package com.alg.advtop20.disjointset;

import java.util.Arrays;
import java.util.Random;

public class UnionbySizeTreeDisjointSet implements IDisjointSet {
	private int[] parent;
	private int[] rank;
	private int size;

	public UnionbySizeTreeDisjointSet(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 1;
		}
		size = n;
	}

	// TC:O(log n)
	@Override
	public int find(int x) {
		while (parent[x] != x)
			x = parent[x];
		return x;
	}

	// TC:O(log n)
	@Override
	public void union(int x, int y) {
		int idx = find(x);
		int idy = find(y);
		if (idx == idy)
			return;
		--size;
		if (rank[idx] > rank[idy]) {
			parent[idy] = idx;
			rank[idx] += rank[idy];
		} else {
			parent[idx] = idy;
			rank[idy] += rank[idx];
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void display() {
		System.out.println(Arrays.toString(parent));
		System.out.println(Arrays.toString(rank));
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		IDisjointSet s1 = new UnionbySizeTreeDisjointSet(n);
		s1.display();
		Random r = new Random();
		for(int i = 0; i < n/2; ++i) {
			int x = r.nextInt(n);
			int y = r.nextInt(n);
			System.out.println(x +"," + y);
			s1.union(x, y);
			s1.display();
		}
		System.out.println(s1.size());
		System.out.println(s1.find(0));
		System.out.println(s1.find(n-1));
	
	}

}
