package com.rajkumar.hackerrank.stacks_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TextEditor {

//    static class Operation {
//        int ops
//    }

    static Stack<String> opsStack = new Stack<>();
    static String queue = new String();

    private static void doAction(String[] value) {

        switch (value[0]) {
            case "1":
                queue = queue.concat(value[1]);
                opsStack.push(queue);
                break;
            case "2":
                queue = queue.substring(0, queue.length()-Integer.parseInt(value[1]));
                opsStack.push(queue);
                break;
            case "3":
                System.out.println(queue.charAt(Integer.parseInt(value[1])-1));
                break;
            case "4":
                opsStack.pop();
                queue = opsStack.peek();
                break;
            default:
                System.out.println("Operation not implemented...");
                break;

        }
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //InputStream in;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arrItems = new String[n];
        for (int i = 0; i < n; i++) {
            arrItems = scanner.readLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            doAction(arrItems);
        }
    }
}
