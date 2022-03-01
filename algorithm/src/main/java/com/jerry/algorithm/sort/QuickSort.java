package com.jerry.algorithm.sort;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/1 10:14 AM
 **/
public class QuickSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = swap(array, start, end);
        sort(array, start, mid - 1);
        sort(array, mid + 1, end);
    }

    private int swap(int[] array, int start, int end) {
        int pivot = array[start];
        array[start] = array[end];
        array[end] = pivot;
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (array[right] > pivot) {
                right--;
            } else {
                int tmp = array[left];
                array[left++] = array[right];
                array[right] = tmp;
            }
        }
        array[end] = array[right + 1];
        array[right + 1] = pivot;
        return right + 1;

    }
}
