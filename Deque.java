package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * Data type that holds generic Items. Implements Iterable interface, that allows insertion and removal
 * of items from the deque.
 * 
 * @author Carter Cluff & Robert Auer
 *
 * @param <Item> is a generic type.
 */
public class Deque<Item> implements Iterable<Item> {
	private Node<Item> head;
	private Node<Item> tail;
	private int n;

	private class Node<Item> {
		private Node<Item> next;
		private Node<Item> prev;
		private Item item;
	}

	/**
	 * Constructs and empty Deque.
	 */
	public Deque() {
		head = null;
		tail = null;
		n = 0;
	}

	/**
	 * Checks if the deque is empty.
	 * @return true if empty, returns false if deque contains an item
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Checks the size of the deque.
	 * @return integer value of deque size
	 */
	public int size() {
		return n;
	}

	/**
	 * Inserts an item at the front of the deque.
	 * @param item
	 */
	public void addFirst(Item item) {
		if(item == null)
			throw new java.lang.NullPointerException("New Item cannot be null.");
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

	/**
	 * Inserts an item at the end of the deque.
	 * @param item
	 */
	public void addLast(Item item) {
		if(item == null)
			throw new java.lang.NullPointerException("New Item cannot be null.");
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

	/**
	 * Deletes the item at the front of the deque.
	 * @return returns the item that was at the front of the deque.
	 */
	public Item removeFirst() {
		if(isEmpty())
			throw new java.util.NoSuchElementException("Cannot remove item from empty deque.");
		Item oldHeadItem = head.item;
		head = head.next;
		if(head == tail)
		{
			head = null;
			tail = null;
		}
		n--;
		return oldHeadItem;
	}

	/**
	 * Deletes the last item in the deque.
	 * @return returns the item that was at the end of the deque.
	 */
	public Item removeLast() {
		if(isEmpty())
			throw new java.util.NoSuchElementException("Cannot remove item from empty deque.");
		Node<Item> oldTail = tail;
		Item oldLastItem = tail.item;

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = oldTail.prev;
			tail.next = null;
		}
		n--;
		return oldLastItem;
	}

	/**
	 * Creates an iterator object for Deque class.
	 */
	 public Iterator<Item> iterator(){
		   return new dequeIterator();
	   }
	   
	   private class dequeIterator implements Iterator<Item> {
	   private Node<Item> current = head;

	@Override
	public boolean hasNext() {
		return current !=null;
	}

	@Override
	public Item next() {
		if (!hasNext()) {
			throw new NoSuchElementException("No items to return.");
		}
		
		Item item = (Item) current.item;
		current = current.next;
		return item;
	}
	@Override
	public void remove() { 
		throw new UnsupportedOperationException(); 
		}
	   
	   }
	   
	   @Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node<Item> current = head;
			
			while(current != null) {
				sb.append(current.item).append(" ");
				current = current.next;
			}
			
			return sb.toString();
		}
	   
	/**
	 * Test client for deque class.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Deque<String> test = new Deque<String>();
		
		test.addFirst("cat");
		test.addFirst("dog");
		test.addFirst("rat");
	    test.addLast("bat ");
		
	    
	    StdOut.println("Size: " + test.size());
	    StdOut.println("Is empty: " + test.isEmpty());
	    StdOut.println(test);
		
		test.removeFirst();
		test.removeLast();
		StdOut.println();
		StdOut.println("Size: " + test.size());
		StdOut.println("Is empty: " + test.isEmpty());
		StdOut.println("Iterator Test");
		Iterator<String> it = test.iterator();
		while(it.hasNext()){
			StdOut.println(it.next());
		}
		
		test.addFirst("cow");
		test.addLast("mouse");
		StdOut.println(test);
		
	}

}
