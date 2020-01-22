package com.epam.homework.lists;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int order = o1.getFirstName().compareTo(o2.getFirstName());
        if (order == 0){
            order = o2.getAge() - o1.getAge();
        }
        return order;
    }
}
