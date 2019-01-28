package com.rajkumar.hackerrank.arrays;


import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int i = 0;
        if(a.length == d || d == 0) {
            result = a;
        } else {
            for (int j = d; j < a.length; j++) {
                result[i++]=a[j];
            }
            for(int j=0; j < d; j++) {
                result[i++]=a[j];
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));
            System.out.print(result[i]+" ");
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
