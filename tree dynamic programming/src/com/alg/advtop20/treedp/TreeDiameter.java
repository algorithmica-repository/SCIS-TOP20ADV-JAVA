package com.alg.advtop20.treedp;

import java.util.HashMap;

public class TreeDiameter {

	private static int height1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return Math.max(height1(root.left), height1(root.right)) + 1;
	}

	private static void auxDiameter1(TreeNode root, MyInteger gmax) {
		if (root == null)
			return;
		int lh = height1(root.left);
		int rh = height1(root.right);
		gmax.setValue(Math.max(gmax.getValue(), lh + rh + 1));
		auxDiameter1(root.left, gmax);
		auxDiameter1(root.right, gmax);
	}

	// TC:Theta(n^2) SC:Theta(n)
	public static int diameter1(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		auxDiameter1(root, gmax);
		return gmax.getValue();
	}

	// ------------------------------------------------------------------
	private static int height2(TreeNode root, HashMap<TreeNode, Integer> mem) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (mem.get(root) != null)
			return mem.get(root);
		int res = Math.max(height2(root.left, mem), height2(root.right, mem)) + 1;
		mem.put(root, res);
		return res;
	}

	private static void auxDiameter2(TreeNode root, HashMap<TreeNode, Integer> mem, MyInteger gmax) {
		if (root == null)
			return;
		int lh = height2(root.left, mem);
		int rh = height2(root.right, mem);
		gmax.setValue(Math.max(gmax.getValue(), lh + rh + 1));
		auxDiameter2(root.left, mem, gmax);
		auxDiameter2(root.right, mem, gmax);
	}

	// TC:Theta(n) SC:Theta(n)
	public static int diameter2(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		HashMap<TreeNode, Integer> mem = new HashMap<TreeNode, Integer>();
		auxDiameter2(root, mem, gmax);
		return gmax.getValue();
	}

	// ------------------------------------------------------------------
	private static int height3(TreeNode root, MyInteger gmax) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lh = height3(root.left, gmax);
		int rh = height3(root.right, gmax);
		gmax.setValue(Math.max(gmax.getValue(), lh + rh + 1));
		return Math.max(lh, rh) + 1;
	}

	// TC:Theta(n) SC:Theta(n)
	public static int diameter3(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		height3(root, gmax);
		return gmax.getValue();
	}

	// -----------------------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		BinaryTreeUtils.display(root);
		System.out.println(diameter1(root));
		System.out.println(diameter2(root));
		System.out.println(diameter3(root));
	}

}
