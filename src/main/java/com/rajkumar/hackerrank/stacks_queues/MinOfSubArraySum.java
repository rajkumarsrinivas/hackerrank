package com.rajkumar.hackerrank.stacks_queues;

import java.util.Scanner;
import java.util.Stack;

public class MinOfSubArraySum {

    static class Count {
        int value, count;
        Count(int a, int b) {
            value=a; count=b;
        }
    }

    private static int calc(int[] A) {
        int result = 0;
        int[] left = left(A);
        int[] right = right(A);
        for(int j:left) {
            System.out.print(j+" ");
        }
        System.out.println();
        for(int j:right) {
            System.out.print(j+" ");
        }
        for(int i=0; i<A.length; i++) {
            result += A[i]*left[i]*right[i];
        }
        return result;
    }

    private static int[] left(int[] A) {
        int[] result = new int[A.length];
        //int count =0;
        Stack<Count> stk1 = new Stack<>();

        for(int i=0; i<A.length; i++) {
            int count=1;
            while(!stk1.isEmpty() && stk1.peek().value >= A[i]) {
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
            while(!stk1.isEmpty() && stk1.peek().value >= A[i]) {
                count += stk1.pop().count;
            }
            stk1.push(new Count(A[i], count));
            result[i]=count;

        }
        return result;
    }
    private static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

//        for(int i : left(h)) {
//            System.out.print(i+" ");
//        }
//
//        System.out.println();
//
//        for(int i : right(h)) {
//            System.out.print(i+" ");
//        }

        System.out.println(calc(h));

        scanner.close();
    }
}
