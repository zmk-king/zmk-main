package com.itheima;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Steam_Demo {
    public static void main(String[] args) {
        ArrayList<String> man = new ArrayList<String>();
        ArrayList<String> woman = new ArrayList<String>();

        man.add("周淼柯");
        man.add("马涛");
        man.add("刘祎民");
        man.add("曾阳涛");
        man.add("谢吉平");
        man.add("陈智炜");

        woman.add("李慧");
        woman.add("贺俐林");
        woman.add("周乐晴");
        woman.add("吕静");
        woman.add("李宇乐");
        woman.add("李志俐");

        Stream<String> manstream = man.stream().filter(s -> s.length() == 3).limit(3).sorted();
        Stream<String> womanstream = woman.stream().filter(s -> s.startsWith("李")).skip(1).sorted();

        Stream<String> stream = Stream.concat(manstream, womanstream);

        //使用stream中的map方法将stream中的string元素作为构造方法中的参数来创建演员对象
        stream.map(Action::new).forEach(p-> System.out.println(p.getName()));
        System.out.println("------");


        //一步到位
        Stream.concat(man.stream().filter(s -> s.length() == 3).limit(3).sorted(),
                woman.stream().filter(s -> s.startsWith("李")).skip(1).sorted()).map(Action::new).
                forEach(p->System.out.println(p.getName()));
    }

}
