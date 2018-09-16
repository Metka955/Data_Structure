package com.metka.list.node;

/**
 * 链表结构里的节点
 * @author Metka
 *
 */
public class LinkedNode {
	
	private Object data; //节点里面的数据
	private LinkedNode next;//下一个节点的引用
	
	public LinkedNode() {
		// TODO Auto-generated constructor stub
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public LinkedNode getNext() {
		return next;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	
}
