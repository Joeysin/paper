package com.joeysin.paper.algorithm;


import java.util.*;

/**
 * Created by Joeysin on  2018/10/18  18:13.
 * Describe：堆相关
 */
public class Heap {

    /**
     * Created by Joeysin on  2018/10/18  18:30.
     * Describe：输入持续的数据流，计算出第k大的数
     */
    public static class KthLargest {
        private List<Integer> list;
        private int kMax;
        private Queue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            list = new ArrayList<>();
            this.kMax = k;
            heap = new PriorityQueue<>();
            for (int curVal : nums) {
                this.list.add(curVal);
                this.add2(curVal);
            }
        }

        /**
         * Created by Joeysin on  2018/10/19  15:10.
         * Describe：暴力法：每次新增的时候执行排序
         */
        public int add(int val) {
            list.add(val);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            kMax = (int) list.get(kMax - 1);
            return kMax;
        }

        /**
         * Created by Joeysin on  2018/10/19  15:11.
         * Describe：优先队列：使用小顶堆保留三个节点位置，新增的元素大于top节点的话删除top节点后 add()当前节点；小于的话直接返回top节点
         */
        public int add2(int val) {
            if (heap.isEmpty() || heap.size() < kMax) {
                heap.add(val);
            } else if (val > heap.peek()) {
                heap.poll();
                heap.add(val);
            }
            return heap.peek();
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, array);
        System.out.println(kthLargest.add2(3));
        System.out.println(kthLargest.add2(5));
        System.out.println(kthLargest.add2(10));
        System.out.println(kthLargest.add2(9));
        System.out.println(kthLargest.add2(4));
    }
}
