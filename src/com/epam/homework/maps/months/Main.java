package com.epam.homework.maps.months;

public class Main {
    public static void main(String[] args) {
        int[] holidays = Month.DECEMBER.getHolidays();
        holidays[0] = 90;
        System.out.println("Month.DECEMBER.getHolidays()[0] = " + Month.DECEMBER.getHolidays()[0]);

//        for (Month month : Month.values()) {
//            System.out.println(month);
//        }
        Month.type();
    }
}
