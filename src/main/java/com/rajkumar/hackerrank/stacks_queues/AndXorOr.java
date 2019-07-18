package com.rajkumar.hackerrank.stacks_queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class AndXorOr {

    /*
     * Complete the andXorOr function below.
     */
    static int andXorOr(int[] a) {
        /*
         * Write your code here.
         */
        int result;
        Stack<Integer> stack = new Stack<>();
        result = a[0] ^ a[1];

        for(int i=0; i< a.length; i++) {
            while(!stack.isEmpty()) {
                int top = stack.peek();
                int temp = a[i] ^ top;
                if(temp > result) {
                    result = temp;
                }
                if(a[i] < top) {
                    stack.pop();
                }
            }
            stack.push(a[i]);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        String[] aItems = scanner.nextLine().split(" ");

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int result = andXorOr(a);

        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}
