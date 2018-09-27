package com.joeysin.paper;

public class Algorithm {
    public static void main(String[] args) {
        int c = 0;
        for (int i = 1; i <= 10; i++) {
            c += i;
            if (i == 10) {
                System.out.println(c);
            }
        }
    }
}
