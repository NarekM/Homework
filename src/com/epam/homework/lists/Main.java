package com.epam.homework.lists;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Student st1 = new Student("John", "Doe", 16);
        Student st2 = new Student("Alexander", "Gates", 18);
        Student st3 = new Student("Simon", "Miller", 20);
        Student st4 = new Student("Alexander", "Anderson", 17);
        Student st5 = new Student("Tim", "Jameson", 19);
        Student st6 = new Student("Simon", "Whitaker", 18);
        Student st7 = new Student("Andrew", "Johnson", 17);

        //1st task
        List<Student> students = new ArrayList<Student>(){{
            add(st1);
            add(st2);
            add(st3);
            add(st4);
            add(st5);
            add(st6);
            add(st7);
        }};

        System.out.println(students);

        Collections.sort(students, new StudentComparator());

        System.out.println(students);


        //2nd task
        Student[] stArr = new Student[]{st1,st2,st3,st4,st5,st6,st7};
        Collections.sort(Arrays.asList(stArr));
        System.out.println(Arrays.toString(stArr));
        LinkedList<Student> studentList = new LinkedList<Student>(Arrays.asList(stArr));
        System.out.println(studentList);



    }
}
