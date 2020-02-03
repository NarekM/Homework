package com.epam.homework.lists;

public class StudentNode {
    private Student item;
    private StudentNode previous;
    private StudentNode next;

    public StudentNode(Student item, StudentNode previous, StudentNode next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public Student getItem() {
        return item;
    }

    public void setItem(Student item) {
        this.item = item;
    }

    public StudentNode getPrevious() {
        return previous;
    }

    public void setPrevious(StudentNode previous) {
        this.previous = previous;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}
