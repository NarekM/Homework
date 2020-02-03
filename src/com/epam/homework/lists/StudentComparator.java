package com.epam.homework.lists;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        int order = student1.getFirstName().compareTo(student2.getFirstName());
        if (order == 0){
            order = student2.getAge() - student1.getAge();
        }
        return order;
    }
}
