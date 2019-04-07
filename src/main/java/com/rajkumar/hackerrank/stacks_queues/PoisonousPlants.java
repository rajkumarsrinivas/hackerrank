package com.rajkumar.hackerrank.stacks_queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p, int n) {
        int[] list1 = new int[n];
        int returnValue = 1;
        int pos = 0;
        list1[pos++] = p[0];
        for(int i=1; i<n; i++) {
            if(p[i-1] >= p[i]) {
                list1[pos++]=p[i];
                //pos++;
            }
        }
        if(n != pos) {
            returnValue = returnValue+poisonousPlants(list1, pos);
        } else {
            returnValue--;
        }
        return returnValue;
    }

    static class Pair {
        int val, count;
        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    static int poisonousPlants(int[] p) {
        Stack<Pair> stack = new Stack<>();
        int cnt = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            int temp = 0;
            while (!stack.empty() && p[i] < stack.peek().val) {
                temp++;
                Pair pair = stack.pop();
                temp = Math.max(temp, pair.count);
            }
            cnt = Math.max(cnt, temp);
            stack.push(new Pair(p[i], temp));
        }

        return cnt;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        //int result = poisonousPlants(p, p.length);
        int result = poisonousPlants(p);

        System.out.println(result);
       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

      //  bufferedWriter.close();

        scanner.close();
    }
}
