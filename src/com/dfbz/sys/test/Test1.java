package com.dfbz.sys.test;

import java.lang.reflect.Method;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 10:06
 * @description
 */
public class Test1 {


    public static void main(String[] args) throws Exception {

        Student student = new Student();
//        student.run();

        Class clazz = Student.class;
        Class clazz2 = Class.forName("com.dfbz.sys.test.Student");
        Class clazz3 = student.getClass();

        Method method = clazz.getDeclaredMethod("run",String.class);
        method.setAccessible(true);
        method.invoke(student,"马云");

        clazz.getDeclaredConstructor();

        clazz.getDeclaredFields();


    }
}
