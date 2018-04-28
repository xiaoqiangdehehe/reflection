package com.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 利用反射分析类
 */
public class ReflectionDemo {

    public void analysisClassTest(Class cl) {

        Class supercl = cl.getSuperclass(); //获取父类

        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " "); //访问权限
        }

        System.out.print(cl.getName()); //类名

        if (supercl != null && supercl != Object.class) {
            System.out.print(" extends " + supercl.getName()); //继承
        }

        System.out.print("{\n");
        printConstructors(cl);
        System.out.println();
        printMethod(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    /**
     * 分析构造器
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 分析成员方法
     * @param cl
     */
    public static void printMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();

        for(Method m: methods){
            Class reType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");

            String modifires = Modifier.toString(m.getModifiers());
            if(modifires.length() > 0){
                System.out.print(modifires + " ");
            }
            System.out.print(reType.getName() + " " + name + "(");

            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j< paramTypes.length; j++){
                if(j>0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();

        for(Field f:fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
