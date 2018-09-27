package com.joeysin.paper;

import java.util.Stack;

class Fu {
    int num = 4;

    public void show()// 因为覆盖的特性，
    {
        System.out.println("fu show run");
    }

    public static void staticMethod() {
        System.out.println("fu static method run");
    }
}

class Zi extends Fu {
    int num = 5;

    public void show()// 因为覆盖的特性，
    {
        System.out.println("zi show run");
    }

    public static void staticMethod() {
        System.out.println("zi static method run");
    }
}

class DuoTaiTest {


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5L);
        System.out.println(stack.capacity());
        System.out.println(stack.size());
    }
}

