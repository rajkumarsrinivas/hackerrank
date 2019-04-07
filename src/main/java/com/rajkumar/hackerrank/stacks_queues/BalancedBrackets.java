package com.rajkumar.hackerrank.stacks_queues;

import java.io.IOException;
import java.util.*;

public class BalancedBrackets {

    static List<String> pairs = Arrays.asList("{}","[]","()");
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        LinkedList<String> stack = new LinkedList<>();
        for(String x : s.split("")) {
            System.out.println("X : "+x);
            if(!stack.isEmpty() && pairs.contains(stack.peekLast()+x)) {
                stack.removeLast();
            } else {
                stack.add(x);
            }
            System.out.println("STACK : "+stack);
        }
        return stack.isEmpty()?"YES":"NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
           // bufferedWriter.write(result);
           // bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}