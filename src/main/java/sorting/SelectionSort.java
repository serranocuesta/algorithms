package sorting;

import java.util.Arrays;

class SelectionSort {

    void selectionSort(final int array[]) {
        final int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            // Find the index of the min element in the remaining array
            for (int i = step + 1; i < size; i++) {
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            // Place the min element in its place
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    public static void main(String args[]) {
        final int[] data = { 20, 12, 10, 15, 2 };
        final SelectionSort ss = new SelectionSort();
        ss.selectionSort(data);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
