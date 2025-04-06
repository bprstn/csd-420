// Brian Preston
// CSD-420 Module 3 Assignment - RemoveDuplicates.java
// This program generates a list of 50 random integers (1–20), 
// removes duplicates using a generic method, and displays both lists.

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill the list with 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display the original list
        System.out.println("Original list with duplicates:");
        System.out.println(originalList);

        // Get a new list with duplicates removed
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display the list without duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueList);
    }

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}

