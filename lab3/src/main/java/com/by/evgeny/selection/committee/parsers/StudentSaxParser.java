package com.by.evgeny.selection.committee.parsers;

import com.by.evgeny.selection.committee.entity.person.Gender;
import com.by.evgeny.selection.committee.entity.person.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class StudentSaxParser extends DefaultHandler {
    enum StudentTag {
        STUDENTS, STUDENT, STUDENT_TICKET_NO, STUDENT_TOTAL_MARK,
        STUDENT_NAME, STUDENT_SURNAME, STUDENT_PATRONYMIC, STUDENT_SPECIALITY_ID, STUDENT_GENDER;
    }

    private ArrayList<Student> students;
    private Student student;
    private StringBuilder input;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        input = new StringBuilder();
        if (qName.toUpperCase().equals(StudentTag.STUDENTS.toString())) {
            students = new ArrayList<Student>();
        }
        if ((students != null) && (qName.toUpperCase().equals(StudentTag.STUDENT.toString()))) {
            student = new Student();
            student.setPersonalData(new PersonalData());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        input.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            StudentTag tagName = StudentTag.valueOf(qName.toUpperCase().replace("-", "_"));
            switch (tagName) {
                case STUDENT_TICKET_NO:
                    student.setTicketNo(Integer.parseInt(input.toString()));
                    break;
                case STUDENT_TOTAL_MARK:
                    student.setTotalMark(Integer.parseInt(input.toString()));
                    break;
                case STUDENT_SPECIALITY_ID:
                    student.setSpecialtyId(Integer.parseInt(input.toString()));
                    break;
                case STUDENT_NAME:
                    student.getPersonalData().setName(input.toString());
                    break;
                case STUDENT_SURNAME:
                    student.getPersonalData().setSurname(input.toString());
                    break;
                case STUDENT_PATRONYMIC:
                    student.getPersonalData().setPatronymic(input.toString());
                    break;
                case STUDENT_GENDER:
                    student.getPersonalData().setGender(Gender.valueOf(input.toString()));
                    break;
                case STUDENT:
                    students.add(student);
                    student = null;
                    break;
            }
        } catch (Exception e) {
        }

    }
}
