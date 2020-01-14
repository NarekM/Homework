package com.epam.homework.university.models;

import com.epam.homework.university.Helper;

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
        this.students = students;
    }

    public void addStudent(Student student){
        validateGroup();
        students = (Student[]) (Helper.extendArray(students, student));
    }

    private void validateGroup(){
        if (students == null || students.length == 0){
            throw new RuntimeException("Group must have at lease one student");
        }
    }
//    private Student[] extendArray(Student[] students, Student student){
//        Student[] temp = new Student[students.length + 1];
//        for (int i = 0; i < temp.length-1; i++) {
//            temp[i] = students[i];
//        }
//        temp[students.length] = student;
//        return temp;
//    }

    public double getAverageScoreBySubject(String subject){
        double total = 0;
        for (Student student : students) {
            total += student.getScoreBySubject(subject);
        }
        return Double.parseDouble(new DecimalFormat("#.##").format(((double) total)/students.length));
    }
}
