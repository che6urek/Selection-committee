package Entity;

import Entity.Person.Student;

import java.util.ArrayList;

public class Speciality {

    /* TODO Add groups
    *       Add free and paid places
    *       implement CRUD*/

    private String name;
    private String facultyName;
    //private int paidPlaces;
    //private int freePlaces;
    private int places;
    private int code;
    private String[] requiredSubjects;

    //private ArrayList<ArrayList<Student>> groups;
    private ArrayList<Student> students;

    public Speciality(String name, String facultyName, int places, String[] requiredSubjects, int code) {
        this.name = name;
        this.facultyName = facultyName;
        this.places = places;
        this.requiredSubjects = requiredSubjects;
        students = new ArrayList<Student>();
        this.code = code;
    }

    public boolean AddStudent(Student student){
        if(students.size() < places)
        {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean AddStudent(ArrayList<Student> enrolledStudents)
    {
        if(enrolledStudents.size() + students.size() < places)
        {
            students.addAll(enrolledStudents);
            return true;
        }
        return false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String[] getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(String[] requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
