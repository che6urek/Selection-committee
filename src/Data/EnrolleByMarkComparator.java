package Data;

import Entity.Person.Enrolle;

import java.util.Comparator;

public class EnrolleByMarkComparator implements Comparator<Enrolle> {
    @Override
    public int compare(Enrolle enrolle1, Enrolle enrolle2) {
        return enrolle1.getTotalMark() - enrolle2.getTotalMark();
    }
}