package com.epam.homework.sets;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add(null);
//        set.contains(null);
        TreeMap<String, String> map = new TreeMap<>();
        map.put(null, "box");
//        System.out.println("map.get(null) = " + map.get(null));
    }
}
