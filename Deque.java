package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

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
	 * Constructs an empty queue.
	 */
	public Deque() {
		head = null;
		tail = null;
		n = 0;
	}

	/**
	 * Checks to see if the queue is empty.
	 * @return True if queue is empty and otherwise returns false.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Returns the current size of the queue.
	 * @return the current size of the queue
	 */
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
	 public Iterator<Item> iterator(){
		   return new dequeIterator();
	   }
	   
	   private class dequeIterator implements Iterator<Item> {
	   private Node current = head;

	@Override
	public boolean hasNext() {
		return current !=null;
	}

	@Override
	public Item next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
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
			Node current = head;
			
			while(current != null) {
				sb.append(current.item).append(" ");
				current = current.next;
			}
			
			return sb.toString();
		}
	   
	   
	  
	
	
	public static void main(String[] args) {
		
		Deque<String> test = new Deque();
		
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
		Iterator it = test.iterator();
		while(it.hasNext()){
			StdOut.println(it.next());
		}
	}

}