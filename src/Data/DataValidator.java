package Data;

public class DataValidator {

    private static final String WORD_REGEX = "[A-Za-zА-Яа-я]+";
    private static final String NAME_REGEX = "[A-Za-zА-Яа-я]+(([',. -])?[A-Za-zА-Яа-я]+)*$";

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
}
