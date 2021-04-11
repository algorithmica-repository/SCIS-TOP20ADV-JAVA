package com.alg.advtop20.tree;

import java.util.Random;

public class BinaryTreeUtils {

	private static TreeNode add(TreeNode root, int x) {
		if (root == null)
			return new TreeNode(x);
		Random r = new Random();

		TreeNode root_copy = root;
		while (true) {
			int outcome = r.nextInt(2);
			if (outcome == 0) {
				if (root.left == null) {
					root.left = new TreeNode(x);
					break;
				}
				root = root.left;
			} else {
				if (root.right == null) {
					root.right = new TreeNode(x);
					break;
				}
				root = root.right;
			}
		}
		return root_copy;

	}

	public static TreeNode randomBinaryTree(int n) {
		TreeNode root = null;
		for (int i = 0; i < n; ++i)
			root = add(root, i + 1);
		return root;
	}

	public static TreeNode oneSidedBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = new TreeNode(r.nextInt(2 * n) + 1);
		TreeNode current = root;
		for (int i = 1; i < n; ++i) {
			current.right = new TreeNode(r.nextInt(2 * n) + 1);
			current = current.right;
		}
		return root;
	}

	private static void auxDisplay(TreeNode root, int nspaces, String annotation) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(" ");
		System.out.println(root.data + "(" + annotation + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	public static void display(TreeNode root) {
		auxDisplay(root, 0, "root");
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = randomBinaryTree(n);
		display(root);
	}

}
