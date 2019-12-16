package com.by.evgeny.selection.committee;
import com.by.evgeny.selection.committee.exceptions.DataSourceException;
import com.by.evgeny.selection.committee.parsers.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Application {

    public static void main(String[] args) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/conf.properties")) {
            prop.load(input);
            String xmlDataFileName = prop.getProperty("data.xmlFileName");

            System.out.println("Faculties:");
            XmlParser parser = new FacultyStaxParser();
            parser.getDataFromFile(xmlDataFileName).forEach(x -> System.out.println(x.toString()
                    + System.lineSeparator()));

            System.out.println("Specialities:");
            parser = new SpecialityDomParser();
            parser.getDataFromFile(xmlDataFileName).forEach(x -> System.out.println(x.toString()
                    + System.lineSeparator()));

            System.out.println("Students:");
            var studentParser = new StudentSaxParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(studentParser);
            xmlReader.parse(new InputSource(xmlDataFileName));
            studentParser.getStudents().forEach(x -> System.out.println(x.toString() + System.lineSeparator()));

            System.out.println("Enrolles:");
            var enrolleParser = new EnrolleSaxParser();
            xmlReader.setContentHandler(enrolleParser);
            xmlReader.parse(new InputSource(xmlDataFileName));
            enrolleParser.getEnrollees().forEach(x -> System.out.println(x.toString() + System.lineSeparator()));

        } catch (IOException | DataSourceException | SAXException ex) {
            ex.printStackTrace(); //TODO log
        }
    }
}

