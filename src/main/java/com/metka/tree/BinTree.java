package com.metka.tree;

import java.util.Stack;

public class BinTree {

	private TreeNode root;
	private int size;

	// 初始化根节点
	public BinTree(Integer data) {
		root = new TreeNode(null, data, null);
	}

	// 插入左孩子
	public TreeNode insertAsLChirld(TreeNode node, Integer data) {
		TreeNode lNode = new TreeNode(null, data, null);
		node.lchirld = lNode;
		return lNode;
	}

	// 插入左孩子
	public TreeNode insertAsRChirld(TreeNode node, Integer data) {
		TreeNode rNode = new TreeNode(null, data, null);
		node.rchirld = rNode;
		return rNode;
	}

	public void showLVR() {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			visitLVR(node, stack);
			if (stack.isEmpty()) {
				break;
			}
			node = stack.pop();
			System.out.print(node.data + "-");
			node = node.rchirld;
		}
	}

	public void showVLR() {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			visitVLR(node, stack);
			if (stack.isEmpty()) {
				break;
			}
			node = stack.pop();
		}
	}

	public void postOrder() {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();	

		while (true) {

			this.aaa(node, stack);
			if(stack.isEmpty()) {
				break;
			}
			node=stack.peek();	

			if(node.flag) {
				System.out.println(stack.pop().data);
				node=null;
				continue;
			}


			node.flag=true;
			node=node.rchirld;

		}
	}

	public void aaa(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			node=node.lchirld;
		}
	}

	public void visitLVR(TreeNode node, Stack stack) {
		while (node != null) {
			stack.push(node);
			node = node.lchirld;
		}
	}

	public void visitVLR(TreeNode node, Stack stack) {
		while (node != null) {
			System.out.print(node.data + "-");
			stack.push(node.rchirld);
			node = node.lchirld;
		}
	}

	public void show(TreeNode temp) {
		if (temp != null) {
			System.out.print(temp.data + "-");
			show(temp.lchirld);
			show(temp.rchirld);
		}
	}

	class TreeNode {

		boolean  flag ;
		TreeNode parent;
		TreeNode lchirld;
		TreeNode rchirld;
		Integer data;

		public TreeNode() {
			// TODO Auto-generated constructor stub
		}

		public TreeNode(TreeNode lchirld, Integer data, TreeNode rchirld) {
			this.lchirld = lchirld;
			this.rchirld = rchirld;
			this.data = data;
		}
	}
	
	public TreeNode search(int x) {
		
		TreeNode temp=root;
		
		while(!temp.data.equals(x)) {
			temp=temp.data.compareTo(x)>0?temp.rchirld:temp.lchirld;
		}
		
		return temp;
	}

	public static void main(String[] args) {

		/*
		 * 0 1 2 3 4 5 6 7 8 9 10 11 0
		 * 
		 * 
		 */


		BinTree binTree = new BinTree(0);
		BinTree.TreeNode n1 = binTree.insertAsLChirld(binTree.root, 1);
		BinTree.TreeNode n2 = binTree.insertAsRChirld(binTree.root, 2);
		BinTree.TreeNode n3 = binTree.insertAsLChirld(n1, 3);
		BinTree.TreeNode n4 = binTree.insertAsRChirld(n1, 4);
		BinTree.TreeNode n5 = binTree.insertAsLChirld(n2, 5);
		BinTree.TreeNode n6 = binTree.insertAsRChirld(n2, 6);
		BinTree.TreeNode n7 = binTree.insertAsLChirld(n3, 7);
		BinTree.TreeNode n8 = binTree.insertAsRChirld(n3, 8);
		BinTree.TreeNode n9 = binTree.insertAsLChirld(n5, 9);
		BinTree.TreeNode n10 = binTree.insertAsLChirld(n6, 10);
		BinTree.TreeNode n11 = binTree.insertAsRChirld(n6, 11);
		System.out.println("-----------------");
		binTree.postOrder();

	}
}
