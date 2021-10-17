package LabAssignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSecondMax {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the elements of the list separated by space.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        int[] _list = new int[list.length];
        for (int i =0; i < list.length; i++) {
            _list[i] = Integer.parseInt(list[i]);
        }

        func(_list);
    }

    public static void func(int[] list) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i : list) {
            if(max < i) {
                secondMax = max;
                max = i;
            }
            else if(secondMax < i) {
                secondMax = i;
            }
        }

        System.out.println("Largest element of the list :" + max);
        System.out.println("Second Largest element of the list :" + secondMax);
    }
}
