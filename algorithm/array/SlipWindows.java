package com.joeysin.paper.algorithm.array;

/**
 * Created by Joeysin on  2018/10/19  16:13.
 * Describe：窗口划定计算每次滑动后k个值相加后的结果
 */
public class SlipWindows {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }

        int maxCount = length == k ? 1 : length - k + 1;//result的容量
        int[] result = new int[maxCount];
        int startIndex = 0;
        int endLoop = k;

        while (endLoop <= length) {
            int max = Integer.MIN_VALUE;
            for (int j = startIndex; j < endLoop; j++) {
                int currentSlipNode = nums[j];
                if (currentSlipNode > max) {
                    max = currentSlipNode;
                }
            }
            result[startIndex] = max;
            startIndex++;
            endLoop++;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
