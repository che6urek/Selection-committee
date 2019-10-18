package Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataValidator {

    private static ArrayList<String> subjects = ReadFile("subjects.txt");
    private static ArrayList<String> specialities = ReadFile("specialities.txt");
    private static ArrayList<String> faculties = ReadFile("faculties.txt");
    private static final String WORD_REGEX = "[A-Za-zА-Яа-я]+";
    private static final String NAME_REGEX = "[A-Za-zА-Яа-я]+(([',. -])?[A-Za-zА-Яа-я]+)*$";

    public static ArrayList<String> ReadFile(String fileName)
    {
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get("Dictionaries/" + fileName));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<String>();
        }
    }

    public static boolean checkWord(String word) {
        return word != null && word.matches(WORD_REGEX);
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

    public static boolean checkSubject(String subject) {
        return subjects.contains(subject);
    }

    public static boolean checkSpeciality(String speciality) {
        return specialities.contains(speciality);
    }

    public static boolean checkFaculty(String faculty) {
        return faculties.contains(faculty);
    }

    public static void UpdateDictionaries() {
        subjects = ReadFile("subjects.txt");
        specialities = ReadFile("specialities.txt");
        faculties = ReadFile("faculties.txt");
    }

}
