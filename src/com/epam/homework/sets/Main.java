package com.epam.homework.sets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        TreeSet<String> set = new TreeSet<>();
//        set.add(null);
//        set.contains(null);
//        TreeMap<String, String> map = new TreeMap<>();
//        map.put(null, "box");
//        System.out.println("map.get(null) = " + map.get(null));

//        CustomTree<String> set = new CustomTree<>();
//        set.add("Hello");
//        set.add("world");
//        set.add("another");
//        set.add("text");
        CustomTree<Integer> set = new CustomTree<>();
        set.add(8);
        set.add(10);
        set.add(5);
        set.add(30);
        set.add(3);
        set.add(11);
//        System.out.println(set);
//        System.out.println("set.contains(\"world\") = " + set.contains("text"));
//        set.traverse();

//        for (Integer integer : set) {
//            System.out.println(integer);
//        }
        set.remove(8);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "    ");
        }
    }
}
