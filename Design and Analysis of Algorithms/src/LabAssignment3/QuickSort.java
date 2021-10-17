package LabAssignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


// Time Complexity: best case -> O(n.log(n)), worst case -> O(n^2)
// Adaptive Algorithm: if array is already sorted and the algo takes less time than usual then it is an adaptive algorithm.Yes, This Algo is Adaptive.
// Stable Algorithm: if in array after sorting the order of same elements remain same.
// i.e After sorting, the first occurred same elt is before the elt occurred later whose value is same as first.Yes, This Algo is Stable.


public class QuickSort {

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

        quickSort(sortedArray, 0, 9, comparisons);
        System.out.println(comparisons[0]);

        comparisons[0] = 0;
        quickSort(reverseSortedArray,0, 9, comparisons);
        System.out.println(comparisons[0]);

        comparisons[0] = 0;
        quickSort(randomArray, 0, 9, comparisons);
        System.out.println(comparisons[0]);
    }

    public static int partition(int[] arr, int p, int r, long[] comparisons) {
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(arr[j] <= x){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            comparisons[0]++;
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high, long[] comparisons) {

        if(low < high) {
            int q = partition(arr, low, high, comparisons);
            quickSort(arr, low, q - 1, comparisons);
            quickSort(arr, q + 1, high, comparisons);
        }
    }
}
