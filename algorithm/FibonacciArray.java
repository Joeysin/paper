package com.joeysin.paper.algorithm;

/**
 * Created by Joeysin on  2018/10/11  16:11.
 * 斐波那契数列
 * Describe：O(2^n)
 */
public class FibonacciArray {

    public static Integer fib(Integer n) {
        System.out.println(n);
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);//32110
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(fib(n));
    }
}
