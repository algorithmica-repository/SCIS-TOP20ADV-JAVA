package com.alg.advtop20.tree.serde;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.alg.advtop20.tree.BinaryTreeUtils;
import com.alg.advtop20.tree.TreeNode;

public class Codec3 {

	private void auxPre(TreeNode root, StringBuilder res) {
		if (root == null)
			return;
		res.append(root.data + ",");
		auxPre(root.left, res);
		auxPre(root.right, res);
	}

	private void auxIn(TreeNode root, StringBuilder res) {
		if (root == null)
			return;
		auxIn(root.left, res);
		res.append(root.data + ",");
		auxIn(root.right, res);
	}

	// TC:Theta(n) SC:Theta(n)
	public String ser(TreeNode root) {
		StringBuilder res = new StringBuilder();
		auxIn(root, res);
		res.append("#");
		auxPre(root, res);
		return res.toString();
	}

	// ----------------------------------------------------
	private int findPosition(List<String> in, String data) {
		for (int p = 0; p < in.size(); ++p)
			if (in.get(p).equals(data))
				return p;
		return -1;
	}

	private TreeNode auxDeser(List<String> pre, List<String> in, int l, int r) {
		if (l > r)
			return null;
		String data = pre.remove(0);
		int p = findPosition(in, data);
		TreeNode root = new TreeNode(Integer.parseInt(data));
		root.left = auxDeser(pre, in, l, p - 1);
		root.right = auxDeser(pre, in, p + 1, r);
		return root;
	}

	// TC:Theta(n) SC:Theta(n)
	public TreeNode deser(String s) {
		String[] orders = s.split("#");
		List<String> in = new LinkedList<String>(Arrays.asList(orders[0].split(",")));
		System.out.println(in);
		List<String> pre = new LinkedList<String>(Arrays.asList(orders[1].split(",")));
		System.out.println(pre);
		return auxDeser(pre, in, 0, in.size() - 1);
	}

	// ------------------------------------------------------------
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.randomBinaryTree(n);
		BinaryTreeUtils.display(root);
		Codec3 c = new Codec3();
		String in = c.ser(root);
		System.out.println(in);
		root = c.deser(in);
		BinaryTreeUtils.display(root);
	}

}
