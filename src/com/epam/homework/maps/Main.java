package com.epam.homework.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Diana", "Asatryan", 22, "0988111111", Faculty.MATH);
        Student student2 = new Student("Diana", "Asatryan", 32, "0922111111", Faculty.PHYSICS);
        Student student3 = new Student("Diana", "Asatryan", 21, "0938111111", Faculty.PHILOSOPHY);
        Student student4 = new Student("Karen", "Balayan", 12, "097777777", Faculty.MATH);
        Student student5 = new Student("Karen", "Balayan", 23, "098888811", Faculty.PHILOSOPHY);
        Student student6 = new Student("Elen", "Mirzoyan", 12, "093333333", Faculty.ENGLISH);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        Counter counter = new Counter();
        Map<Student, Integer> countMap = counter.count(list);
        System.out.println("countMap = " + countMap);
        list.add(new Student("Karen", "Balayan", 49, "094588225", Faculty.PHYSICS));
        countMap = counter.count(list);
        System.out.println("countMap = " + countMap);
        System.out.println("get = " + countMap.get(new Student("Diana", "Asatryan", 18, "094588375", Faculty.ENGLISH)));

        System.out.println(counter.countStudentsInFaculties(list));
        list.add(new Student("Karen", "Balayan", 4, "094388225", Faculty.PHYSICS));
        list.add(new Student("John", "Smith", 5, "094584525", Faculty.PHYSICS));
        list.add(new Student("Diana", "Asatryan", 7, "093188375", Faculty.ENGLISH));
        list.add(new Student("Artak", "Aramyan", 9, "094583025", Faculty.PHILOSOPHY));
        System.out.println(counter.countStudentsInFaculties(list));


    }
}
