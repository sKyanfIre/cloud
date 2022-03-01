package com.jerry.algorithm.sort;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/1 7:27 PM
 **/
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
