package com.alg.advtop20.treedp;

import java.util.HashMap;

public class TreeMaxNonAdjacentSum {

	// TC:Theta(n^2) SC:Theta(n)
	public static int maxNonAdjacentSum1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return Math.max(0, root.data);
		int incl_sum = root.data;
		if (root.left != null) {
			if (root.left.left != null)
				incl_sum += maxNonAdjacentSum1(root.left.left);
			if (root.left.right != null)
				incl_sum += maxNonAdjacentSum1(root.left.right);
		}
		if (root.right != null) {
			if (root.right.left != null)
				incl_sum += maxNonAdjacentSum1(root.right.left);
			if (root.right.right != null)
				incl_sum += maxNonAdjacentSum1(root.right.right);
		}

		int excl_sum = 0;
		if (root.left != null)
			excl_sum += maxNonAdjacentSum1(root.left);
		if (root.right != null)
			excl_sum += maxNonAdjacentSum1(root.right);
		return Math.max(incl_sum, excl_sum);
	}
	// ------------------------------------------------------------

	// TC:Theta(n) SC:Theta(n)
	public static int maxNonAdjacentSum2(TreeNode root) {
		HashMap<TreeNode, Integer> mem = new HashMap<TreeNode, Integer>();
		auxNonAdjacentSum2(root, mem);
		return mem.get(root);
	}

	public static int auxNonAdjacentSum2(TreeNode root, HashMap<TreeNode, Integer> mem) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return Math.max(0, root.data);
		if (mem.get(root) != null)
			return mem.get(root);
		int incl_sum = root.data;
		if (root.left != null) {
			if (root.left.left != null)
				incl_sum += auxNonAdjacentSum2(root.left.left, mem);
			if (root.left.right != null)
				incl_sum += auxNonAdjacentSum2(root.left.right, mem);
		}
		if (root.right != null) {
			if (root.right.left != null)
				incl_sum += auxNonAdjacentSum2(root.right.left, mem);
			if (root.right.right != null)
				incl_sum += auxNonAdjacentSum2(root.right.right, mem);
		}

		int excl_sum = 0;
		if (root.left != null)
			excl_sum += auxNonAdjacentSum2(root.left, mem);
		if (root.right != null)
			excl_sum += auxNonAdjacentSum2(root.right, mem);
		int res = Math.max(incl_sum, excl_sum);
		mem.put(root, res);
		return res;
	}

	// -------------------------------------------------------------------------
	static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}

	}

	// TC:Theta(n) SC:Theta(n)
	public static int maxNonAdjacentSum3(TreeNode root) {
		Pair res = auxNonAdjacentSum3(root);
		return res.first;
	}

	public static Pair auxNonAdjacentSum3(TreeNode root) {
		if (root == null)
			return new Pair(0, 0);
		if (root.left == null && root.right == null)
			return new Pair(Math.max(0, root.data), 0);
		Pair left = auxNonAdjacentSum3(root.left);
		Pair right = auxNonAdjacentSum3(root.right);

		int incl_sum = root.data + left.second + right.second;
		int excl_sum = left.first + right.first;
		return new Pair(Math.max(incl_sum, excl_sum), left.first + right.first);
	}
	//---------------------------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		// BinaryTreeUtils.display(root);
		// System.out.println(maxNonAdjacentSum1(root));
		System.out.println(maxNonAdjacentSum2(root));
		System.out.println(maxNonAdjacentSum3(root));
	}

}
