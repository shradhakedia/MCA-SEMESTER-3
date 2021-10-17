package LabAssignment3;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static long[] comparisons = {0L};

    public static void main(String[] args) {

        int[] sortedArray = new int[10];
        int[] reverseSortedArray = new int[10];
        int[] randomArray = new int[] {7, 2, 3, 5, 6, 3, 2, 5, 1, 4};
        int k = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i + 1;
            reverseSortedArray[k--] = i + 1;
        }

        mergeSort(sortedArray, 0, sortedArray.length - 1, comparisons);
        System.out.println(comparisons[0]);

        comparisons[0] = 0;
        mergeSort(reverseSortedArray, 0, reverseSortedArray.length - 1, comparisons);
        System.out.println(comparisons[0]);

        comparisons[0] = 0;
        mergeSort(randomArray, 0, randomArray.length - 1, comparisons);
        System.out.println(comparisons[0]);
    }

    static int[] mergeSort(int[] array, int low, int high, long[] comparisons){
        if(low == high) {
            int[] base = new int[1];
            base[0] = array[low];
            return base;
        }
        int mid =(low + high) /  2;

        int[] fh = mergeSort(array, low, mid, comparisons);
        int[] sh = mergeSort(array, mid + 1, high, comparisons);

        return mergeTwoSortedArrays(fh, sh, comparisons);
    }

    static int[] mergeTwoSortedArrays(int[] array1, int[] array2, long[] comparisons) {
        int i = 0, j = 0 , k = 0;
        int[] merged = new int[array1.length + array2.length];

        while(i < array1.length && j < array2.length) {
            comparisons[0]++;
            if(array1[i] <= array2[j]) {
                merged[k] = array1[i];
                i++;
            }
            else{
                merged[k] = array2[j];
                j++;
            }
            k++;
        }

        if(i == array1.length) {
            while(j < array2.length){
                merged[k]=array2[j];
                j++;
                k++;
            }
        }
        if(j == array2.length) {
            while (i < array1.length) {
                merged[k] = array1[i];
                i++;
                k++;
            }
        }
        return merged;
    }
}
