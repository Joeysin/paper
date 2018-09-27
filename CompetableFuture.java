package com.joeysin.paper;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Joeysin on  2018/9/27  16:02.
 * Describe：CompletableFuture是JDK8提出的一个支持非阻塞的多功能的Future
 */
public class CompetableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 10;
        });


        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return 20;
        });


        //1.whenComplete() 在 future 完成后执行其他任务   e=excption
        CompletableFuture future3 = future.whenCompleteAsync((v, e) -> {
            //can't update future result ，only can use result ,for example:
            System.out.println(v);
        }).exceptionally(e -> {
            System.out.println(e == null);
            //future 执行异常后返回值
            return 11;
        });
        System.out.println(future3.get());


        //2.thenApply() 计算结果完成后对其转换、操作、使用......
        CompletableFuture<String> future4 = future.thenApplyAsync(i -> i + 8)
                .thenApplyAsync(i -> String.valueOf(i));
        System.out.println(future4.get());


        //3.thenAccept() 计算结果完成后的消费
        future.thenAcceptAsync(i -> {
            System.out.println(i);
        });


        //4.thenAcceptBoth() 合并结果(无返回值)
        System.out.println(future.thenAcceptBothAsync(future2, (x, y) -> {
            System.out.println(x + y);
        }).get());


        //5.runAfterBoth() mean  When future1 and future2 end after three step
        future.runAfterBothAsync(future2, () -> {
            System.out.println("run");
        });


        //6.public CompletableFuture<Void> thenRunAsync(Runable action); 一种参数为Runable的计算结果完成后不消费执行


        //7.thenCompose() 紧接上一个CompletableFuture进行处理
        CompletableFuture<Integer> future5 = future.thenComposeAsync(i -> CompletableFuture.supplyAsync(() -> {
            return i + 1;
        }));
        System.out.println(future5.get());


        //8.thenCombine() 合并结果（有返回值）
        CompletableFuture<Integer> future6 = future.thenCombineAsync(future2, (x, y) -> {
            return x + y;
        });
        System.out.println(future6.get());


        //9.acceptEither() 任意一个future完成后需要执行的工作(纯消费，无返回值)
        future.acceptEitherAsync(future2, x -> {
            System.out.println("xxx:" + x);
        });


        //10.applyToEitherAsync() 介绍任意一个future完成后需要执行的工作（有返回值）
        CompletableFuture<Integer> future7 = future.applyToEitherAsync(future2, x -> {
            return x;
        });
        System.out.println(future7.get());


        //11. allof() 当所有的CompletableFuture都执行完后执行计算
        CompletableFuture<Void> all = CompletableFuture.allOf(future, future2, future3, future4, future5, future6, future7);

        //12. isCompletedExceptionally() 处理过程中是否有异常
        boolean whether = all.isCompletedExceptionally();
        System.out.println(whether);


        //13. anyOf() 当任意一个CompletableFuture执行完后就会执行计算
        Object any = CompletableFuture.anyOf(future, future2, future3, future4, future5, future6, future7);
        System.out.println("any:" + ((CompletableFuture) any).get().toString());


        //14.建议：CompletableFuture和Java8的Stream搭配使用对于一些并行访问的耗时操作有很大的性能提高，可以自行了解

        //@before
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


        //14.2  测试串行stream
        long s1 = System.currentTimeMillis();
        list = list.stream().map(o -> {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return o;
        }).collect(Collectors.toList());
        System.out.printf("Processed %d sequential tasks in %d millis\n", list.size(), System.currentTimeMillis() - s1);

        //14.2  测试并行stream
        long s2 = System.currentTimeMillis();
        list = list.stream().parallel().map(o -> {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return o;
        }).collect(Collectors.toList());
        System.out.printf("Processed %d parallel tasks in %d millis\n", list.size(), System.currentTimeMillis() - s2);

        //14.3 测试CompetableFuture  join()和get() join()不会抛出exception更加适合lambda表达式，而个get()会
        //14.4 不会堵塞主线程
        //14.5 线程数量可控，如果是cpu密集型的使用sequential、parallel就好，如果是IO密集型的使用这种方式可以增加线程数
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(list.size(), (Runtime.getRuntime().availableProcessors() + 4)));
        long s3 = System.currentTimeMillis();
        List<CompletableFuture<Integer>> futures = list.stream().map(o -> CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return o;
        }, executorService)).collect(Collectors.toList());

        //doSomething(); 此方法会和上面循环并行运行

        list = futures.stream().map(f -> {
            return f.join();
        }).collect(Collectors.toList());
        System.out.printf("Processed %d competableFuture  tasks in %d millis\n", list.size(), System.currentTimeMillis() - s3);
        executorService.shutdown();
    }
}
