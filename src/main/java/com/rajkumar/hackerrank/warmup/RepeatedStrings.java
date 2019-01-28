package com.rajkumar.hackerrank.warmup;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedStrings {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        String[] ar = s.split("");
        int tot = 0;

        long rem = n % s.length();
        long repeat = n / s.length();
        int remPieces = 0;
        for(int i=0; i < s.length(); i++) {
            if(ar[i].equals("a")) {
                tot++;
                if(i < rem) {
                    remPieces++;
                }
            }
        }
        System.out.println((tot*repeat)+" : "+remPieces);
        return (tot*repeat)+remPieces;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println("RESULT : "+result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
