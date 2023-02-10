package com.alexisdrai.tp3;

public class Fibonacci {
    public int fib(int n) {
        if (n < 0) {
            throw new ArithmeticException("Fibonacci's sequence begins at n_0");
        }
        if (n > 41) {
            throw new IllegalArgumentException("fib(n>41) would exceed Integer.MAX_VALUE");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
