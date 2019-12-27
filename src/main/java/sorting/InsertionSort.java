package sorting;

import java.util.Arrays;

public class InsertionSort {

    void insertionSort(final int array[]) {
        for (int i = 1; i < array.length; i++) {
            final int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) { // Moves the key back until it finds the right place
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        final int[] data = { 9, 5, 1, 4, 3 };
        final InsertionSort is = new InsertionSort();
        is.insertionSort(data);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
