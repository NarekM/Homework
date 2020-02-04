package com.epam.homework.sets.models;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
