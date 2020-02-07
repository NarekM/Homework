package com.epam.homework.sets;


import com.epam.homework.sets.models.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        testStudents();
        System.out.println("===================Coffee tests====================");
        testCoffee();
        System.out.println("===================Glasses tests====================");
        testGlasses();
    }

    private static void testStudents() {
        CustomTreeSet<Student> students = new CustomTreeSet<>();
        Student[] studentsArr = DummyDataInitializer.initStudentArray();
        for (Student student : studentsArr) {
            students.add(student);
        }
        System.out.println("Students added");
        System.out.println("Size is: " + students.getSize());
        printItems(students);

        students.remove(new Student("Alexander", "Anderson", 17));
        students.remove(new Student("Simon", "Whitaker", 18));
        System.out.println("----Alexander Anderson  and Simon should be deleted-----");
        System.out.println("Size is: " + students.getSize());
        printItems(students);
        System.out.println("contains John Doe: " + students.contains(new Student("John", "Doe", 16)));
        System.out.println("contains Alexander Anderson: " + students.contains(new Student("Alexander", "Anderson", 16)));
    }

    private static void testCoffee() {
        CustomTreeSet<Coffee> coffeeSet = new CustomTreeSet<>();
        Coffee[] coffeeArr = DummyDataInitializer.initCoffeeArray();
        for (Coffee coffee : coffeeArr) {
            coffeeSet.add(coffee);
        }
        System.out.println("Coffees added");
        System.out.println("Size is: " + coffeeSet.getSize());
        printItems(coffeeSet);

        coffeeSet.remove(new Coffee(CoffeeType.CAFE_LATTE, 3.3));
        coffeeSet.remove(new Coffee(CoffeeType.FLAT_WHITE, 3.9));
        System.out.println("----CAFE_LATTE  and FLAT_WHITE should be deleted-----");
        System.out.println("Size is: " + coffeeSet.getSize());
        printItems(coffeeSet);
        System.out.println("contains Cafe Latte: " + coffeeSet.contains(new Coffee(CoffeeType.LONG_BLACK, 6.8)));
        System.out.println("contains Flat White: " + coffeeSet.contains(new Coffee(CoffeeType.FLAT_WHITE, 3.9)));
    }

    private static void testGlasses() {
        CustomTreeSet<Glasses> glassesSet = new CustomTreeSet<>();
        Glasses[] glassesArray = DummyDataInitializer.initGlassesArray();
        for (Glasses glasses : glassesArray) {
            glassesSet.add(glasses);
        }
        System.out.println("Glasses added");
        System.out.println("Size is: " + glassesSet.getSize());
        printItems(glassesSet);

        glassesSet.remove(new Glasses(GlassesType.SAFETY, 47.9));
        glassesSet.remove(new Glasses(GlassesType.SUNGLASSES, 18.3));
        System.out.println("----Safety 47.9  and Sunglasses 18.3 should be deleted-----");
        System.out.println("Size is: " + glassesSet.getSize());
        printItems(glassesSet);
        System.out.println("contains Cafe Latte: " + glassesSet.contains(new Glasses(GlassesType.SUNGLASSES, 18.3)));
        System.out.println("contains Flat White: " + glassesSet.contains(new Glasses(GlassesType.CORRECTIVE, 29.9)));
    }


    private static <T extends Comparable<T>> void printItems(CustomTreeSet<T> set) {
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString() + " ");
        }
    }

}
