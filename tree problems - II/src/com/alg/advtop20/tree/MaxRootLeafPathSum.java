package com.alg.advtop20.tree;

public class MaxRootLeafPathSum {

	private static void auxMaxSum1(TreeNode root, int csum, MyInteger gmax) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			gmax.setValue(Math.max(gmax.getValue(), csum + root.data));
			return;
		}
		auxMaxSum1(root.left, csum + root.data, gmax);
		auxMaxSum1(root.right, csum + root.data, gmax);
	}

	// TC:Theta(n) SC:Theta(n)
	public static int maxSum1(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		auxMaxSum1(root, 0, gmax);
		return gmax.getValue();
	}

	// TC:Theta(n) SC:Theta(n)
	public static int maxSum2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		int left = maxSum2(root.left);
		int right = maxSum2(root.right);
		return Math.max(left, right) + root.data;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		BinaryTreeUtils.display(root);
		System.out.println(maxSum1(root));
		System.out.println(maxSum2(root));
	}

}
