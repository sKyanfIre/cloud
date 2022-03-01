package com.jerry.algorithm.sort;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/1 3:41 PM
 **/
public class SortTest {
    private static int[] array = new int[]{2, 3, 1, 2, 4, 5, 0, 6};

    @Test
    void selectSortTest() {
        sort(new SelectSort());

    }

    @Test
    void quickSortTest() {
        sort(new QuickSort());
    }

    private void sort(Sort sort) {
        int[] array1 = Arrays.copyOf(array, array.length);
        sort.sort(array1);
        assertSort(array1);

    }

    private void assertSort(int[] array1) {
        int[] array2 = Arrays.copyOf(array1, array1.length);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println("=================");
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array1.length; i++) {
            Assert.isTrue(array1[i] == array2[i], "sort fail");
        }

    }
}
