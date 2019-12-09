package com.by.evgeny.selection.committee.utils;

import com.by.evgeny.selection.committee.entity.SelectionCommittee;
import com.by.evgeny.selection.committee.exceptions.InvalidFileException;
import com.by.evgeny.selection.committee.exceptions.NotFoundException;
import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.by.evgeny.selection.committee.reader.XmlReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.xml.sax.SAXException;

import javax.security.sasl.SaslException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class LoadingData {

    private static final File xsdFile = new File("src/main/resources/out.xsd");

    public SelectionCommittee loadDataFromXml(String xmlFile) throws XmlException, NotFoundException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        }
        catch (SAXException e){
            throw new XmlException("Invalid XML file: " + e.getMessage(), e);
        }
        catch (IOException e){
            throw new NotFoundException("File not found: " + e.getMessage(), e);
        }
        var xmlReader = new XmlReader<SelectionCommittee>();
        return xmlReader.read(xmlFile, SelectionCommittee.class);
    }
}
