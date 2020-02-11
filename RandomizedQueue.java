package a02;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] randomArray;
	private int n;
	// construct an empty randomized queue
	public RandomizedQueue() {
		//TODO
		randomArray = (Item[]) new Object[2];
		n = 0;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return  n == 0;
	}

	// return the number of items on the queue
	public int size() {
		return n; 
	}

	// add the item
	public void enqueue(Item item) {
		//TODO
		if (item == null) {
			throw new NullPointerException();
		}
		randomArray[n] = item;
		n++;
	}

	// delete and return a random item
	public Item dequeue() {
		return null; //TODO
	}

	// return (but do not delete) a random item
	public Item sample() {
		return null; //TODO
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return null; //TODO
	}

	// unit testing
	public static void main(String[] args) {
	}
}
