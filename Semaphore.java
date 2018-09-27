package com.joeysin.paper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Semaphore implements Runnable {
    final java.util.concurrent.Semaphore semp = new java.util.concurrent.Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire(); //尝试获得一个许可，不断尝试，直到获得许可
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " done!");
            semp.release(); //释放许可
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] argv) throws InterruptedException {
        Semaphore r = new Semaphore();
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            exec.submit(r);
        }
        exec.shutdown();
    }
}
