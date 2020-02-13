package a02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Client takes in an integer from command-line and reads in a sequence of strings from standard
 * input. Prints out the exact amount of strings given, randomly.
 * @author Carter Cluff & Robert Auer
 *
 */
public class Subset {
	public static void main(String[] args) {
		
		RandomizedQueue<String> in = new RandomizedQueue<String>();
		//int k = new int[0]; //TODO
		
		while(StdIn.readString() != null)
		{
			in.enqueue(StdIn.readLine());
		}
		
	/*	//TODO
		for(int i = 0; i<k.length; i++)
		{
			StdOut.println(in.dequeue());
		}
	*/	

	}

}
