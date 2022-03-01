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
public class SelectSortTest {
    @Test
    void sortTest() {
        int[] array = new int[]{2, 3, 1, 2, 4, 5, 0};
        int[] array2 = Arrays.copyOf(array, array.length);
        Sort selectSort = new SelectSort();
        selectSort.sort(array);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println("=================");
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array.length; i++) {
            Assert.isTrue(array[i] == array2[i], "sort fail");
        }

    }
}
