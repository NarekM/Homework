package com.epam.homework.university.models;

import com.epam.homework.helpers.Helper;

import java.text.DecimalFormat;

public class Group {
    private String name;
    private Student[] students;

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, Student[] students) {
        this.name = name;
        if (students == null || students.length == 0){
            throw new RuntimeException("Group must have at lease one student");
        }
        Helper.validateArray(students, "Group " + name + " must have at lease one student");
        this.students = students;
    }

    public void addStudent(Student student){
        Helper.validateArray(students, "Group " + name + " must have at lease one student");
        students = (Student[]) (Helper.extendArray(students, student));
    }

    public double getAverageScoreBySubject(String subject){
        double total = 0;
        for (Student student : students) {
            total += student.getScoreBySubject(subject);
        }
        return Double.parseDouble(new DecimalFormat("#.##").format(((double) total)/students.length));
    }
}
