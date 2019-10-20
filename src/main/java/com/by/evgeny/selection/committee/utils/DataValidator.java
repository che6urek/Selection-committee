package com.by.evgeny.selection.committee.utils;

public class DataValidator {

    private static final String WORDS_REGEX = "^[A-Za-zА-Яа-я]+([ ]?[A-Za-zА-Яа-я-]+)*$";
    private static final String NAME_REGEX = "^[A-Za-zА-Яа-я]+(([',. -])?[A-Za-zА-Яа-я]+)*$";

    public static boolean checkWords(String words) {
        return words != null && words.matches(WORDS_REGEX);
    }

    public static boolean checkName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public static boolean checkMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    public static boolean checkSchoolMark(int mark) {
        return mark >= 0 && mark <= 10;
    }

    public static boolean checkPositive(int num) {
        return num >= 0;
    }
}
