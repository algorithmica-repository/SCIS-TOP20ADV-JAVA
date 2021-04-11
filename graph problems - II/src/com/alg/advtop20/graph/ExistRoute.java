package com.alg.advtop20.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ExistRoute {

	// TC:Theta(V^2) SC:Theta(V)
	public static boolean existsRoute1(int[][] in, int s, int t) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		return auxDfs(s, t, visit, in);
	}

	private static boolean auxDfs(int s, int t, int[] visit, int[][] in) {
		if (s == t)
			return true;
		visit[s] = 1;
		for (int v = 0; v < in.length; ++v) {
			if (in[s][v] == 1 && visit[v] == 0)
				if (auxDfs(v, t, visit, in))
					return true;
		}
		return false;
	}

	// -----------------------------------------------------------------------
	// TC:Theta(V^2) SC:Theta(V)
	public static boolean existsRoute2(int[][] in, int s, int t) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		return auxBfs(s, t, visit, in);
	}

	private static boolean auxBfs(int s, int t, int[] visit, int[][] in) {
		if(s == t) return true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visit[s] = 1;

		while (!q.isEmpty()) {
			s = q.remove();
			for (int v = 0; v < in.length; ++v) {
				if (in[s][v] == 1 && visit[v] == 0) {
					if (v == t)
						return true;
					q.add(v);
					visit[v] = 1;
				}
			}
		}
		return false;
	}
	// ------------------------------------------------------------------

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.randomUndirectedGraph(n);
		GraphUtils.display(in);
		Random r = new Random();
		int s = r.nextInt(n);
		int t = r.nextInt(n);
		System.out.println(s + "," + t);
		System.out.println(existsRoute1(in, s, t));
		System.out.println(existsRoute2(in, s, t));
	}

}
