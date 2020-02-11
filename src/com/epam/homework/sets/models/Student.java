package com.epam.homework.sets.models;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String fullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Student student) {
        int diff = age - student.age;
        if (diff != 0) {
            return diff;
        } else {
            return fullName().compareTo(student.fullName());
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + age;
    }
}
