package com.itheima;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("----欢迎来到学生管理系统----");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查看所有学生信息");
            System.out.println("5.退出");
            System.out.println("请输入你的选择:");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    removeStudent(array);
                    break;
                case "3":
                    setStudent(array);
                    break;
                case "4":
                    chaStudent(array);
                    break;
                case "5":
                    System.out.println("退出成功，谢谢使用!");
                    System.exit(0);
            }
        }
    }

    public static boolean offStudent(ArrayList<Student> array, String sid) {
        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /*
    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号:");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生住址:");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

        System.out.println("添加学生信息成功!");
    }
    */

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;

        while (true) {
            System.out.println("请输入学生学号:");
            sid = sc.nextLine();
            boolean flag = offStudent(array, sid);
            if (flag) {
                System.out.println("该学号已存在，请重新输入!");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生住址:");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

        System.out.println("添加学生信息成功!");
    }

    /*    public static void removeStudent(ArrayList<Student> array) {
            Scanner sc = new Scanner(System.in);
            int index = -1;

                System.out.println("请输入要删除的学生学号:");
                String sid = sc.nextLine();

            for (int i = 0;i< array.size();i++) {
                Student s = array.get(i);
                if (s.getSid().equals(sid)) {
                    index = i;
                    break;
                }
            }
            if (index == -1){
                System.out.println("该学号不存在，请重新输入!");
            }else {
                array.remove(index);
                System.out.println("删除学生信息成功!");
            }
        }*/

    public static void removeStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;

        while (true) {
            System.out.println("请输入要删除的学生学号:");
            sid = sc.nextLine();
            boolean flag = offStudent(array, sid);
            if (array.isEmpty()) {
                System.out.println("目前学生信息为空，无法删除，自动退出!");
                break;
            }
            if (flag == false) {
                System.out.println("该学号不存在，请重新输入!");
            } else {
                for (int i = 0; i < array.size(); i++) {
                    Student s = array.get(i);
                    if (s.getSid().equals(sid)) {
                        array.remove(i);
                        break;
                    }
                }
                System.out.println("删除学生信息成功!");
                break;
            }
        }
/*        for(int i = 0;i< array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                array.remove(i);
                break;
            }
        }
        System.out.println("删除学生信息成功!");*/
    }

    public static void setStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入要修改的学生学号:");
            String sid = sc.nextLine();
            boolean flag = offStudent(array, sid);

            if(array.isEmpty()){
                System.out.println("目前学生信息为空，无法修改，自动退出!");
                break;
            }
            if (flag == false) {
                System.out.println("该学生学号不存在，请重新输入!");
            } else {
                System.out.println("请输入要修改的学生名字:");
                String name = sc.nextLine();
                System.out.println("请输入要修改的学生年龄:");
                String age = sc.nextLine();
                System.out.println("请输入要修改的学生住址:");
                String address = sc.nextLine();

                Student s = new Student();
                s.setSid(sid);
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);

                for (int i = 0; i < array.size(); i++) {
                    Student student = array.get(i);
                    if (student.getSid().equals(sid)) {
                        array.set(i, s);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void chaStudent(ArrayList<Student> arry) {
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for (int i = 0; i < arry.size(); i++) {
            Student s = arry.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }
}
