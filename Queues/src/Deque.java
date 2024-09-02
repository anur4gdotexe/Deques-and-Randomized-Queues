import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private Item[] deq;
	private int front, back;
	
	// construct an empty deque
    public Deque() {
    	deq = (Item[]) new Object[1];
    	front = 0;
    	back = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return (front == 0 || back == deq.length - 1 || back == front-1);
    }

    // return the number of items on the deque
    public int size() {
    	if (isEmpty()) {
    		return 0;
    	}
    	return front - back - 1;
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Can't add null to the queue");
    	}
    	if (front == deq.length) {
    		resizeFr(2*deq.length);
    	}
    	if (front == back) {
    		back--;
    	}
    	deq[front++] = item;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Can't add null to the queue");
    	}
    	if (back == -1) {
    		resizeRe(2*deq.length);
    	}
    	if (front == back) {
    		front++;
    	}
    	deq[back--] = item;
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	if (isEmpty()) {
    		throw new java.util.NoSuchElementException("No element found");
    	}
    	if (front == deq.length/4) {
    		resizeFr(deq.length/2);
    	}
    	Item item = deq[--front];
    	deq[front] = null;
    	return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if (isEmpty()) {
    		throw new java.util.NoSuchElementException("No element found");
    	}
    	Item item = deq[++back];
    	deq[back] = null;
    	return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
    	return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Item> {
    	private int i = front;
    	
    	public boolean hasNext() {
    		return (i <= deq.length && i > back+1 && !isEmpty());
    	}
    	public Item next() {
    		if (isEmpty()) {
        		throw new java.util.NoSuchElementException("No element found");
        	}
    		return deq[--i];
    	}
    	public void remove() {
    		throw new UnsupportedOperationException("No such method found");
    	}
    }	
    
    private void resizeFr(int capacity) {
    	Item[] copy = (Item[]) new Object[capacity];    	
    	for (int i = 0; i < front; i++) {
    		copy[i] = deq[i];
    	}    	
    	deq = copy;
    }
    
    private void resizeRe(int capacity) {
    	Item[] copy = (Item[]) new Object[capacity];
    	for (int i = 0; i < front; i++) {
    		copy[i + deq.length] = deq[i];
    	}   
    	back = back + deq.length;
    	front = front + deq.length;
    	deq = copy;
    }

    // unit testing (required)
    public static void main(String[] args) {
    	Deque<Integer> deq = new Deque<Integer>();
    	
    	StdOut.println(deq.isEmpty());
    	StdOut.println("Size: " + deq.size());
    	deq.addFirst(1);    
    	deq.addFirst(2);
    	deq.addLast(0);
    	deq.addLast(-1);
    	StdOut.println(deq.isEmpty());
    	StdOut.println("Size: " + deq.size());
    	
    	
    	Iterator<Integer> it = deq.iterator();
    	while (it.hasNext()) {
    		StdOut.println(it.next());
    	}
    	
    	StdOut.println(deq.removeFirst());
    	StdOut.println(deq.removeLast());
    }
}
