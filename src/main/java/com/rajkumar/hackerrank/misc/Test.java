package com.rajkumar.hackerrank.misc;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("950");
        BigInteger b = new BigInteger("100");
        for(int i=0; i < 10;i++) {
            System.out.println("a ="+a+" , b ="+b+" , comp ="+a.compareTo(b));
            a = a.subtract(b);
        }
    }
}
