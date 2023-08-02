package com.ws.leetcode;

import org.junit.jupiter.api.Test;

public class No35 {

    @Test
    public void test(){
        int[] nums = {2,4,6,7};
        int i = searchInsert(nums, 5);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i< nums.length ; i++){
            if( nums[i] == target ){
                return i;
            }
        }

        for(int i=nums.length - 1; i>=0; i--){
            if(target >= nums[i]){
                return i+1;
            }
        }
        return 0;

    }
}
