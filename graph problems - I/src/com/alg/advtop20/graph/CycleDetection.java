package com.alg.advtop20.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.advtop20.disjointset.UnionbySizePathCompressionTreeDisjointSet;

public class CycleDetection {

	// TC:Theta(V^2) SC:Theta(V)
	public static boolean detectCycle1(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				if (auxDfs(u, u, visit, in))
					return true;
			}
		}
		return false;
	}

	private static boolean auxDfs(int u, int parent, int[] visit, int[][] in) {
		visit[u] = 1;
		for (int v = 0; v < in.length; ++v) {
			if (in[u][v] == 1) {
				if (visit[v] == 0) { // forward edges
					if (auxDfs(v, u, visit, in))
						return true;
				} else { // back edges
					if (v != parent)
						return true;
				}
			}
		}
		return false;
	}

	// ------------------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static boolean detectCycle2(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				if (auxBfs(u, visit, in))
					return true;
			}
		}
		return false;
	}

	private static boolean auxBfs(int u, int[] visit, int[][] in) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		visit[u] = 1;

		while (!q.isEmpty()) {
			u = q.remove();
			visit[u] = 2;
			for (int v = 0; v < in.length; ++v) {
				if (in[u][v] == 1) {
					if (visit[v] == 0) {
						q.add(v);
						visit[v] = 1;
					} else {
						if (visit[v] == 1)
							return true;
					}
				}
			}
		}
		return false;
	}

	// ----------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static boolean detectCycle3(int[][] in) {
		UnionbySizePathCompressionTreeDisjointSet ds = new UnionbySizePathCompressionTreeDisjointSet(in.length);

		for (int u = 0; u < in.length; ++u) {
			for (int v = u + 1; v < in.length; ++v) {
				if (in[u][v] == 1) {
					if (ds.find(u) == ds.find(v))
						return true;
					ds.union(u, v);
				}
			}
		}
		return false;
	}

	// --------------------------------------------------------------

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.randomUndirectedGraph(n);
		GraphUtils.display(in);
		System.out.println(detectCycle1(in));
		System.out.println(detectCycle2(in));
		System.out.println(detectCycle3(in));
	}

}
