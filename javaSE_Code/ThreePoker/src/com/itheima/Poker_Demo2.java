package com.itheima;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Poker_Demo2 {
    public static void main(String[] args) {

        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 0;

        for (String number : numbers) {
            for (String color : colors) {
                tm.put(index, color + number);
                index++;
            }
        }
        tm.put(index,"小王");
        index++;
        tm.put(index,"大王");

        //只能对list表用
        Collections.shuffle((List<?>) tm);

        //TreeMap<Integer, String> a = new TreeMap<>();
        //TreeMap<Integer, String> b = new TreeMap<>();
        //TreeMap<Integer, String> c = new TreeMap<>();
        TreeMap<Integer, String> d = new TreeMap<>();

        for (int i = 0;i< tm.size();i++){
            if (i>= tm.size()-3){
                String s = d.get(i);
                System.out.println(s);
            }else if (i % 3 == 1){

            }
        }
    }
}
