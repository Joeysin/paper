package com.joeysin.paper.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Joeysin on  2018/10/11  15:50.
 * Describe：
 * param array ,target
 * 求任意三个数的和为0
 * result:
 */
public class ThreeSum {
    public static int[] array = new int[]{-1, 0, 1, 2, -1, -4};
    public static int target = 0;

    /**
     * Created by Joeysin on  2018/10/11  18:51.
     * Describe：O(2^n)
     */
    public static List<List<Integer>> threeSum(int[] array, int target) {
        Arrays.sort(array);
        List<Integer> group = null;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            while (j != array.length - 1) {
                int k = array.length - 1;
                while (k - j != 0) {
                    if (array[i] + array[j] + array[k] == 0) {
                        group = new ArrayList<>();
                        group.add(array[i]);
                        group.add(array[j]);
                        group.add(array[k]);
                        list.add(group);
                    }
                    k--;
                }
                j++;
            }
        }
        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    /**
     * Created by Joeysin on  2018/10/11  18:51.
     * Describe：
     */
    public static List<List<Integer>> threeSum2(int[] array) {
        Arrays.sort(array);//排序
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> group = null;
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            int front = i + 1;//当前的后一个元素
            int rear = n - 1;//最后一个元素
            while (front < rear) {
                int sum = array[i] + array[front] + array[rear];

                if (sum > 0)
                    --rear;//前移
                else if (sum < 0)
                    ++front;//后移
                else {
                    group = new ArrayList<>();
                    group.add(array[i]);
                    group.add(array[front]);
                    group.add(array[rear]);
                    list.add(group);
                    while (front < rear && array[front] == group.get(1)) ++front;
                    while (front < rear && array[rear] == group.get(2)) --rear;
                }
            }
            while (i < n - 1 && array[i] == array[i + 1]) ++i;
        }
        return list;
    }

    /**
     * Created by Joeysin on  2018/10/11  18:50.
     * Describe：某大神写的
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(threeSum(array, target));
        System.out.println(threeSum2(array));
    }
}
