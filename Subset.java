package a02;

public class Subset {

	public static void main(String[] args) {
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
		randomizedQueue.enqueue("A");
		randomizedQueue.enqueue("B");
		randomizedQueue.enqueue("C");
		randomizedQueue.enqueue("D");
		int k = randomizedQueue.size();

		for (int i = 0; i < k; i++) {
			System.out.println(randomizedQueue.dequeue());
		}
	}
}
