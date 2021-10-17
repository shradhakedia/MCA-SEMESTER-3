package Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackOperation {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter the numbers separated by space : ");
        String[] input = br.readLine().split(" ");
        if(isValid(stack, input)){
            System.out.println(sb.toString());
        }
        else {
            System.out.println("Invalid String!");
        }

    }

    public static boolean isValid(Stack<Integer> stack, String[] input) {
        int[] list = {10, 20, 30, 40, 50, 60};
        int k = 0;
        for(int i = 0; i < input.length;) {
            int inp = Integer.parseInt(input[i]);
            if((!stack.isEmpty()) && stack.peek() > inp) {
                return false;
            }
            while(inp >= list[k]) {
                stack.push(list[k++]);
                k %= list.length;
                sb.append("A");
                if (inp == list[list.length - 1]) break;
            }
            while ( i < input.length && (!stack.isEmpty()) && stack.peek() == Integer.parseInt(input[i]) ) {
                stack.pop();
                i++;
                sb.append("B");
            }
        }
        return true;
    }
}
