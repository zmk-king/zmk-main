package com.itheima_03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Class_Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classname = Class.forName("com.itheima.Student");
        //返回所有公共成员变量
        Field[] fields = classname.getFields();
        for (Field field : fields){
            System.out.println(field);
        }
        System.out.println("--------------");

        //返回所有成员变量
        Field[] fields2 = classname.getDeclaredFields();

        for (Field field : fields2){
            System.out.println(field);
        }
        System.out.println("--------------");

        //返回单个公共成员变量
        Field address = classname.getField("address");
        System.out.println(address);
        System.out.println("--------------");

        //返回单个成员变量
        Field name = classname.getDeclaredField("name");
        System.out.println(name);
        System.out.println("--------------");

        Field age = classname.getDeclaredField("age");
        System.out.println(age);
        System.out.println("--------------");

        Constructor<?> con = classname.getConstructor();
        Object obj = con.newInstance();

        //给obj对象赋值
        name.setAccessible(true);
        name.set(obj,"周淼柯");
        System.out.println(obj);

        System.out.println("--------------");

        age.setAccessible(true);
        age.set(obj,20);
        System.out.println(obj);

        System.out.println("--------------");

        address.set(obj,"西湖");
        System.out.println(obj);
    }
}
