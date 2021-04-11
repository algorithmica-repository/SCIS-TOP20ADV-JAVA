package com.alg.advtop20.tree.nonrecursion;

import java.util.Stack;

import com.alg.advtop20.tree.BinaryTreeUtils;
import com.alg.advtop20.tree.TreeNode;

public class PreOrderTranslation {

	// TC:Theta(n) SC:Theta(n)
	public static void preOrderR(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrderR(root.left);
		preOrderR(root.right);
	}

	// TC:Theta(n) SC:Theta(n)
	public static void preOrderNR(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				s.push(root);
				System.out.println(root.data);
				root = root.left;
			}
			if (s.empty())
				break;
			root = s.pop().right;
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.oneSidedBinaryTree(n);
		// BinaryTreeUtils.display(root);
		preOrderR(root);
		preOrderNR(root);
	}

}
