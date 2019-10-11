package Entity;

import java.util.ArrayList;

//TODO implement CRUD

public class Specialities{

    private ArrayList<Speciality> specialities;

    public Specialities () {
        specialities = new ArrayList<Speciality>();
        //TODO fill list from file
    }

    public void add(Speciality speciality) {
        specialities.add(speciality);
    }

    public void update(String Name, Speciality newSpeciality) {
        for (int i = 0; i < specialities.size(); i++) {
            if(specialities.get(i).getName() == Name) {
                specialities.set(i, newSpeciality);
                break;
            }
        }
    }

    public void delete(Speciality speciality) {
        specialities.remove(speciality);
    }

    public void deleteByName(String name) {

    }

    public void Enroll(){
        //TODO enroll enrollees to specialities

        /*sort enrollees list by total score,
        go throw list and enroll to corresponding specialities (check subjects matching) until there are places*/

    }

}
