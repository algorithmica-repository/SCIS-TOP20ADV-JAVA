package com.alg.advtop20.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.advtop20.disjointset.UnionbySizePathCompressionTreeDisjointSet;

public class CountIslands {

	// TC:Theta(mn) SC:Theta(mn)
	public static int countIslands1(int[][] in) {
		int m = in.length;
		int n = in[0].length;
		int[][] visit = new int[m][n];

		int nislands = 0;
		for (int u = 0; u < m; ++u) {
			for (int v = 0; v < n; ++v) {
				if (in[u][v] == 1 && visit[u][v] == 0) {
					auxDfs(u, v, visit, in);
					++nislands;
				}
			}
		}
		return nislands;
	}

	private static void auxDfs(int u, int v, int[][] visit, int[][] in) {
		if (u < 0 || u >= in.length || v < 0 || v >= in[0].length || in[u][v] == 0 || visit[u][v] == 1)
			return;
		visit[u][v] = 1;
		auxDfs(u, v - 1, visit, in);
		auxDfs(u, v + 1, visit, in);
		auxDfs(u - 1, v, visit, in);
		auxDfs(u + 1, v, visit, in);
	}

	// ------------------------------------------------------------
	// TC:Theta(mn) SC:Theta(mn)
	public static int countIslands2(int[][] in) {
		int m = in.length;
		int n = in[0].length;
		int[][] visit = new int[m][n];

		int nislands = 0;
		for (int u = 0; u < m; ++u) {
			for (int v = 0; v < n; ++v) {
				if (in[u][v] == 1 && visit[u][v] == 0) {
					auxBfs(u, v, visit, in);
					++nislands;
				}
			}
		}
		return nislands;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static boolean isValid(int x, int y, int[][] visit, int[][] in) {
		if (x < 0 || y < 0 || x >= in.length || y >= in[0].length || in[x][y] == 0 || visit[x][y] == 1)
			return false;
		return true;
	}

	private static void auxBfs(int u, int v, int[][] visit, int[][] in) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(u, v));
		visit[u][v] = 1;

		while (!q.isEmpty()) {
			Pair p = q.remove();

			if (isValid(p.x, p.y - 1, visit, in)) {
				q.add(new Pair(p.x, p.y - 1));
				visit[p.x][p.y - 1] = 1;
			}
			if (isValid(p.x, p.y + 1, visit, in)) {
				q.add(new Pair(p.x, p.y + 1));
				visit[p.x][p.y + 1] = 1;
			}
			if (isValid(p.x - 1, p.y, visit, in)) {
				q.add(new Pair(p.x - 1, p.y));
				visit[p.x - 1][p.y] = 1;
			}
			if (isValid(p.x + 1, p.y, visit, in)) {
				q.add(new Pair(p.x + 1, p.y));
				visit[p.x + 1][p.y] = 1;
			}

		}
	}

	// -------------------------------------------------------------------
	private static void auxUnion(int i, int j, int x, int y, int[][] in, UnionbySizePathCompressionTreeDisjointSet ds) {
		if (x < 0 || x >= in.length || y < 0 || y >= in[0].length || in[x][y] == 0)
			return;
		int n = in[0].length;
		ds.union(i * n + j, x * n + y);
	}

	// TC:Theta(mn) SC:Theta(mn)
	public static int countIslands3(int[][] in) {
		int m = in.length;
		int n = in[0].length;
		UnionbySizePathCompressionTreeDisjointSet ds = new UnionbySizePathCompressionTreeDisjointSet(m * n);

		int nzeros = 0;
		for (int u = 0; u < m; ++u) {
			for (int v = 0; v < n; ++v) {
				if (in[u][v] == 1) {
					auxUnion(u, v, u - 1, v, in, ds);
					auxUnion(u, v, u, v - 1, in, ds);
				} else
					++nzeros;
			}
		}
		return ds.size() - nzeros;
	}

	// ------------------------------------------------------------------------
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int[][] in = GraphUtils.randomGrid(m, n, m + n);
		GraphUtils.display(in);
		System.out.println(countIslands1(in));
		System.out.println(countIslands2(in));
		System.out.println(countIslands3(in));
	}

}
