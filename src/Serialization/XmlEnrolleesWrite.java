package Serialization;

import Entity.CRUD.Enrollees;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

//TODO Fix

public class XmlEnrolleesWrite {
    public void Write(Enrollees enrollees, String fileName) throws XmlException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), enrollees);
        }
        catch (IOException e) {
            throw new XmlException("Can't write to " + fileName, e);
        }
    }
}
