package com.joeysin.paper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * -XX:+HeapDumpOnOutOfMemoryError      oom导出打印
 * -XX:HeapDumpPath=/Users/joeysin/Desktop/  导出地址
 * -XX:+PrintGCDetails  						打印GC
 * -Xss8G     单线程最小栈      如果向系统申请失败提示 java.lang.OutOfMemoryError: unable to create new native thread   解决方案：减小堆空间-Xmx || MateSpaceSize
 * -Xmx20M    堆空间Max   超出提示OOM   java.lang.OutOfMemoryError: Java heap space
 * -Xms20M    堆空间Min
 * -Xmn10M    新生代10M
 * -XX:MetaspaceSize=1G   java8用来保存类信息字符串常量池移到Java堆
 */
public class Xms_Xmx_MaxMetaspaceSize {


    public static int i = 1;//准备阶段在MateSpace区分配内存，按代码顺序执行

    static {
        i = 2;
//        System.out.println(i);
    }

//    static List<Test> list = new ArrayList<Test>();
//
//    public static class Test {
//    }



//    public static void digui() {
//        List list = new ArrayList();
//        while (true) {
//            list.add(new Test());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    });
}
