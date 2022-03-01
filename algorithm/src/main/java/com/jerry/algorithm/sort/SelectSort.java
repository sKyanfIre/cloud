package com.jerry.algorithm.sort;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/1 3:35 PM
 **/
public class SelectSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIdx = j;
                }
            }
            array[minIdx] = array[i];
            array[i] = min;
        }
    }
}
