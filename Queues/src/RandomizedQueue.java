import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] ranQueue;
	private int n;
	
    // construct an empty randomized queue
    public RandomizedQueue() {
    	ranQueue = (Item[]) new Object[1];
    	n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return (n == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
    	return n;
    }

    // add the item
    public void enqueue(Item item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Can't add null to the queue");
    	}
    	if (n == ranQueue.length) {
    		resize(2*ranQueue.length);
    	}
    	ranQueue[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
    	if (isEmpty()) {
    		throw new java.util.NoSuchElementException("No element found");
    	}
    	if (n == ranQueue.length/4) {
    		resize(ranQueue.length/2);
    	}
    	int pos = StdRandom.uniformInt(0, n); 
    	Item item = ranQueue[pos];
    	
    	change(pos);
    	return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if (isEmpty()) {
    		throw new java.util.NoSuchElementException("No element found");
    	}
    	return ranQueue[StdRandom.uniformInt(0, n)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
    	return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Item> {
    	private int i = 0;
    	
    	public boolean hasNext() { return (i < n); }
    	public Item next() {
    		if (isEmpty()) {
        		throw new java.util.NoSuchElementException("No element found");
        	}
    		return ranQueue[i++];
    	}
    	public void remove() {
    		throw new UnsupportedOperationException("No such method found");
    	}
    }
    
    private void resize(int capacity) {
    	Item[] copy = (Item[]) new Object[capacity];    	
    	for (int i = 0; i < n; i++) {
    		copy[i] = ranQueue[i];
    	}    	
    	ranQueue = copy;
    }
    
    private void change(int pos) {
    	for (int i = pos; i < n-1; i++) {
    		ranQueue[i] = ranQueue[i+1];
    	}
    	ranQueue[--n] = null;
    }
    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue<Integer> ran = new RandomizedQueue<Integer>();
    	StdOut.println(ran.isEmpty());
    	StdOut.println("Size: " + ran.size());
    	ran.enqueue(1);    
    	ran.enqueue(2);
    	ran.enqueue(0);
    	
    	StdOut.println(ran.isEmpty());
    	StdOut.println("Size: " + ran.size());
    	
    	Iterator<Integer> it = ran.iterator();
    	while (it.hasNext()) {
    		StdOut.println(it.next());
    	}
    	
    	StdOut.println(ran.dequeue());
    	StdOut.println(ran.dequeue());
    }
}