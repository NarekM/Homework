package com.epam.homework.lists;

public class StudentList {
    private int capacity;

    private int size;

    private int[] students;

    public StudentList() {
        capacity = 10;
    }

    public StudentList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Illegal capacity: "+ capacity);
        }
        this.capacity = capacity;
    }

    public boolean add(Student s){
        return true;
    }

    public boolean remove(Student s){
        return true;
    }

    public int size(){
        return size;
    }

    public Student get(int index){
        return null;
    }
}
