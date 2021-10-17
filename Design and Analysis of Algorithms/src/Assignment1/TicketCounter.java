package Assignment1;

//Consider a ticket line at reservation counter. Ticket distributor employee is crazy and he
//wants reverse the order of the first m persons from the queue, others will be stand at their
//place, For example, If m=4 and line has 9 persons according to their token ids
//[10,20,30,40,50,60,70,80,90]; the output should be [40,30,20,10,50,60,70,80,90]. Write a
//program for given condition.


import java.util.Arrays;
import java.util.Scanner;

public class TicketCounter {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the list separated by space : ");
        String[] arr = sc.nextLine().split(" ");
        System.out.println("Enter m :");
        int m = sc.nextInt();

        if(m > arr.length) throw new Exception("Invalid input, m should be less than the size of the list");

        for(int i = 0, j = m - 1; i <= j; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
