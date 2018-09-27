package com.joeysin.paper;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    public static void main(String[] args) {
       ReentrantLock reentrantLock=new ReentrantLock(false);
        reentrantLock.tryLock();
    }
}
