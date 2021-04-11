package com.alg.advtop20.minisd.superstack;

import java.util.Stack;

public class SuperStack1 {
	private Stack<Integer> data_stack;
	private Stack<Integer> max_stack;

	public SuperStack1() {
		data_stack = new Stack<Integer>();
		max_stack = new Stack<Integer>();
	}

	// TC:O(1)
	public void push(int x) {
		data_stack.push(x);
		if (max_stack.empty() || x > max_stack.peek())
			max_stack.push(x);
	}

	// TC:O(1)
	public int pop() {
		if (data_stack.empty())
			return Integer.MIN_VALUE;
		int res = data_stack.pop();
		if (max_stack.peek() == res)
			max_stack.pop();
		return res;
	}

	// TC:O(1)
	public int max() {
		if (data_stack.empty())
			return Integer.MIN_VALUE;
		return max_stack.peek();
	}

	public void display() {
		System.out.println(data_stack);
	}

	public static void main(String[] args) {
		SuperStack1 ss = new SuperStack1();
		for (int i = 1; i <= 10; ++i) {
			ss.push(i);
			ss.display();
		}
		System.out.println(ss.max());
		for (int i = 1; i <= 5; ++i) {
			System.out.println(ss.pop());
			ss.display();
		}
		System.out.println(ss.max());

	}

}
