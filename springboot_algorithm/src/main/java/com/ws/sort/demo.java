package com.ws.sort;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {

    @Test
    public void test() throws InterruptedException {
        // int[] arr = {4, 5, 5, 4, 5, 1};
        // // quickSort(arr, 0, arr.length - 1);
        // quickSort2(arr);
        // System.out.println(Arrays.toString(arr));

        String str = "db.student.find({\"class\": {\"$in\":[\"1班\",\"3班\"]}})";
        Pattern databaseNamePattern = Pattern.compile("db\\.([^.]+)\\.find");
        Matcher matcher = databaseNamePattern.matcher(str);
        if (matcher.find()) {
            System.out.println("数据库名称：" + matcher.group(1));
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "10");

        final ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();
        reentrantLock.lock();
        reentrantLock.unlock();
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            partition(arr, low, partitionIndex - 1);
            partition(arr, partitionIndex + 1, high);
        }
    }

    public void quickSort2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();
            int partitionIndex = partition(arr, low, high);
            if (low < partitionIndex - 1) {
                stack.push(low);
                stack.push(partitionIndex - 1);
            }
            if (partitionIndex + 1 < high) {
                stack.push(partitionIndex + 1);
                stack.push(high);
            }
        }
    }


    // 冒泡
    public void BubbleSort(int[] arr) {
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
