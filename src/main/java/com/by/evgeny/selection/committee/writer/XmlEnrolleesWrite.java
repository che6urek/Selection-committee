package com.by.evgeny.selection.committee.writer;

import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.fasterxml.jackson.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

//TODO Fix

public class XmlEnrolleesWrite {
    public static void Write(Enrollees enrollees, String fileName) throws XmlException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), enrollees);
        }
        catch (IOException e) {
            throw new XmlException("Can't write to " + fileName, e);
        }
    }
}
