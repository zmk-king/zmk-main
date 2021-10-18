package com.itheima;

import java.util.*;


public class Poker_Demo {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        ArrayList<Integer> array = new ArrayList<Integer>();

        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 0;
        //这里先遍历花色再遍历数字（外循环为数字），以实现按照牌的大小排序
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;

            }
        }

        //System.out.println("排序前:"+hm);

        //由此可知TreeSet的自然排序是按照存储的顺序进行排序
       /* for (String color : colors) {
            for (String number : numbers) {
                hm.put(index, color + number);
                array.add(index);
                index++;

            }
        }*/

        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        System.out.println("最开始:");
        Set<Map.Entry<Integer, String>> entrySet = hm.entrySet();
        for (Map.Entry<Integer, String> map : entrySet) {
            String value = map.getValue();
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        Collections.shuffle(array);

        System.out.println("洗牌后:");
        for (Integer key : array) {
            String s = hm.get(key);
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        TreeSet<Integer> A = new TreeSet<Integer>();
        TreeSet<Integer> B = new TreeSet<Integer>();
        TreeSet<Integer> C = new TreeSet<Integer>();
        TreeSet<Integer> D = new TreeSet<Integer>();


        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                D.add(x);
            } else if (i % 3 == 0) {
                A.add(x);
            } else if (i % 3 == 1) {
                B.add(x);
            } else if (i % 3 == 2) {
                C.add(x);
            }
        }
        lookPoker("周淼柯", A, hm);
        lookPoker("刘祎民", B, hm);
        lookPoker("曾阳涛", C, hm);
        lookPoker("底牌", D, hm);
    }


    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {

        System.out.println("发牌后:");
        System.out.println(name + "的牌是:");

        for (Integer key : ts) {
            String s = hm.get(key);
            System.out.print(s + " ");
        }

        System.out.println();
    }
}
