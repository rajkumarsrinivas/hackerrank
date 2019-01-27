package com.rajkumar.hackerrank.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class LeaderBoard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] result = new int[alice.length];
        int[] rank = new int[scores.length];
        int r = 1;

        int t = 0;



        int previous = scores[0];
        t = 0;
        for (int i : scores) {
            if (previous == i) {
                rank[t++] = r;
            } else {
                rank[t++] = ++r;
            }
            previous = i;
        }

        int len = scores.length - 1;

        for(int j=0; j < alice.length ; j++) {
            for(int i= len; i> -1;i-- ) {
                if( alice[j] < scores[i]) {
                    result[j] = rank[i]+1;
                    len=i;
                    break;
                }
                if(alice[j] == scores[i]) {
                    result[j] = rank[i];
                    len=i;
                    break;
                }
                if(alice[j] > scores[i]) {
                    result[j] = rank[i];
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println("\n");
        for( int i : result) {
            System.out.print(i+" ");
        }
        scanner.close();
    }
}
