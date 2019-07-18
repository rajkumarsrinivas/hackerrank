package com.rajkumar.hackerrank.arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps2 {



    public static int findMinSwapsToSort(int[] ar) {
        int n = ar.length;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(ar[i], i);
        }
        for(int i :ar) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~");
        m.forEach((a, b) -> System.out.println(a+" : "+b));
        System.out.println("~~~~~~~~~~~~~~~~~");
        Arrays.sort(ar);
        for(int i :ar) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < n; i++) {
            ar[i] = m.get(ar[i]);
        }
        m = null;
        int swaps = 0;
        for(int i :ar) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int val = ar[i];
            if (val < 0) continue;
            while (val != i) {
                int new_val = ar[val];
                ar[val] = -1;
                val = new_val;
                swaps++;
            }
            ar[i] = -1;
        }
        return swaps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int min = arr[0];
        for(int i=1; i< arr.length; i++) {
            if( min > arr[i]) {
                min = arr[i];
            }
        }
        int n =0, s_swap=0;
        for(int i=0; i< arr.length; i++) {
            if((i >= (arr[i]-min)) && (i == arr[arr[i]-1]-min)) {
                s_swap++;
            }
        }
        return (arr.length-1-s_swap);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

       // System.out.println(minimumSwaps(arr));

        System.out.println(findMinSwapsToSort(arr));
       // bufferedWriter.write(String.valueOf(res));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}
