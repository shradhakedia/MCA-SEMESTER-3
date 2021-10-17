package LabAssignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class InsertionSort {

    public static long[] comparisons = {0L};

    public static void main(String[] args) throws IOException {


        int[] sortedArray = new int[10];
        int[] reverseSortedArray = new int[10];
        int[] randomArray = new int[] {7, 2, 3, 5, 6, 3, 2, 5, 1, 4};
        int k = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i + 1;
            reverseSortedArray[k--] = i + 1;
        }

        insertionSort(sortedArray, comparisons);
        System.out.println(comparisons[0]);
        comparisons[0] = 0;
        insertionSort(reverseSortedArray, comparisons);
        System.out.println(comparisons[0]);
        comparisons[0] = 0;
        insertionSort(randomArray, comparisons);
        System.out.println(comparisons[0]);
    }

    public static int[] insertionSort(int[] arr, long[] comparisons) {
        int key, j;
        // for passes i.e n-1
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            //for each pass
            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
                comparisons[0]++;
                arr[j + 1] = arr[j];
            }
            if(key >= arr[j + 1]) {
                comparisons[0]++;
            }

            arr[j + 1] = key;
        }
        return arr;
    }
}
