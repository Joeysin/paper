package com.joeysin.paper.algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Joeysin on  2018/10/15  17:01.
 * Describe：校验符号是否匹配
 */
public class StackTest {
    private HashMap<Character, Character> mappings;

    {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    /**
     * Created by Joeysin on  2018/10/15  17:01.
     * Describe：使用Stack，左括号压栈，右括号匹配，匹配成功出栈；失败return
     * O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (mappings.containsKey(cur)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != mappings.get(cur)) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Created by Joeysin on  2018/10/15  17:10.
     * Describe：定义一个指针，在循环体中遇到一对括号就抵消，如果无法抵消的话指针的值=参数的值，跳出循环体
     * O(log(n) ^ n)
     */
    public boolean isValid2(String s) {
        int length = 0;
        while (length != s.length()) {
            length = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;

    }


    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        String s1 = "(])[";
        String s2 = "{[]}";
        String s3 = "{{{([])}}}({[]})";
        System.out.println(stackTest.isValid2(s1));
    }

}
