package com.dfbz.sys.test;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 10:06
 * @description
 */
public class Student {

    private String name;
    private Integer age;

    private void run() {
        System.out.println("run");
    }

    private void run(String name) {
        System.out.println(name + ":run");
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
