package com.by.evgeny.selection.committee.parser;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.exceptions.DataSourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpecialityDomParser implements XmlParser<Speciality> {

    enum SpecialityTag {
        SPECIALITY, SPECIALITY_NAME, SPECIALITY_FACULTY_ID, SPECIALITY_PLACES, SPECIALITY_ENROLLED, SPECIALITY_ID
    }

    private final Logger logger = LogManager.getLogger();

    @Override
    public ArrayList<Speciality> getDataFromFile(String filePath) throws DataSourceException {
        File file = new File(filePath);
        ArrayList<Speciality> specialities;

        try {
            Document document = buildDocument(file);
            NodeList nodeList = document.getDocumentElement()
                    .getElementsByTagName(SpecialityTag.SPECIALITY.name().toLowerCase().replace("_", "-"));
            specialities = new ArrayList<>(nodeList.getLength());

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.TEXT_NODE) {
                    Speciality speciality = getSpecialityFromNode(nodeList.item(i));
                    specialities.add(speciality);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new DataSourceException("File " + filePath + " not found");
        }
        return specialities;
    }

    private Speciality getSpecialityFromNode(Node specialityNode) {
        Speciality speciality = new Speciality();
        NodeList specialityProps = specialityNode.getChildNodes();
        SpecialityTag tag = null;
        String input = null;

        for (int j = 0; j < specialityProps.getLength(); j++) {
            if ((specialityProps.item(j).getNodeType() != Node.TEXT_NODE)) {
                try {
                    input = specialityProps.item(j).getNodeName();
                    tag = SpecialityTag.valueOf(input.toUpperCase().replace("-", "_"));
                    switch (tag) {
                        case SPECIALITY_NAME:
                            speciality.setName(specialityProps.item(j).getTextContent());
                            break;
                        case SPECIALITY_FACULTY_ID:
                            speciality.setFacultyId(Integer.parseInt(specialityProps.item(j).getTextContent()));
                            break;
                        case SPECIALITY_PLACES:
                            speciality.setPlaces(Integer.parseInt(specialityProps.item(j).getTextContent()));
                            break;
                        case SPECIALITY_ENROLLED:
                            speciality.setEnrolled(Integer.parseInt(specialityProps.item(j).getTextContent()));
                            break;
                        case SPECIALITY_ID:
                            speciality.setId(Integer.parseInt(specialityProps.item(j).getTextContent()));
                            break;
                    }
                } catch (DOMException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return speciality;
    }

    Document buildDocument(File file) throws IOException, ParserConfigurationException,
            org.xml.sax.SAXException {
        Document document;
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = documentBuilder.parse(file);
        document.normalize();
        return document;
    }
}
