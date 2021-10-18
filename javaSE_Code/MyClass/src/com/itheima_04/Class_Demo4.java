package com.itheima_04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Class_Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classname = Class.forName("com.itheima.Student");

        //返回所有公共成员方法包括继承的
        Method[] method1 = classname.getMethods();
        for (Method method : method1){
            System.out.println(method);
        }
        System.out.println("----------------------------");

        //返回所有的成员方法，不包括继承的
        Method[] method2 = classname.getDeclaredMethods();
        for (Method method : method2){
            System.out.println(method);
        }
        System.out.println("----------------------------");

        //返回一个公共的成员方法
        Method method3 = classname.getMethod("method1");
        System.out.println(method3);
        System.out.println("----------------------------");

        //返回一个成员方法
        Method method4 = classname.getDeclaredMethod("function");
        System.out.println(method4);
        System.out.println("----------------------------");

        Constructor<?> con = classname.getConstructor();
        Object obj = con.newInstance();

        //调用obj对象的成员方法，参数是args，因为我们这里是无参构造方法所以没有参数，返回值是object类型
        method3.invoke(obj);

        Method method = classname.getMethod("method2", String.class);
        method.invoke(obj,"刘亦菲");

        Method method5 = classname.getMethod("method3", String.class, int.class);
        //成员方法metho3没有输出语句，是一个热汤语句，所以加个printfln输出
        Object o = method5.invoke(obj, "胡歌", 32);
        System.out.println(o);

        method4.setAccessible(true);
        method4.invoke(obj);
    }
}
