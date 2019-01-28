package com.rajkumar.hackerrank.arrays;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDArrays {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int result = 0;
        for(int i=0; i<6 -2 ; i++) {
            for(int j=0; j<6-2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j] + arr[i+2][j + 1] + arr[i+2][j + 2];
                System.out.println(sum);
                if(sum > result || (i==0 && j==0)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println("RESULT :"+result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

}
