package com.ws.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * @author wangsen_a
 * @date 2023/12/26
 */
public class No35 {

    @Test
    public void test(){
        int[] nums = {2,4,6,7};
        int i = searchInsert(nums, 5);
        System.out.println(i);
    }

    /**
     * 搜索插入
     *
     * @param nums   数组
     * @param target 目标值
     * @return int
     */
    public int searchInsert(int[] nums, int target) {
        // 正序遍历
        for(int i = 0; i< nums.length ; i++){
            if( nums[i] == target ){
                return i;
            }
        }
        // 倒序遍历
        for(int i=nums.length - 1; i>=0; i--){
            if(target >= nums[i]){
                return i+1;
            }
        }
        return 0;

    }
}
