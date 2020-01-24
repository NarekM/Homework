package com.epam.homework.lists;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StudentInitializer initializer = new StudentInitializer();

        Student[] stArr = initializer.initStudentArray();


        //1st task
//        List<Student> students = new ArrayList<Student>(Arrays.asList(stArr));
//
//        System.out.println(students);
//
//        Collections.sort(students, new StudentComparator());
//
//        System.out.println(students);


        //2nd task
//        LinkedList<Student> studentLinkedList = new LinkedList<>(Arrays.asList(stArr));
//        System.out.println(studentLinkedList);
//        Collections.sort(studentLinkedList);
//        System.out.println(studentLinkedList);

        //3rd task
//        StudentList stList = initializer.initStudentList();
//        System.out.println("stList.size() = " + stList.size());
//        for(int i = 0; i < stList.size(); i++){
//            System.out.println("stList.get("+i+") = " + stList.get(i));
//        }
//        for(int i = stList.size() - 1; i >= 0; i--){
//            stList.remove(stList.get(i));
//            System.out.println(stList);
//        }

        //4th task
//        StudentLinkedList list = initializer.initStudentLinkedList();
//        System.out.println(list);
        initializer.printFirstAndLast();
    }
}
