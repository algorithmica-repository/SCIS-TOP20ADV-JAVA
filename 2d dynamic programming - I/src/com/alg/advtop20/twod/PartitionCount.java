package com.alg.advtop20.twod;

import java.util.Arrays;

public class PartitionCount {

	// TC:Theta(n^3) SC:Theta(n^2)
	public static int partitionCount31(int n) {
		int[][] mem = new int[n + 1][n + 1];
		for (int j = 1; j <= n; ++j)
			mem[0][j] = mem[1][j] = mem[j][1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int j = 2; j <= n; ++j) {
				if (j > i)
					mem[i][j] = mem[i][i];
				else {
					int sum = 0;
					for (int k = j; k >= 1; --k)
						sum += mem[i - k][k];
					mem[i][j] = sum;
				}
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		return mem[n][n];
	}

	// TC:Theta(n^2) SC:Theta(n^2)
	public static int partitionCount32(int n) {
		int[][] mem = new int[n + 1][n + 1];
		for (int j = 1; j <= n; ++j)
			mem[0][j] = mem[1][j] = mem[j][1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int j = 2; j <= n; ++j) {
				if (j > i)
					mem[i][j] = mem[i][i];
				else
					mem[i][j] = mem[i][j - 1] + mem[i - j][j];
			}
		}
		for (int[] tmp : mem)
			System.out.println(Arrays.toString(tmp));
		return mem[n][n];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(n);
		System.out.println(partitionCount31(n));
		System.out.println(partitionCount32(n));
	}

}
