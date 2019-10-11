package Entity.CRUD;

import Entity.Person.Enrolle;

import java.util.ArrayList;
import java.util.Optional;

public class Enrollees implements CRUD<Enrolle>, java.io.Serializable {

    private ArrayList<Enrolle> enrollees;

    public Enrollees() {
        this.enrollees = new ArrayList<Enrolle>();
    }

    @Override
    public void add(Enrolle enrolle) {
        enrollees.add(enrolle);
    }

    @Override
    public Optional<Enrolle> getById(int id) {
        return this.enrollees.stream().filter(e -> e.getId() == id).findFirst();
    }

    //TODO replace loops with stream api
    @Override
    public void update(int id, Enrolle newEnrolle) {
        for (int i = 0; i < enrollees.size(); i++) {
            if(enrollees.get(i).getId() == id) {
                enrollees.set(i, newEnrolle);
                break;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (Enrolle enrolle: enrollees) {
            if(enrolle.getId() == id) {
                enrollees.remove(enrolle);
                break;
            }
        }
    }

    @Override
    public void delete(Enrolle enrolle) {
        enrollees.remove(enrolle);
    }

    public void setEnrollees(ArrayList<Enrolle> enrollees) {
        this.enrollees = enrollees;
    }

    public void setEnrolles(ArrayList<Enrolle> enrolless) {
        this.enrollees = enrolless;
    }

    public ArrayList<Enrolle> getEnrollees() {
        return enrollees;
    }
}
