package com.joeysin.paper.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joeysin on  2018/10/11  15:45.
 * Describe：
 * param: array， target
 * result：求任意两个数的和为target的下标
 * desc: O(n)
 */
public class TwoSum {
    public static int[] array = new int[]{1, 2, 7, 4};
    public static int target = 9;


    /**
     * Created by Joeysin on  2018/10/15  18:40.
     * Describe：每次循环和map中元素比对，不符合往map里面put，符合返回
     */
    public static int[] twoSun(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int currentV = array[i];
            int plus = target - currentV;
            if (map.containsKey(plus)) {
                return new int[]{map.get(plus), i};
            }
            map.put(array[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSun(array, target)));
    }
}
