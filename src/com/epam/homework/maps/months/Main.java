package com.epam.homework.maps.months;

import com.epam.homework.helpers.Helper;

public class Main {
    public static void main(String[] args) {
        typeMonthHolidays(Month.APRIL);
        typeDaysCount(Month.MARCH);
        typeAllMonthsNames();
        typeIsHoliday(Month.MARCH,21);
        typeIsHoliday(Month.MARCH,8);
        System.out.println(Month.MAY.numberOfHolidays());
    }

    private static void typeMonthHolidays(Month month) {
        StringBuilder message;
        int[] holidays = month.getHolidays();
        if (holidays.length < 1) {
            message = new StringBuilder("No holidays in " + Helper.capitalizeFirstLetter(month.toString()));
        } else {
            message = new StringBuilder("Holidays in " + month + ": " + holidays[0]);
            for (int i = 1; i < holidays.length; i++) {
                message.append(", " + holidays[i]);
            }
        }
        System.out.println(message);
    }

    private static void typeAllMonthsNames() {
        for (Month month : Month.values()) {
            System.out.print(month + " ");
        }
        System.out.println();
    }

    private static void typeIsHoliday(Month month, int day){
        System.out.println(Helper.capitalizeFirstLetter(month.toString()) + " " + day + " is holiday: " + month.isHoliday(day));
    }

    private static void typeDaysCount(Month month){
        System.out.println("Days in " + Helper.capitalizeFirstLetter(month.toString()) + ": " + month.getNumberOfDays());
    }
}
