package com.joeysin.paper.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joeysin on  2018/10/17  15:14.
 * Describe：递归练习：给定n组括号，生成所有可能的种类的括号
 */
public class Recursive {

    /**
     * Created by Joeysin on  2018/10/17  15:16.
     * Describe：递归法
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    /**
     * Created by Joeysin on  2018/10/17  15:43.
     * Describe：回溯法:满足条件 「左括号<n 右括号<做括号」 才能递归。通过判断「序列长度==n*2」表示满足产出条件
     * O 2^n
     * (
     * ((,()
     * (((,()(,(()
     * (((),()((,()(),(()(,(())
     * ((()),()((),()()(,(()(),(())(
     * ((())),()(()),()()(),(()()),(())()
     */
    public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            System.out.println("r: " + cur);
            return;
        }
        if (open < max) {
            System.out.println("* " + cur);
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            System.out.println("# " + cur);
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }



    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
