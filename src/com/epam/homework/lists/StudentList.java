package com.epam.homework.lists;

import java.util.Iterator;

public class StudentList implements Iterable<Student> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;

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

    public void add(Student student) {
        ensureCapacity();
        students[size] = student;
        size++;
    }

    public void remove(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
                if (i == students.length - 1) {
                    students[i] = null;
                    size--;
                } else {
                    removeFromStudents(i);
                }
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public Student get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return students[index];
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

    private void removeFromStudents(int index) {
        for (int i = index; i < size - 1; i++) {
            students[i] = students[i + 1];
        }
        students[--size] = null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            str = str.append(students[i] + ", ");
        }
        str.append((size > 0 ? students[size - 1] : "") + "]");
        return str.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Student next() {
                return students[current++];
            }
        };
    }
}
