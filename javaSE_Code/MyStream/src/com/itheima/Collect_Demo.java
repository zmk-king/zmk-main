package com.itheima;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect_Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("柳岩");
        list.add("刘亦菲");
        list.add("王祖贤");

        Stream<String> liststream = list.stream().filter(s -> s.length() == 3);

        //通过Stream流的collect方法收集，但collect方法里面的参数是一个Collector接口
        //所以通过工具类Collectors来实现具体的收集方法
        //Collector tolist()
        //Collector toset()
        //Collector toMap(Function keyMapper,Function valueMapper)
        List<String> stringList = liststream.collect(Collectors.toList());

        for (String s : stringList) {
            System.out.println(s);
        }

        System.out.println("--------");

        Set<Integer> set = new HashSet<Integer>();
        set.add(28);
        set.add(32);
        set.add(30);
        set.add(20);
        set.add(35);

        Stream<Integer> integerStream = set.stream().filter(s -> s > 25);

        Set<Integer> integerSet = integerStream.collect(Collectors.toSet());

        for (Integer integer : integerSet) {
            System.out.println(integer);
        }

        System.out.println("--------");

        String[] strarray = {"林青霞,28", "张曼玉,32", "王祖贤,30", "柳岩,20", "刘亦菲,35"};

        Stream<String> stringStream = Stream.of(strarray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28).sorted();

        Stream.of(strarray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28).sorted((s1,s2)->{
            int num = s2.compareTo(s1);
            return num;
        }).forEach(System.out::println);
        System.out.println("--------");

        Map<String, Integer> map = stringStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));

        //map集合的第一种遍历方式
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            Integer integer = map.get(s);
            System.out.println(s + "," + integer);
        }

        System.out.println("--------");

        //map集合的第二种遍历方式
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "," + value);
        }
    }
}
