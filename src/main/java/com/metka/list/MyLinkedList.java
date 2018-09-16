package com.metka.list;

import com.metka.list.node.LinkedNode;

public class MyLinkedList {

	private LinkedNode firstNode;// 头节点
	private LinkedNode lastNode;// 尾节点
	private int size;

	public MyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void show() {
		if (isEmpty()) {
			return;
		}
		LinkedNode temp = firstNode;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public Object insertLast(Object obj) {

		if (obj == null) {
			return obj;
		}
		// 如果为空 只直接设为FirstNode
		LinkedNode n = new LinkedNode();
		if (isEmpty()) {
			n.setData(obj);
			n.setNext(null);
			firstNode = n;
			lastNode = n;
			size++;
			return obj;
		}

		n.setData(obj);
		n.setNext(null);
		lastNode.setNext(n);
		lastNode = n;
		size++;
		return obj;
	}

	public Object insertFirst(Object obj) {
		if (obj == null) {
			return obj;
		}
		// 如果为空 只直接设为FirstNode
		LinkedNode n = new LinkedNode();
		if (isEmpty()) {
			n.setData(obj);
			n.setNext(null);
			firstNode = n;
			lastNode = n;
			size++;
			return obj;
		}

		n.setData(obj);
		n.setNext(firstNode);
		firstNode = n;
		size++;

		return obj;
	}

	public int find(Object obj) {

		if (obj == null) {
			return -1;
		}
		int index = 0;
		LinkedNode temp = firstNode;
		while (temp != null) {

			if (temp.getData().equals(obj)) {
				return index;
			}
			index++;
			temp = temp.getNext();
		}

		return -1;
	}

	public Object get(int index) {

		if (getNode(index) == null) {
			return null;
		}
		return getNode(index).getData();
	}

	public LinkedNode getNode(int index) {

		if (isEmpty()) {
			return null;
		}

		int x = 0;
		LinkedNode temp = firstNode;
		while (temp != null) {
			if (x == index) {
				return temp;
			}
			x++;
			temp = temp.getNext();
		}

		return null;
	}

	public Object getFirst() {
		return get(0);
	}

	public Object getLast() {
		return get(size - 1);
	}

	public Object remove(int index) {

		Object obj = null;

		if (index == 0) {
			obj = firstNode;
			LinkedNode temp = firstNode.getNext();
			firstNode.setNext(null);
			firstNode = temp;
			size--;
			if (isEmpty()) {
				lastNode = null;
			}
			return obj;
		}
		LinkedNode temp = getNode(index);
		obj = temp;
		LinkedNode prev = getNode(index - 1);
		prev.setNext(prev.getNext().getNext());
		temp = null;

		if (index == (size - 1)) {
			lastNode = prev;
		}
		size--;

		return obj;
	}

	public Object removeFirst() {

		return this.remove(0);
	}

	public Object removeLast() {

		return this.remove(size - 1);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();

		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		list.insertLast(6);
		list.insertLast(7);

		list.show();
		System.out.println("------------");
		System.out.println(list.removeLast());
		System.out.println(list.removeFirst());
		list.show();

	}

}
