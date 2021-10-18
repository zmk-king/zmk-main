package com.itheima_03;

import java.util.Arrays;

public class arrays_demo {
    public static void main(String[] args) {
        String Sr = "91 27 46 38 50";
        System.out.println("排序前数据:" + Sr);

        String[] split = Sr.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            //注意parseInt中参数为String类型，split[]是一个数组，split[i]里面才是String类型的数据
            arr[i] = Integer.parseInt(split[i]);
            //System.out.println(arr[i]);
        }

/*        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }*/

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                //System.out.print(arr[i]);
                sb.append(arr[i]);
            } else {
                //System.out.print(arr[i] + " ");
                sb.append(arr[i]).append(" ");
            }
        }
        String s = sb.toString();
        System.out.println("排序后结果:" + s);
    }
}
