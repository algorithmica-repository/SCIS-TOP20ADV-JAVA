package com.alg.advtop20.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.advtop20.disjointset.UnionbySizePathCompressionTreeDisjointSet;

public class CountFriendCircles {

	// TC:Theta(V^2) SC:Theta(V)
	public static int countCircles1(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		int ncircles = 0;
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				auxDfs(u, visit, in);
				++ncircles;
			}
		}
		return ncircles;
	}

	private static void auxDfs(int u, int[] visit, int[][] in) {
		visit[u] = 1;
		for (int v = 0; v < in.length; ++v) {
			if (in[u][v] == 1 && visit[v] == 0)
				auxDfs(v, visit, in);
		}
	}

	// ------------------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static int countCircles2(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		int ncircles = 0;
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				auxBfs(u, visit, in);
				++ncircles;
			}
		}
		return ncircles;
	}

	private static void auxBfs(int u, int[] visit, int[][] in) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		visit[u] = 1;

		while (!q.isEmpty()) {
			u = q.remove();
			for (int v = 0; v < in.length; ++v) {
				if (in[u][v] == 1 && visit[v] == 0) {
					q.add(v);
					visit[v] = 1;
				}
			}
		}
	}

	// ------------------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static int countCircles3(int[][] in) {
		UnionbySizePathCompressionTreeDisjointSet ds = new UnionbySizePathCompressionTreeDisjointSet(in.length);

		for (int u = 0; u < in.length; ++u) {
			for (int v = 0; v < in.length; ++v) {
				if (in[u][v] == 1)
					ds.union(u, v);
			}
		}
		return ds.size();
	}

	// --------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.randomUndirectedGraph(n);
		GraphUtils.display(in);
		System.out.println(countCircles1(in));
		System.out.println(countCircles2(in));
		System.out.println(countCircles3(in));
	}

}
