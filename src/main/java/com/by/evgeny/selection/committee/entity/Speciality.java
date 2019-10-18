package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.person.Enrolle;

public class Speciality {

    private String name;
    private String facultyName;
    //private int paidPlaces;
    //private int freePlaces;
    private int places;
    private int code;
    private String[] requiredSubjects;

    private Enrollees enrolled;
    //private ArrayList<Enrolle> enrolled;
    //private ArrayList<ArrayList<Student>> groups;
    //private ArrayList<Student> students;

    public Speciality(String name, String facultyName, int places, String[] requiredSubjects, int code) {
        this.name = name;
        this.facultyName = facultyName;
        this.places = places;
        this.requiredSubjects = requiredSubjects;
        enrolled = new Enrollees();
        //students = new ArrayList<Student>();

        this.code = code;
    }

    /*public boolean AddStudent(Student student){
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

    }*/

    public boolean Enrolle(Enrolle en){
        if(enrolled.getEnrollees().size() < places)
        {
            enrolled.add(en);
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

    /*public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }*/

    public Enrollees getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Enrollees enrolled) {
        this.enrolled = enrolled;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(facultyName + " " + name + System.lineSeparator()
                + "Code: " + code + System.lineSeparator()
                + "Places: " + places + System.lineSeparator()
                + "Required subjects: ");
        if(requiredSubjects.length > 0)
            result.append(requiredSubjects[0]);
        for (int i = 1; i < requiredSubjects.length; i++) {
            result.append(", ").append(requiredSubjects[i]);
        }
        result.append(System.lineSeparator()).append("Enrolled: ").append(enrolled.getEnrollees().size());
        return result.toString();
    }
}
