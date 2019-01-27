package com.rajkumar.hackerrank.warmup;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/counting-valleys/problem

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int i=0;
        int valleyCount = 0;

        for(String c : s.split("")) {
                        if (c.equals("U")) {
                            i++;
                        }
                        if(c.equals("D")) {
                            if(i == 0) {
                                valleyCount++;
                            }
                            i--;
                        }
                }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println("No of valleys : "+result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
