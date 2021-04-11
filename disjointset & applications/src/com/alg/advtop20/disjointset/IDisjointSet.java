package com.alg.advtop20.disjointset;

public interface IDisjointSet {

	int find(int x);

	void union(int x, int y);

	int size();

	void display();

}
