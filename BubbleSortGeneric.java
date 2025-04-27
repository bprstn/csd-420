import java.util.Comparator;

public class BubbleSortGeneric {

    // Bubble sort using Comparable
    public static <T extends Comparable<T>> void bubbleSortComparable(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort using Comparator
    public static <T> void bubbleSortComparator(T[] array, Comparator<T> comp) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = { 5, 2, 8, 1, 3 };

        System.out.println("Before Comparable sort:");
        for (int n : numbers) System.out.print(n + " ");

        bubbleSortComparable(numbers);

        System.out.println("\nAfter Comparable sort:");
        for (int n : numbers) System.out.print(n + " ");

        String[] words = { "peach", "apple", "banana", "orange" };

        System.out.println("\n\nBefore Comparator sort:");
        for (String w : words) System.out.print(w + " ");

        bubbleSortComparator(words, (a, b) -> a.compareTo(b));

        System.out.println("\nAfter Comparator sort:");
        for (String w : words) System.out.print(w + " ");
    }
}

