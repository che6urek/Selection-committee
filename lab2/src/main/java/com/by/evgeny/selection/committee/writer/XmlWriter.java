package com.by.evgeny.selection.committee.writer;

import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlWriter<T> {
    /***
     * Serialize object to the XML file
     * @param object object to serialize
     * @param fileName name of the file for saving
     * @throws XmlException is invoked on any error occurs while processing
     */
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
