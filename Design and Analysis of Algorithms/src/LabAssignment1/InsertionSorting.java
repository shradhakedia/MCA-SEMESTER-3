package LabAssignment1;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSorting {

// Time Complexity: worst case -> O(n^2), best case -> O(n)
// Adaptive Algorithm: if array is already sorted and the algo takes less time than usual then it is an adaptive algorithm.Yes, This Algo is Adaptive.
// Stable Algorithm: if in array after sorting the order of same elements remain same.
// i.e After sorting, the first occurred same elt is before the elt occurred later whose value is same as first.Yes, This Algo is Stable.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the array separated by space : ");
        String[] input = sc.nextLine().split(" ");
        int[] list = new int[input.length];
        for (int i = 0; i < input.length; i++)
            list[i] = Integer.parseInt(input[i]);
        //System.out.println(Arrays.toString(insertionSort(list)));
        insertionSortR(list, list.length);
        System.out.println(Arrays.toString(list));
    }

    public static int[] insertionSort(int[] arr) {
        int key, j;
        // for passes i.e n-1
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            //for each pass
            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void insertionSortR(int[] arr, int n) {
        if(n <= 1) return;
        insertionSortR(arr, n - 1);
        int key = arr[n - 1];
        int j = n - 2;
        while(j >= 0 && key < arr[j]) {
            arr[j+ 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
