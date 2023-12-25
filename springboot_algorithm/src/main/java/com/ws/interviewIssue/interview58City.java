package com.ws.interviewIssue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * demo58
 * 给定一个静态数组，将偶数放在前面，奇数放在后面
 *
 * @author wangsen
 * @date 2023/12/24
 */
public class interview58City {

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
                // 返回负数表示第一个数小于第二个数
                return -1;
            }
            if (a % 2 != 0 && b % 2 == 0) {
                // 返回正数表示第一个数大于第二个数
                return 1;
            }
            return a.compareTo(b);
        }
    }


}
