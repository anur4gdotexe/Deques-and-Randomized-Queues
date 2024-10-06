# Deques and Randomized Queues

## Assignment project, Algorithms, Part I, Princeton University

Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.

## Dequeue
A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure.

## Corner cases
Throw the specified exception for the following corner cases:

Throw an IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
Unit testing.  Your main() method must call directly every public constructor and method to help verify that they work as prescribed (e.g., by printing results to standard output).

## Performance requirements
Your deque implementation must support each deque operation (including construction) in constant worst-case time. A deque containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.

## Randomized queue
A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure.

Iterator.  Each iterator must return the items in uniformly random order. The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.

## Corner cases
Throw the specified exception for the following corner cases:

Throw an IllegalArgumentException if the client calls enqueue() with a null argument.
Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
Unit testing.  Your main() method must call directly every public constructor and method to verify that they work as prescribed (e.g., by printing results to standard output).

## Performance requirements
Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time. That is, any intermixed sequence of m randomized queue operations (starting from an empty queue) must take at most cm steps in the worst case, for some constant c. A randomized queue containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time; and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.
