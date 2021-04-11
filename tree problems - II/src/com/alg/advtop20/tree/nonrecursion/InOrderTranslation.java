package com.alg.advtop20.tree.nonrecursion;

import java.util.Stack;

import com.alg.advtop20.tree.BinaryTreeUtils;
import com.alg.advtop20.tree.TreeNode;

public class InOrderTranslation {

	// TC:Theta(n) SC:Theta(n)
	public static void inOrderR(TreeNode root) {
		if (root == null)
			return;
		inOrderR(root.left);
		System.out.println(root.data);
		inOrderR(root.right);
	}

	// TC:Theta(n) SC:Theta(n)
	public static void inOrderNR(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (s.empty())
				break;
			root = s.pop();
			System.out.println(root.data);
			root = root.right;
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.oneSidedBinaryTree(n);
		// BinaryTreeUtils.display(root);
		inOrderR(root);
		inOrderNR(root);
	}

}
