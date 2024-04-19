package com.ws.sort;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangsen_a
 * @date 2024/04/19
 */
public class DemoTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        // int[] arr = {3, 2, 4, 5, 7, 6};
        // quickSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // .execute()方法无返回值
        threadPool.execute(() -> System.out.println("线程1..."));
        // .submit()方法有返回值
        Future<?> future = threadPool.submit(() -> {
            System.out.println("线程2");
            return;
        });

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
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

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
