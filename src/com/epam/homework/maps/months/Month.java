package com.epam.homework.maps.months;

public enum Month {
//    JANUARY(31, new int[]{1, 6, 28}),
//    FEBRUARY(28),
//    MARCH(31, new int[]{8}),
//    APRIL(30, new int[]{24}),
//    MAY(31, new int[]{1, 9, 28}),
//    JUNE(30),
//    JULY(31,new int[]{5}),
//    AUGUST(31),
//    SEPTEMBER(30,new int[]{21}),
//    OCTOBER(31),
//    NOVEMBER(30),
//    DECEMBER(31,new int[]{31});
    JANUARY(31, 1, 6, 28),
    FEBRUARY(28),
    MARCH(31, 8),
    APRIL(30, 24),
    MAY(31, 1, 9, 28),
    JUNE(30),
    JULY(31,5),
    AUGUST(31),
    SEPTEMBER(30,21),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31,31);
    private final int numberOfDays;
    private final int[] holidays;

    Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        holidays = new int[0];
    }
    Month(int numberOfDays, int ...holidays) {
        this.numberOfDays = numberOfDays;
        this.holidays = holidays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int[] getHolidays() {
        return holidays.clone();
    }

    public boolean isHoliday(int day){
        for (int holiday : holidays) {
            if (holiday == day){
                return true;
            }
        }
        return false;
    }

    public int numberOfHolidays(){
        return holidays.length;
    }

    public static void type(){
        for (Month month : values()) {
            System.out.println(month);
        }
    }
}
