package com.rajkumar.hackerrank.compete;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FibonacciWords {


    static int getResult(String[] val) {
        List<BigInteger> fcount = new ArrayList<>();
        BigInteger oneInt = BigInteger.valueOf(val[0].length());
        BigInteger twoInt = BigInteger.valueOf(val[1].length());
        BigInteger n = new BigInteger(val[2]);
        fcount.add(oneInt);
        fcount.add(twoInt);
        int j=2;
        int result = -1;
        do{
            fcount.add(oneInt.add(twoInt));
            oneInt = twoInt;
            twoInt = fcount.get(fcount.size()-1);
            System.out.println((j++)+" : "+fcount.get(fcount.size()-1));
        }while(twoInt.compareTo(n)<0);

        int i = fcount.size() -3;
        int currentIndex = i;
        while(i>=0) {
            BigInteger current = fcount.get(i);
            if(n.compareTo(current)>0) {
                n = n.subtract(current);
                i--;
                currentIndex = i;
            }
            else
            {
                if(i==0)
                    result = val[0].charAt(n.intValue() - 1);
                if(i==1)
                    result = val[1].charAt(n.intValue() - 1);
                i = currentIndex - 2;
                currentIndex = i;
            }
        }
        if(result == -1)
            result = val[1].charAt(n.intValue() - 1);
        return (result-48);
    }
     static void calc(String[] val) {
            BigInteger n = new BigInteger(val[2]);
            List<BigInteger> list = new ArrayList<>();

       BigInteger aLen = BigInteger.valueOf(val[0].length());
       BigInteger bLen = BigInteger.valueOf(val[1].length());

       list.add(bLen);list.add(bLen);

        BigInteger res = aLen.add(bLen);
        aLen = bLen;
        bLen = res;
        list.add(res);

        while(res.compareTo(n) < 0) {
            res = aLen.add(bLen);
            aLen = bLen;
            bLen = res;
            list.add(res);
        }

        BigInteger len = BigInteger.valueOf(Math.max(val[0].length(), val[0].length()));
        BigInteger left;
         int count = list.size()-2;
        while(n.compareTo(len) > 0) {
            left = list.get(--count);
            if(n.compareTo(left) > 0 )
                n = n.subtract(left);
            else
                --count;
        }
        if(count == 1) {
            System.out.println(val[0].charAt(n.intValue()-1));
        } else {
            System.out.println(val[1].charAt(n.intValue()-1));
        }
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
            getResult(hItems);
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
