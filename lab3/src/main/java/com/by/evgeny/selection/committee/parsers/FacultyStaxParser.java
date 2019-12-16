package com.by.evgeny.selection.committee.parsers;

import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.exceptions.DataSourceException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class FacultyStaxParser implements XmlParser<Faculty> {

    enum FacultyTag {
        FACULTIES, FACULTY, FACULTY_NAME, FACULTY_ID;
    }

    private XMLStreamReader reader;
    private ArrayList<Faculty> faculties;

    @Override
    public ArrayList<Faculty> getDataFromFile(String filePath) throws DataSourceException {
        XMLInputFactory xmlInputFactory;
        xmlInputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            reader = xmlInputFactory.createXMLStreamReader(inputStream);
            parse();
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new DataSourceException(e.getMessage());
        }
        return faculties;
    }

    private void parse() throws XMLStreamException {
        FacultyTag tag = null;
        Faculty faculty = null;
        int staxEvent;
        while (reader.hasNext()) {
            staxEvent = reader.next();
            switch (staxEvent) {
                case XMLEvent.START_ELEMENT:
                    try {
                        String tagName = reader.getLocalName().toUpperCase().replace("-", "_");
                        tag = FacultyTag.valueOf(tagName);
                        switch (tag) {
                            case FACULTIES:
                                faculties = new ArrayList<>();
                                break;
                            case FACULTY:
                                faculty = new Faculty();
                                break;
                        }
                    } catch (Exception e) {
                        tag = null;
                    }
                    break;
                case XMLEvent.CHARACTERS:
                    String text = reader.getText();
                    if (text.trim().isEmpty())
                        break;
                    if ((faculty != null) && (tag != null)) {
                        switch (tag) {
                            case FACULTY_NAME:
                                faculty.setName(text);
                                break;
                            case FACULTY_ID:
                                faculty.setId(Integer.parseInt(text));
                                break;
                        }
                    }
                    break;
                case XMLEvent.END_ELEMENT:
                    try {
                        if (FacultyTag.valueOf(reader.getLocalName().toUpperCase().replace("-", "_")) == FacultyTag.FACULTY) {
                            faculties.add(faculty);
                            faculty = null;
                        }
                    } catch (Exception e) {
                    }
                    break;
            }
        }
    }
}
