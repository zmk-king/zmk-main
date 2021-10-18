package com.itheima_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Class_Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> name = Class.forName("com.itheima.Student");
        System.out.println(name);
        System.out.println("-----------------");

        //返回所有公共构造方法
        Constructor<?>[] constructors = name.getConstructors();
        for (Constructor s : constructors){
            System.out.println(s);
        }
        System.out.println("-----------------");

        //返回所有构造方法
        Constructor<?>[] con2 = name.getDeclaredConstructors();
        for (Constructor s : con2){
            System.out.println(s);
        }
        System.out.println("-----------------");

        //返回单个公共构造方法
        Constructor<?> con3 = name.getConstructor();
        System.out.println(con3);
        System.out.println("-----------------");

        //返回单个构造方法
        Constructor<?> con4 = name.getDeclaredConstructor(String.class);
        System.out.println(con4);
        System.out.println("-----------------");

        //根据指定的构造方法创建对象
        Object o = con3.newInstance();
        System.out.println(o);
        System.out.println("-----------------");

        //基本数据类型也有相应的class类型，这里直接int.class,不用Intger.class
        Constructor<?> con = name.getConstructor(String.class, int.class, String.class);
        Object obj = con.newInstance("林青霞", 30, "湖南长沙");
        System.out.println(obj);
        System.out.println("-----------------");

        //Constructor<?> cons = name.getConstructor(String.class);
        Constructor<?> cons = name.getDeclaredConstructor(String.class);
        //暴力反射，值为true，取消访问检查
        cons.setAccessible(true);
        Object obj2 = cons.newInstance("周淼柯");
        System.out.println(obj2);

    }
}
