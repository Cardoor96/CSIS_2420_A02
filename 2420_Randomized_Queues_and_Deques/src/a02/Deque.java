package a02;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node<Item> head;
	private Node<Item> tail;
	private int n;
	
	private class Node<Item>{
		private Node<Item> next;
		private Node<Item> prev;
		private Item item;
	}
	
	public Deque() // construct an empty deque
	{
		head = null;
		tail = null;
		n = 0;
	}

	public boolean isEmpty() // is the deque empty?
	{
		return head == null;
	}

	public int size() // return the number of items on the deque
	{
		return n;
	}

	public void addFirst(Item item) // insert the item at the front
	{
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;
		
		if(size() == 0)
		{
			head = newNode;
			tail = head;
		}else
		{
			head.prev = newNode; //node before current head == new head
			newNode.next = head; //changes old head to next node
			head = newNode; // new node becomes front
		}
		n++;
	}

	public void addLast(Item item) // insert the item at the end
	{
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;
		
		if(size() == 0)
		{
			head = newNode;
			tail = newNode;
		}else
		{
			tail.next = newNode; // node after tail becomes new node
			newNode.prev = tail; // new node -1 = old tail node
			tail = newNode; // tail is now set to new node
		}
		n++;
	}

	public Item removeFirst() // delete and return the item at the front
	{
		return null;
	}

	public Item removeLast() // delete and return the item at the end
	{
		Node<Item> oldTail = tail;
		Item oldLastItem = tail.item;
		
		if(head == tail)
		{
			head = null;
			tail = null;
		}else
		{
			tail = oldTail.prev;
			tail.next = null;
		}
		
		return oldLastItem;
	}

	public Iterator<Item> iterator() // return an iterator over items in order from front to end
	{
		return null;
	}

	public static void main(String[] args) // unit testing
	{
		
	}
	
	}
