package com.stoxalpha;

import java.util.HashMap;
import java.util.Map;

//F(N) = F(N-1) + F(N-2)
//Base cases
//F(0) = 0, F(1) = 1
//O(2^N) time complexity with recursion approach
//Memoization - O(N) time complexity + require O(N) space
//***The definition with Fib(0) = 1 is known as the combinatorial definition, and Fib(0) = 0 is the classical definition
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
//        System.out.println(fibonacci.fibonacciRecursion(100););
        // It has exponential running time
        System.out.println(fibonacci.fibonacciRecursion(30));

        Map<Integer, Integer> fibonacciMap = new HashMap<>();
        fibonacciMap.put(0, 1);
        fibonacciMap.put(1, 1);
        // They have O(N) running time
        System.out.println(fibonacci.fibonacciMemoization(30, fibonacciMap));
        System.out.println(fibonacci.fibonacciTabulation(30, fibonacciMap));
    }

    public int fibonacciRecursion(int n) {
        if (n==0) return 1;
        if (n==1) return 1;

        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

    //Top Down approach - Memoization O(N) time complexity
    public int fibonacciMemoization(int n, Map<Integer, Integer> table) {
        if (!table.containsKey(n)) {
            table.put(n, fibonacciMemoization(n - 1, table) + fibonacciMemoization(n - 2, table));
        }

        return table.get(n);
    }

    //Bottom up approach - Tabulation - O(N) Time complexity
    public int fibonacciTabulation(int n, Map<Integer, Integer> table) {
        for (int i = 2; i<=n; i++) {
            table.put(i, table.get(i - 1) + table.get(i - 2));
        }

        return table.get(n);
    }
}
