package com.alg.advtop20.graph;

import java.util.Random;

public class ExploreAllSimpleRoutes {

	// TC:Theta(V^V) SC:Theta(V)
	public static void allRoutes(int[][] in, int s, int t) {
		int[] visit = new int[in.length];
		for (int u = 0; u < visit.length; ++u) {
			visit[u] = 0;
		}
		auxDfs(s, t, visit, in, s + "");
	}

	private static void auxDfs(int s, int t, int[] visit, int[][] in, String path) {
		if (s == t) {
			System.out.println(path);
			return;
		}
		visit[s] = 1;
		for (int v = 0; v < in.length; ++v) {
			if (in[s][v] == 1 && visit[v] == 0)
				auxDfs(v, t, visit, in, path + "->" + v);
		}
		visit[s] = 0;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.completeGraph(n);
		GraphUtils.display(in);
		Random r = new Random();
		int s = r.nextInt(n);
		int t = r.nextInt(n);
		System.out.println(s + "," + t);
		allRoutes(in, s, t);
	}

}
