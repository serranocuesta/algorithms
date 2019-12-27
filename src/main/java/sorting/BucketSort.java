package sorting;

import java.util.Arrays;

public class BucketSort {

    public static void bucketSort(int[] array, int size) {
        int max = Arrays.stream(array).max().getAsInt();
        // Creates as many buckets as the max element so every element will go into its own bucket
        int[] bucket = new int[max + 1];
        // Init the buckets
        for (int i = 0; i <= max; i++) {
            bucket[i] = 0;
        }
        // Mark every bucket that has an element based on its value as index
        for (int i = 0; i < size; i++) {
            bucket[array[i]]++;
        }
        // Process the buckets in order placing the item (index) in the original array when the bucket is marked
        for (int i = 0, j = 0; i <= max; i++) {
            while (bucket[i] > 0) {
                array[j++] = i;
                bucket[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] data = { 4, 3, 4, 5, 6, 9, 1, 5 };
        int size = data.length;
        BucketSort bs = new BucketSort();
        bs.bucketSort(data, size);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
    }
}
