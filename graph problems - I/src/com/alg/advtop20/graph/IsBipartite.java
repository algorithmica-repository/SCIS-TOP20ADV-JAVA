package com.alg.advtop20.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {

	private static void displayPartitions(int[] visit) {
		System.out.println("Partition-1");
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 1)
				System.out.print(u + " ");
		}
		System.out.println();

		System.out.println("Partition-2");
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 2)
				System.out.print(u + " ");
		}
		System.out.println();

	}

	// TC:Theta(V^2) SC:Theta(V)
	public static boolean isBipartite1(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				if (!auxDfs(u, 1, visit, in))
					return false;
			}
		}
		displayPartitions(visit);
		return true;
	}

	private static boolean auxDfs(int u, int c, int[] visit, int[][] in) {
		visit[u] = c;
		for (int v = 0; v < in.length; ++v) {
			if (in[u][v] == 1) {
				if (visit[v] == 0) { // forward edges
					if (!auxDfs(v, c == 1 ? 2 : 1, visit, in))
						return false;
				} else { // back edges
					if (visit[u] == visit[v])
						return false;
				}
			}
		}
		return true;
	}

	// ------------------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static boolean isBipartite2(int[][] in) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		for (int u = 0; u < visit.length; ++u) {
			if (visit[u] == 0) {
				if (!auxBfs(u, visit, in))
					return false;
			}
		}
		displayPartitions(visit);
		return true;
	}

	private static boolean auxBfs(int u, int[] visit, int[][] in) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		visit[u] = 1;

		while (!q.isEmpty()) {
			u = q.remove();
			for (int v = 0; v < in.length; ++v) {
				if (in[u][v] == 1) {
					if (visit[v] == 0) {
						q.add(v);
						visit[v] = (visit[u] == 1 ? 2 : 1);
					} else {
						if (visit[u] == visit[v])
							return false;
					}
				}
			}
		}
		return true;
	}

	// ----------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.randomUndirectedGraph(n);
		GraphUtils.display(in);
		System.out.println(isBipartite1(in));
		System.out.println(isBipartite2(in));

	}

}
