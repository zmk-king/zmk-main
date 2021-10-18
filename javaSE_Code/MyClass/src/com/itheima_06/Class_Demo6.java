package com.itheima_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Class_Demo6 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("MyClass\\Class.txt");

        prop.load(fr);

        fr.close();

        String name = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //获取class类型的对象
        Class<?> aClass = Class.forName(name);

        //根据无参构造方法创建对象，这里的对象是我们所需要的的类的对象
        //相当于Student s = new Student（）
        Constructor<?> con = aClass.getConstructor();
        Object obj = con.newInstance();

        //获取(Student)对象的里面的方法(study)
        Method method = aClass.getMethod(methodName);

        //根据(Student)对象调用(study)方法
        method.invoke(obj);
    }
}
