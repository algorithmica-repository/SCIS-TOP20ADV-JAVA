package com.alg.advtop20.tree.serde;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.alg.advtop20.tree.BinaryTreeUtils;
import com.alg.advtop20.tree.TreeNode;

public class Codec1 {

	private void auxSer(TreeNode root, StringBuilder res) {
		if (root == null) {
			res.append("#,");
			return;
		}
		// work at each node
		res.append(root.data + ",");
		auxSer(root.left, res);
		auxSer(root.right, res);
	}

	// TC:Theta(n) SC:Theta(n)
	public String ser(TreeNode root) {
		StringBuilder res = new StringBuilder();
		auxSer(root, res);
		return res.toString();
	}

	// ----------------------------------------------------
	private TreeNode auxDeser(List<String> in) {
		// if(in.size() == 0) return null;(not required)
		String e = in.remove(0);
		if (e.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(e));
		root.left = auxDeser(in);
		root.right = auxDeser(in);
		return root;
	}

	// TC:Theta(n) SC:Theta(n)
	public TreeNode deser(String in) {
		List<String> data = new LinkedList<String>(Arrays.asList(in.split(",")));
		// System.out.println(data);
		return auxDeser(data);
	}

	// ------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		BinaryTreeUtils.display(root);
		Codec1 c = new Codec1();
		String in = c.ser(root);
		System.out.println(in);
		root = c.deser(in);
		BinaryTreeUtils.display(root);
	}

}
