package com.joeysin.paper.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joeysin on  2018/10/24  13:30.
 * Describe：不使用➗，实现除法
 */
public class DivideTwoNum {


    /**
     * Created by Joeysin on  2018/10/24  13:48.
     * Describe：[] ] ]      ]
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //绝对值
        long a = Math.abs((long) dividend);//被除数
        long b = Math.abs((long) divisor);//除数
        int count = 0; //次数
        long sum;//val + val
        while (b <= a) {// |除数| 小于等于 |被除数|
            //外层控制 ➗ 一次divisor，内层控制➗ 多次
            sum = b;
            int countβ = 1;
            // n / n ^ 2 指数相加，除数循环和自己相加，直到小于被除数
            while (sum + sum <= a) {
                count += count;
                sum += sum;
            }
            a = a - sum;
            count = countβ + count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            count = -count;
        }
        return count;
    }


    /**
     * Created by Joeysin on  2018/10/26  11:29.
     * Describe：倒转一个数字
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
//      System.out.println(Integer.bitCount(129));
        reverse(-234);
    }
}
