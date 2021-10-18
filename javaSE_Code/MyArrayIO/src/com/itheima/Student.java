package com.itheima;

public class Student {
    private String avg;
    private String name;
    private String age;
    private String address;

    public Student() {
    }

    public Student(String avg, String name, String age, String address) {
        this.avg = avg;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
