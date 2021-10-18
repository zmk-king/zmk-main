package com.itheima_01;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int[] array = {33, 66, 55, 44, 77};
        System.out.println(array.toString());
        System.out.println("排序前:" + Arrays.toString(array));

        /*for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }*/

        Arrays.sort(array);
        System.out.println("排序后:" + Arrays.toString(array));

    }
}
