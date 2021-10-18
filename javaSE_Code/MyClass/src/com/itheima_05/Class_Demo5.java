package com.itheima_05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Class_Demo5 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Class<? extends ArrayList> listClass = arrayList.getClass();

        Method m = listClass.getMethod("add", Object.class);

        //这里对象为arralist，这里实际调用的是arraylist的成员方法add
        m.invoke(arrayList,"hallo");
        m.invoke(arrayList,"word");
        m.invoke(arrayList,"java");

        System.out.println(arrayList);

    }
}
