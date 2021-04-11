package com.alg.advtop20.tree.serde;

import java.util.LinkedList;
import java.util.Queue;

import com.alg.advtop20.tree.BinaryTreeUtils;
import com.alg.advtop20.tree.TreeNode;

public class Codec2 {

	// TC:Theta(n) SC:Theta(n)
	public String ser(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		StringBuilder res = new StringBuilder();

		while (!q.isEmpty()) {
			root = q.remove();
			if (root == null) {
				res.append("#,");
			} else {
				res.append(root.data + ",");
				q.add(root.left);
				q.add(root.right);
			}
		}
		return res.toString();
	}

	// ----------------------------------------------------
	// TC:Theta(n) SC:Theta(n)
	public TreeNode deser(String in) {
		String[] data = in.split(",");
		//System.out.println(Arrays.toString(data));
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		int i = 0;
		TreeNode root = new TreeNode(Integer.parseInt(data[i++]));
		q.add(root);

		while (!q.isEmpty()) {
			String left_data = data[i++];
			String right_data = data[i++];
			TreeNode tmp = q.remove();
			if (left_data.equals("#"))
				tmp.left = null;
			else {
				tmp.left = new TreeNode(Integer.parseInt(left_data));
				q.add(tmp.left);
			}

			if (right_data.equals("#"))
				tmp.right = null;
			else {
				tmp.right = new TreeNode(Integer.parseInt(right_data));
				q.add(tmp.right);
			}
		}
		return root;
	}

	// ------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		BinaryTreeUtils.display(root);
		Codec2 c = new Codec2();
		String in = c.ser(root);
		System.out.println(in);
		root = c.deser(in);
		BinaryTreeUtils.display(root);
	}

}
