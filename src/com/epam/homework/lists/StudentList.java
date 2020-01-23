package com.epam.homework.lists;

public class StudentList {
    private final int DEFAULT_CAPACITY = 10;

    private int size = 0;

    //todo this method is for testing, it should be deleted
    public int getCap() {
        return students.length;
    }

    private Student[] students;

    public StudentList() {
        students = new Student[DEFAULT_CAPACITY];
    }

    public StudentList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);

        }
        students = new Student[capacity];
    }

    public void add(Student s) {
        ensureCapacity();
        students[size] = s;
        size++;
    }

    public void remove(Student s) {

    }

    public int size() {
        return size;
    }

    //todo finish this method
    public Student get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return null;
    }

    private void extendStudents() {
        Student[] newStudents = new Student[students.length + students.length / 2 + 1];
        for (int i = 0; i < size; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
    }

    private void ensureCapacity() {
        if (students.length == size) {
            extendStudents();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            str = str.append(students[i] + ", ");
        }
        str.append(students[size - 1] + "]");
        return str.toString();
    }
}
