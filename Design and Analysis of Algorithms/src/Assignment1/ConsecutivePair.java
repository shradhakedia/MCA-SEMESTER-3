package Assignment1;

import java.util.Scanner;
import java.util.Stack;

//Question : Given a stack of integers, how do you check whether each successive pair of numbers in
//the stack is consecutive or not. The pair can be increasing or decreasing, and if stack has
//an odd number of elements, the element at the top is left out of a pair. For Example, If the
//stack of elements are [4,5,-2,-3,11,10,5,6,20], then the output should be true because each
//of the pairs (4,5), (-2,-3), (11,10) and (5,6) consists of consecutive numbers. (Explain the
//process).

//input : [4,5,-2,-3,11,10,5,6,20].
//output : Yes, all are Consecutive Pairs.

public class ConsecutivePair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter the no. of elements you want to push: ");
        int size = sc.nextInt();
        for(int  i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            int element = sc.nextInt();
            stack.push(element);
        }
        boolean isValid = checkConsecutive(stack);
        if(isValid) System.out.println("Yes, all are Consecutive Pairs.");
        else System.out.println("No, all are not Consecutive Pairs.");

    }

    public static boolean checkConsecutive(Stack<Integer> stack) {
        if((stack.size() & 1) == 1) stack.pop();
        while(!stack.isEmpty()) {
            int a = stack.pop();
            int b = stack.pop();
            if((a - b) != 1 && (a - b) != -1) {
                return false;
            }
        }
        return true;
    }
}

