package com.by.evgeny.selection.committee.utils;

public class DataValidator {

    private static final String WORDS_REGEX = "^[A-Za-zА-Яа-я]+([ ]?[A-Za-zА-Яа-я-]+)*$";
    private static final String NAME_REGEX = "^[A-Za-zА-Яа-я]+(([',. -])?[A-Za-zА-Яа-я]+)*$";

    private static Dictionary dictionary = new Dictionary();

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

    public static boolean checkCode(int code) {
        return code >= 100 && code <= 1000;
    }

    public static boolean checkPositive(int num) {
        return num >= 0;
    }

    public static boolean checkSubject(String subject) {
        if(dictionary != null)
            if(dictionary.getSubjects() != null)
                return dictionary.getSubjects().contains(subject);
        return false;
    }

    public static boolean checkSpeciality(String speciality) {
        if(dictionary != null)
            if(dictionary.getSpecialities() != null)
                return dictionary.getSpecialities().contains(speciality);
        return false;
    }

    public static boolean checkFaculty(String faculty) {
        if(dictionary != null)
            if(dictionary.getFaculties() != null)
                return dictionary.getFaculties().contains(faculty);
        return false;
    }

    public static Dictionary getDictionary() {
        return dictionary;
    }

    public static void setDictionary(Dictionary dictionary) {
        DataValidator.dictionary = dictionary;
    }
}
