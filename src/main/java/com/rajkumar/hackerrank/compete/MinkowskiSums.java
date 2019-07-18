package com.rajkumar.hackerrank.compete;

import java.io.IOException;
import java.util.Scanner;

public class MinkowskiSums {


    static void calc(String[] val) {
        long start = Long.parseLong(val[0]);
        long end = Long.parseLong(val[1]);
        long temp = start;
        for(long i=start+1; i<=end; ++i) {
            temp = temp+i-1;
        }
        System.out.println(temp);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        //int[] h = new int[n];




        for (int i = 0; i < n; i++) {
            String[] hItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            calc(hItems);
        }

        //long result = calc(h);
        // check(h);

        //System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
