package com.ws.interviewIssue;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class demo02 {

    @Test
    public void test(){
        int[][] grid = {
                {1, 2, 1},
                {2, 2, 3},
                {3, 2, 1}
        };

        int totalCount = calculateValidSegments(grid);
        System.out.println("线段数: " + totalCount);
    }

    public static int calculateValidSegments(int[][] grid) {
        //有效线段个数
        int totalCount = 0;
        //行数=列数
        int N = grid.length;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                //方格的每个值
                int segmentLength = grid[row][col];
                if (col + segmentLength <= N) {
                    boolean valid = true;
                    for (int i = 1; i < segmentLength; i++) {
                        if (grid[row][col + i] != segmentLength) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        totalCount++;
                    }
                }

                if (row + segmentLength <= N) {
                    boolean valid = true;
                    for (int i = 1; i < segmentLength; i++) {
                        if (grid[row + i][col] != segmentLength) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        totalCount++;
                    }
                }
            }
        }

        return totalCount;
    }

}
