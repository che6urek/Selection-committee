package com.by.evgeny.selection.committee.writer;

import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.fasterxml.jackson.xml.XmlMapper;

import java.io.File;

public class XmlWriter<T> {
    public void write(T object, String fileName) throws XmlException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), object);
        }
        catch (Exception e) {
            throw new XmlException("Can't write to " + fileName, e);
        }
    }
}
