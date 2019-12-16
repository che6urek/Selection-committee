package com.by.evgeny.selection.committee.parsers;

import com.by.evgeny.selection.committee.entity.person.Gender;
import com.by.evgeny.selection.committee.entity.person.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class EnrolleSaxParser extends DefaultHandler {
    enum EnrolleTag {
        ENROLLEES, ENROLLE, ENROLLE_SCHOOL_MARK, ENROLLE_CT_MARK, ENROLLE_NAME, ENROLLE_SURNAME,
        ENROLLE_PATRONYMIC, ENROLLE_SPECIALITY_ID, ENROLLE_GENDER, ENROLLE_MEDICAL_CLEARANCE;
    }

    private ArrayList<Enrolle> enrollees;
    private Enrolle enrolle;
    private StringBuilder input;
    private int markIndex = 0;

    public ArrayList<Enrolle> getEnrollees() {
        return enrollees;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        input = new StringBuilder();
        if (qName.toUpperCase().equals(EnrolleTag.ENROLLEES.toString())) {
            enrollees = new ArrayList<Enrolle>();
        }
        if ((enrollees != null) && (qName.toUpperCase().equals(EnrolleTag.ENROLLE.toString()))) {
            enrolle = new Enrolle();
            enrolle.setPersonalData(new PersonalData());
            enrolle.setCtMarks(new int[] {});
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        input.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            EnrolleTag tagName = EnrolleTag.valueOf(qName.toUpperCase().replace("-", "_"));
            switch (tagName) {
                case ENROLLE_SCHOOL_MARK:
                    enrolle.setSchoolMark(Integer.parseInt(input.toString()));
                    break;
                case ENROLLE_CT_MARK:
                    enrolle.getCtMarks()[markIndex++%3] = Integer.parseInt(input.toString());
                    break;
                case ENROLLE_SPECIALITY_ID:
                    enrolle.setSpecialtyId(Integer.parseInt(input.toString()));
                    break;
                case ENROLLE_NAME:
                    enrolle.getPersonalData().setName(input.toString());
                    break;
                case ENROLLE_SURNAME:
                    enrolle.getPersonalData().setSurname(input.toString());
                    break;
                case ENROLLE_PATRONYMIC:
                    enrolle.getPersonalData().setPatronymic(input.toString());
                    break;
                case ENROLLE_GENDER:
                    enrolle.getPersonalData().setGender(Gender.valueOf(input.toString()));
                    break;
                case ENROLLE_MEDICAL_CLEARANCE:
                    enrolle.setMedicalClearance(Boolean.parseBoolean(input.toString()));
                    break;
                case ENROLLE:
                    enrollees.add(enrolle);
                    enrolle = null;
                    break;
            }
        } catch (Exception e) {
        }

    }
}
