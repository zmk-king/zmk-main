package com.itheima_01;

import com.itheima_03.MyService;

import java.util.ServiceLoader;

public class Test_02 {
    public static void main(String[] args) {
        ServiceLoader<MyService> load = ServiceLoader.load(MyService.class);
        
        for (MyService my : load){
            my.service();
        }
    }
}
