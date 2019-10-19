package com.by.evgeny.selection.committee.reader;

import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.fasterxml.jackson.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlReader<T> {
    public T read(String fileName, Class<T> type) throws XmlException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xmlText = new String(Files.readAllBytes(Paths.get(fileName)));
            return xmlMapper.readValue(xmlText, type);
        }
        catch (Exception e) {
            throw new XmlException("Can't read xml from " + fileName, e);
        }
    }
}
