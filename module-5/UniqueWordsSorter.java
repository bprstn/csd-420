// Brian Preston
// CSD-420 Module 5 Assignment - UniqueWordsSorter.java
// This program reads words from a text file and displays all non-duplicate words
// in ascending and descending order.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.ArrayList;

public class UniqueWordsSorter {
    public static void main(String[] args) {
        Set<String> wordSet = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                wordSet.add(word);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        // Ascending order (TreeSet already sorted)
        System.out.println("Ascending Order:");
        for (String word : wordSet) {
            System.out.println(word);
        }

        // Descending order
        System.out.println("\nDescending Order:");
        ArrayList<String> reversed = new ArrayList<>(wordSet);
        Collections.reverse(reversed);
        for (String word : reversed) {
            System.out.println(word);
        }
    }
}

