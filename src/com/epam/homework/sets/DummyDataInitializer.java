package com.epam.homework.sets;

import com.epam.homework.sets.models.*;

public class DummyDataInitializer {
    public static Student[] initStudentArray() {
        return new Student[]{
                new Student("John", "Doe", 16),
                new Student("Alexander", "Gates", 18),
                new Student("Simon", "Miller", 20),
                new Student("Simon", "Miller", 20),
                new Student("Alexander", "Anderson", 17),
                new Student("Tim", "Jameson", 19),
                new Student("Tim", "Jameson", 19),
                new Student("Simon", "Whitaker", 18),
                new Student("Andrew", "Johnson", 17)
        };
    }

    public static Coffee[] initCoffeeArray() {
        return new Coffee[]{
                new Coffee(CoffeeType.CAFE_LATTE, 3.3),
                new Coffee(CoffeeType.ESPRESSO, 5.13),
                new Coffee(CoffeeType.CAPPUCCINO, 3.8),
                new Coffee(CoffeeType.IRISH_COFFEE, 4.5),
                new Coffee(CoffeeType.LONG_BLACK, 6.8),
                new Coffee(CoffeeType.FLAT_WHITE, 3.9),
                new Coffee(CoffeeType.MACCHIATO, 7.1),
                new Coffee(CoffeeType.CAFFE_AMERICANO, 5.4)
        };
    }

    public static Glasses[] initGlassesArray() {
        return new Glasses[]{
                new Glasses(GlassesType.SUNGLASSES, 52),
                new Glasses(GlassesType.SAFETY, 47.9),
                new Glasses(GlassesType.CORRECTIVE, 25.1),
                new Glasses(GlassesType.CORRECTIVE, 34.4),
                new Glasses(GlassesType.SUNGLASSES, 18.3),
                new Glasses(GlassesType.SAFETY, 115),
                new Glasses(GlassesType.CORRECTIVE, 29.9),
                new Glasses(GlassesType.SUNGLASSES, 35)
        };
    }
}
