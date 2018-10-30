package com.joeysin.paper.algorithm.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joeysin on  2018/10/29  10:44.
 * Describe：有效的字母异位词
 * 把字符串拆分，只要一个单词中的每个字母都相同返回true
 */
public class LeadCode242 {

    /**
     * Created by Joeysin on  2018/10/29  11:14.
     * Describe：map 记数法
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (char cv : s.toCharArray()) {
            Integer count = map.get(cv);
            if (count != null && count > 0) {
                count++;
                map.put(cv, count);
            } else {
                map.put(cv, 1);
            }
        }
        for (char cv : t.toCharArray()) {
            Integer count = map2.get(cv);
            if (count != null && count > 0) {
                count++;
                map2.put(cv, count);
            } else {
                map2.put(cv, 1);
            }
        }
        return map.equals(map2);
    }

    /**
     * Created by Joeysin on  2018/10/29  11:15.
     * Describe：排序比较法
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ch1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            ch1[c1 - 'a'] += 1;
            ch1[c2 - 'a'] -= 1;
        }
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
}
