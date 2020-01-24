package com.epam.homework.lists;

public class StudentInitializer {
    private Student[] students = {
            new Student("John", "Doe", 16),
            new Student("Alexander", null, 18),
            new Student("Simon", "Miller", 20),
            new Student("Alexander", "Anderson", 17),
            new Student("Tim", "Jameson", 19),
            new Student("Simon", "Whitaker", 18),
            new Student("Andrew", "Johnson", 17),
    };

    public StudentInitializer() {
    }

    public StudentInitializer(Student[] students) {
        if (students != null) {
            this.students = students;
        }
    }

    public Student[] initStudentArray() {
        return students.clone();
    }

    public StudentList initStudentList() {
        StudentList studentList = new StudentList();
        for (Student student : students) {
            studentList.add(student);
        }
        return studentList;
    }

    public StudentLinkedList initStudentLinkedList() {
        StudentLinkedList studentList = new StudentLinkedList();
        for (Student student : students) {
            studentList.addLast(student);
        }
        return studentList;
    }

    public void printFirstAndLast(){
        for (Student student : students) {
            System.out.println(String.format("firstname: %s, lastname: %s",student.getFirstName(), student.getLastName()));
        }
    }
}
