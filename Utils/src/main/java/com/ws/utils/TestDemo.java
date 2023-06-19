package com.ws.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
@Slf4j
public class TestDemo {
    //test工具类
    public static void main(String[] args) {
        String s = "12341223";
        int i = lengthOfLongestSubstring(s);
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
     *
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
     * @param s 入参
     * @return String
     */
    public static String longestPalindrome(String s){

         return null;
    }

}
