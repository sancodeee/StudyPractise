package com.ws.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
@Slf4j
public class TestDemo {
    //test工具类
    public static void main(String[] args) {
        String s = "111111111";
        String i = longestPalindrome2(s);
        System.out.println(i);
    }

    /**
     * 判断是否是回文数
     *
     * @param x 字符串
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(String.valueOf(c));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if (sb.toString().equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 回文数
     *
     * @param x 回文数
     * @return boolean
     */
    public static boolean isPalindrome2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).reverse();
        if (sb.toString().equals(String.valueOf(x))) {
            return true;
        }
        return false;
    }

    /**
     * 两数之和
     * 时间复杂度：O(n²)
     * @param nums 数组
     * @param target 目标值
     * @return 数组
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                int res = x + y;
                if (res == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 两数之和
     * 时间复杂度O(n)
     * @param nums 数组
     * @param target 目标值
     * @return 数组
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);
        for (int i = 0; i < nums.length; i++) {
            //另一个数的值
            int another = target - nums[i];
            Integer index = map.get(another);
            if (index != null){
                result[0] = index;
                result[1] = i;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    /**
     * 最长子串长度
     * @param s 字符串
     * @return int
     */
    public static int lengthOfLongestSubstring(String s){
        if(s.length() == 0) return 0;
        //滑动窗口解决
        int maxLength = 0 ;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()){
            char currentChar = s.charAt(right);
            if (!set.contains(currentChar)){
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                log.info("right值：{}", right);
                right++;
            }else {
                set.remove(s.charAt(left));
                log.info("left值：{}", left);
                left++;
            }
        }
        return maxLength;
    }

    /**
     * 最长回文子串
     * 暴力求解 超时 时间复杂度: O(n²)
     * @param s 入参
     * @return String
     */
    public static String longestPalindrome(String s){
        String longestString = "";
        int maxLength = 0 ;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1 ; j++) {
                String substring = s.substring(i, j);
                log.info("子串：{}", substring);
                StringBuilder reverse = new StringBuilder().append(substring).reverse();
                if (substring.equals(String.valueOf(reverse))){
                    if (substring.length() > maxLength) {
                        maxLength = substring.length();
                        longestString = substring;
                    }
                }
                log.info("没有回文串");
            }
        }
        return longestString;
    }

    /**
     * 最长回文子串
     * 中心扩展法 时间复杂度：O(n²)
     * @param s 入参
     * @return String
     */
    public static String longestPalindrome2(String s){
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
