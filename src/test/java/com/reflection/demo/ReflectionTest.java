package com.reflection.demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    /**
     * 使用反射获取一个类
     */
    @Test
    public void getClassTest() throws IllegalAccessException, InstantiationException {
//        Student student = new Student();
//        Class studentClass = student.getClass();
        Class studentClass = Student.class;

        System.out.println("对象.getClass" + studentClass);
        Student student = (Student) studentClass.newInstance();
        System.out.println("类.class" + Student.class);
        try {
            System.out.println("Class.forName()" + Class.forName("com.reflection.demo.Student"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * newInstance()创建实例
     */
    @Test
    public void newInstanceTest() {
        Class cl = Student.class;
        System.out.println(cl);

        try {
            Student student = (Student) cl.newInstance();
            System.out.println("studentl: " + student.toString());
        } catch (InstantiationException e) {
//            当试图通过newInstance()方法创建某个类的实例,而该类是一个抽象类或接口时,抛出该异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            安全权限异常，由于java在反射时调用了private方法所导致的
            e.printStackTrace();
        }

    }

    /**
     * 获取成员变量、成员方法、构造器
     */
    @Test
    public void getSomething() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl = Student.class;

        try {
            Constructor constructor = cl.getDeclaredConstructor(new Class[]{Integer.class, String.class, Integer.class});
            Student student = (Student) constructor.newInstance(new Object[]{1, "45", 1});
            System.out.println(student.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



        Field[] fields = cl.getFields();
        cl.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        Constructor[] constructors = cl.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }
    }

    /**
     * 分析一个类
     */
    @Test
    public void analysisClassTest() {
        ReflectionDemo reflectionDemo = new ReflectionDemo();

        Class cl = null;
        try {
            cl = Class.forName("com.reflection.demo.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        reflectionDemo.analysisClassTest(cl);
    }

    /**
     * invoke
     */
    @Test
    public void methodInvokeTest() {
        Student student = new Student(1, "小猪佩奇", 3);

        Class cl = student.getClass();

        Method f = null;
        try {
//            f = cl.getMethod("getName");

            f = cl.getDeclaredMethod("getStatic");
            f.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
//            String name = (String) f.invoke(student);
//            System.out.println(name);

            f.invoke(student);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
