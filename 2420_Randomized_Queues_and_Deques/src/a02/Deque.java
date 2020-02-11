package a02;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node<Item> head;
	private Node<Item> tail;
	private int n;

	private class Node<Item> {
		private Node<Item> next;
		private Node<Item> prev;
		private Item item;
	}

	// construct an empty deque
	public Deque() {
		head = null;
		tail = null;
		n = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return head == null;
	}

	// return the number of items on the deque
	public int size() {
		return n;
	}

	// insert the item at the front
	public void addFirst(Item item) {
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;

		if (size() == 0) {
			head = newNode;
			tail = head;
		} else {
			head.prev = newNode; // node before current head == new head
			newNode.next = head; // changes old head to next node
			head = newNode; // new node becomes front
		}
		n++;
	}

	// insert the item at the end
	public void addLast(Item item) {
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;

		if (size() == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode; // node after tail becomes new node
			newNode.prev = tail; // new node -1 = old tail node
			tail = newNode; // tail is now set to new node
		}
		n++;
	}

	// delete and return the item at the front
	public Item removeFirst() {
		Item oldHeadItem = head.item;
		//TODO

		return oldHeadItem;
	}

	// delete and return the item at the end
	public Item removeLast() {
		Node<Item> oldTail = tail;
		Item oldLastItem = tail.item;

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = oldTail.prev;
			tail.next = null;
		}

		return oldLastItem;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return null; // TODO
	}

	// unit testing
	public static void main(String[] args) {

	}

}
