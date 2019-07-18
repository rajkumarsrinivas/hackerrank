package com.rajkumar.hackerrank.stacks_queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/largest-rectangle/problem?h_r=internal-search
public class LargestRectangle {
    // Complete the largestRectangle function below.

    static class Count {
        int value, count;
        Count(int a, int b) {
            value=a; count=b;
        }
    }


    private static int calc(int[] A) {
        int max = 0;
        int[] left = left(A);
        int[] right = right(A);

        max = A[0]*(left[0]+right[0]-1);
        for(int i=1; i<A.length; i++) {
            int temp = A[i]*(left[i]+right[i]-1);
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }

    private static int[] left(int[] A) {
        int[] result = new int[A.length];
        //int count =0;
        Stack<Count> stk1 = new Stack<>();

        for(int i=0; i<A.length; i++) {
            int count=1;
            while(!stk1.isEmpty() && stk1.peek().value > A[i]) {
                count += stk1.pop().count;
            }
            stk1.push(new Count(A[i], count));
            result[i]=count;

        }
        return result;
    }

    private static int[] right(int[] A) {
        int[] result = new int[A.length];
        //int count =0;
        Stack<Count> stk1 = new Stack<>();

        for(int i=A.length-1; i >= 0; i--) {
            int count=1;
            while(!stk1.isEmpty() && stk1.peek().value > A[i]) {
                count += stk1.pop().count;
            }
            stk1.push(new Count(A[i], count));
            result[i]=count;
        }
        return result;
    }

    static void check(int[] A) {

        for(int i=0; i< A.length;i++) {
            if(85175%A[i] == 0) {
                System.out.println(A[i]);
            }
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = calc(h);
        // check(h);

        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
