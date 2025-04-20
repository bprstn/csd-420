import java.util.Arrays;
import java.util.Comparator;

/**
 * Brian Preston
 * CSD-420 - Module 6
 * Bubble sort using Comparable and Comparator
 */
public class BubbleSortGeneric {

    // Sort using Comparable
    public static <T extends Comparable<T>> void bubbleSortComparable(T[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Sort using Comparator
    public static <T> void bubbleSortComparator(T[] array, Comparator<? super T> comp) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        // Comparable Test (Integers)
        Integer[] numbers = {9, 2, 5, 3, 7};
        System.out.println("Before (Comparable): " + Arrays.toString(numbers));
        bubbleSortComparable(numbers);
        System.out.println("After  (Comparable): " + Arrays.toString(numbers));

        // Comparator Test (Strings)
        String[] words = {"banana", "apple", "grape", "cherry"};
        System.out.println("\nBefore (Comparator): " + Arrays.toString(words));
        bubbleSortComparator(words, Comparator.naturalOrder());
        System.out.println("After  (Comparator): " + Arrays.toString(words));
    }
}
