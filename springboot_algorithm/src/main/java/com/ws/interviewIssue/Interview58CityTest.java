package com.ws.interviewIssue;

import com.ws.common.CommonUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 58同城
 * 给定一个静态数组，将偶数放在前面，奇数放在后面
 *
 * @author wangsen
 * @date 2023/12/24
 */
public class Interview58CityTest {

    @Test
    public void test() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        // 通过自定义比较器实现
        Arrays.sort(arr, new CustomComparator());
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自定义比较器
     *
     * @author wangsen
     * @date 2023/12/24
     */
    static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a % 2 == 0 && b % 2 != 0) {
                // 返回负数表示第一个数排在第二个数前面
                return -1;
            }
            if (a % 2 != 0 && b % 2 == 0) {
                // 返回正数表示第一个数排在第二个数后面
                return 1;
            }
                return a.compareTo(b);
        }
    }


    @Test
    public void testTwo() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        // 通过自定义比较器实现
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 方法二：双指针法
     *
     * @param nums int数组
     */
    public static void rearrange(int[] nums) {
        // 数组判空
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 左指针 指向数组开头
        int left = 0;
        // 右指针 指向数组末尾
        int right = nums.length - 1;

        while (left < right) {
            // 若左指针指向奇数，右指针指向偶数，则交换
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                CommonUtils.swap(nums, left, right);
                left++;
                right--;
            } else {
                // 左指针指向偶数，右指针指向偶数，左指针向后移动
                if (nums[left] % 2 == 0) {
                    left++;
                }
                // 左指针指向奇数，右指针指向奇数，右指针向前移动
                if (nums[right] % 2 != 0) {
                    right--;
                }
                // 左指针偶数，右指针奇数，则左向后 右向前一步
                if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                    left++;
                    right--;
                }
            }
        }
    }

}
