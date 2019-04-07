package com.rajkumar.hackerrank.stacks_queues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinMaxRiddle {


        static class Stack {
            long first = -1;
            long second = -1;
            long result = 0;
            long max = 0;

            void add(long value) {
                if(first == -1) {
                    first = value;
                } else {
                    first = second;
                }
                second = value;
                result = Math.min(first, second);
                max = Math.max(max, second);
            }

            @Override
            public String toString() {
                return first+" "+second+" "+result+" "+max;
            }
        }

        // Complete the riddle function below.
        static long[] riddle(long[] arr) {
            // complete this function
            Stack[] pos = new Stack[arr.length];
            for(int i=0; i<arr.length; i++) {
                pos[i] =  new Stack();
                pos[0].add(arr[i]);
                for(int j=1; j<=i; j++) {
                    pos[j].add(pos[j-1].result);
                }
            }

            long[] result = new long[arr.length];

            for(int k=0; k<arr.length; k++) {
                result[k] = pos[k].max;
            }
            return result;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long[] arr = new long[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long arrItem = Long.parseLong(arrItems[i]);
                arr[i] = arrItem;
            }

            long[] res = riddle(arr);

            System.out.println("RESULT : ");
            for (int i = 0; i < res.length; i++) {
                //bufferedWriter.write(String.valueOf(res[i]));
                System.out.print(res[i]);
                if (i != res.length - 1) {
                    //bufferedWriter.write(" ");
                    System.out.print(" ");
                }
            }

            //bufferedWriter.newLine();

            //bufferedWriter.close();

            scanner.close();
        }
    }
