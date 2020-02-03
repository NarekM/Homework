package com.epam.homework.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentLinkedList implements Iterable<Student> {
    private int size = 0;
    private StudentNode first;
    private StudentNode last;

    public StudentLinkedList() {
    }

    public void push(Student student) {
        StudentNode studentNode = new StudentNode(student, null, first);
        if (size == 0){
            last = studentNode;
        } else {
            first.setPrevious(studentNode);
        }
        first = studentNode;
        size++;
    }

    public Student pop() {
        Student deletedStudent = null;
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            deletedStudent = first.getItem();
            first = last = null;
        } else {
            deletedStudent = first.getItem();
            first = first.getNext();
            first.setPrevious(null);
        }
        size--;
        return deletedStudent;
    }

    public void addLast(Student student) {
        if (size == 0) {
            first = last = new StudentNode(student, null, null);
        } else {
            last.setNext(new StudentNode(student, last, null));
            last = last.getNext();
        }
        size++;
    }

    public Student removeLast() {
        Student student = null;
        if (size < 2){
            return pop();
        } else {
            student = last.getItem();
            last = last.getPrevious();
        }
        size--;
        return student;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        StudentNode currentNode = first;
        for (int i = 0; i < size - 1; i++) {
            str = str.append(currentNode.getItem() + ", ");
            currentNode = currentNode.getNext();
        }
        str.append((size > 0 ? last.getItem() : "") + "]");
        return str.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            private StudentNode current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Student next() {
                Student student = current.getItem();
                current = current.getNext();
                return student;
            }
        };
    }
}
