package com.alg.advtop20.graph;

import java.util.Arrays;
import java.util.Random;

public class GraphUtils {

	public static int[][] randomUndirectedGraph(int n) {
		int[][] in = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if (u != v) {
				in[u][v] = 1;
				in[v][u] = 1;
			}
		}
		return in;
	}

	public static int[][] randomGrid(int m, int n, int nedges) {
		int[][] in = new int[m][n];
		Random r = new Random();
		for (int i = 0; i < nedges; ++i) {
			int u = r.nextInt(m);
			int v = r.nextInt(n);
			in[u][v] = 1;
		}
		return in;
	}

	public static int[][] completeGraph(int n) {
		int[][] in = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				in[i][j] = 1;
				in[j][i] = 1;
			}
		}
		return in;
	}

	public static void display(int[][] in) {
		for (int[] tmp : in) {
			System.out.println(Arrays.toString(tmp));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
