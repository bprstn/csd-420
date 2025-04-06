// Brian Preston
// CSD-420 Module 4 Assignment - LinkedListTraversal.java
// This program compares the traversal time of a LinkedList using an iterator
// vs using the get(index) method, for 50,000 and 500,000 integers.

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversal {
    
    public static void main(String[] args) {
        testTraversal(50000);
        testTraversal(500000);
    }

    public static void testTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\n--- Traversing LinkedList with size: " + size + " ---");

        // Traversal using Iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        System.out.println("Iterator traversal time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Traversal using get(index)
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("get(index) traversal time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Commented summary of results
        System.out.println("NOTE: Iterator is significantly faster for large LinkedLists,");
        System.out.println("because get(index) requires traversing from the head each time.");
    }
}

