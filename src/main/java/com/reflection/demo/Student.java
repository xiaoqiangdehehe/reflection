package com.reflection.demo;

public class Student {
    private Integer id = 0;
    private String name = "0000";
    private Integer age = 0;

//    public Student() {
//    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private void getStatic(){
        System.out.println("static");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student: Name: " + this.getName()
                + " id " + this.getId()
                + " age " + this.getAge();
    }
}
