package com.epam.homework.sets;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class CustomSet<T extends Comparable<T>> {
    private int size = 0;
    TreeMap<T, String> items;

    public CustomSet() {
        items = new TreeMap<>();
    }

    public void add() {

    }

    public void remove() {

    }

    public void contains() {

    }

    public int size() {
        return size;
    }
}
