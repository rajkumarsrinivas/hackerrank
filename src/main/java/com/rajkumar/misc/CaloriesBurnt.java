package com.rajkumar.misc;

import java.util.Scanner;

public class CaloriesBurnt {


    private long addData(Scanner scan, int days){

        if(days==1){
            return scan.nextInt();
        }
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            insertSorted(arr,i,scan.nextInt(),days);
        }

        long caloriesBurnt =0;
        long runKm = 0;
        for (int i = days-1; i >= 0 ; i--) {
            caloriesBurnt = caloriesBurnt + (2*runKm) + arr[i];
            runKm = runKm + arr[i];
        }
        return caloriesBurnt;
    }

    private int insertSorted(int arr[], int n, int key, int capacity)
    {
        // Cannot insert more elements if n is already
        // more than or equal to capcity
        if (n >= capacity)
            return n;

        int i;
        for (i=n-1; (i >= 0 && arr[i] > key); i--)
            arr[i+1] = arr[i];

        arr[i+1] = key;

        return (n+1);
    }

    public static void main(String[] args){
        CaloriesBurnt c = new CaloriesBurnt();

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int k = t; k > 0; k--) {
            int days = scan.nextInt();
            System.out.println(c.addData(scan, days));
        }
    }
}
