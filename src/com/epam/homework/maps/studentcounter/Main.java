package com.epam.homework.maps.studentcounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> list = initStudentList();
        Counter counter = new Counter();
        System.out.println(counter.count(list));
        System.out.println(counter.countStudentsInFaculties(list));
    }

    private static List<Student> initStudentList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Diana", "Asatryan", 22, "0988111111", Faculty.MATH));
        list.add(new Student("Diana", "Asatryan", 32, "0922111111", Faculty.PHYSICS));
        list.add(new Student("Diana", "Asatryan", 21, "0938111111", Faculty.PHILOSOPHY));
        list.add(new Student("Karen", "Balayan", 12, "097777777", Faculty.MATH));
        list.add(new Student("Karen", "Balayan", 23, "098888811", Faculty.PHILOSOPHY));
        list.add(new Student("Elen", "Mirzoyan", 12, "093333333", Faculty.ENGLISH));
        return list;
    }
}
