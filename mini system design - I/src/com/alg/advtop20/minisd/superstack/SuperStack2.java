package com.alg.advtop20.minisd.superstack;

import java.util.Stack;

public class SuperStack2 {
	private Stack<Integer> data_stack;
	private int max;

	public SuperStack2() {
		data_stack = new Stack<Integer>();
		max = Integer.MAX_VALUE;
	}

	// TC:O(1)
	public void push(int x) {
		if (x > max) {
			data_stack.push(2 * x - max);
			max = x;
		} else {
			if (data_stack.empty())
				max = x;
			data_stack.push(x);
		}
	}

	// TC:O(1)
	public int pop() {
		if (data_stack.empty())
			return Integer.MIN_VALUE;
		int res = data_stack.pop();
		int tmp;
		if (res > max) {
			tmp = max;
			max = 2 * max - res;
		} else {
			tmp = res;
		}
		return tmp;
	}

	// TC:O(1)
	public int max() {
		if (data_stack.empty())
			return Integer.MIN_VALUE;
		return max;
	}

	public void display() {
		System.out.println(data_stack);
	}

	public static void main(String[] args) {
		SuperStack2 ss = new SuperStack2();
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
