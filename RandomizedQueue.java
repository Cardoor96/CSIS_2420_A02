package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] randomArray;
	private int n;
	private int first;
	@SuppressWarnings("unused")
	private int last;

	// construct an empty randomized queue
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
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
		if(n >= randomArray.length) {
			resize(n*2);
		}
		
	}

	// delete and return a random item
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int i = StdRandom.uniform(n);
		Item item = randomArray[i];
		n--;
		randomArray[i] = randomArray[n];
		randomArray[n] = null;
		if (randomArray.length / 4 >= n) {
			resize(randomArray.length / 2);
		}
		return item;
	}

	// return (but do not delete) a random item
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return randomArray[StdRandom.uniform(n)]; //TODO
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new RandomIterator();
	}

	

	private class RandomIterator implements Iterator<Item> {
		private int size = n;
		private final Item[] temp;

		private RandomIterator() {
			temp = (Item[]) new Object[size];
			for (int i = 0; i < size; i++) {
				temp[i] = randomArray[i];
			}
		}

		@Override
		public boolean hasNext() {
			return size > 0;
		}

		@Override

		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			int index = StdRandom.uniform(size);
			Item next = temp[index];
			if (index != size - 1)
				temp[index] = temp[size - 1];
			size--;
			temp[size] = null;
			return next;
		}

		@Override

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

	}

	
	/**
	 * Resizes array based on Sedgewick's ResizingArrayQueue.java.
	 * 
	 * @param size determines the size of the array
	 */

	private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = randomArray[(first + i) % randomArray.length];
        }
        randomArray = temp;
        first = 0;
        last  = n;
    }

	// unit testing
	public static void main(String[] args) {
		RandomizedQueue test = new RandomizedQueue();
		test.enqueue("bear");
		test.enqueue("tiger");
		test.enqueue("cow");
		test.enqueue("pig");
		test.enqueue("cat");
		StdOut.println(test.sample());
		StdOut.println(test.dequeue());
		StdOut.println(test.dequeue());
		StdOut.println(test.dequeue());
		StdOut.println(test.size());
		Iterator<String> it = test.iterator();
		System.out.println("test iterator:");
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

	}
	}

