package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Faculties;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;
import com.by.evgeny.selection.committee.singleton.SingletonFaculties;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;
import com.by.evgeny.selection.committee.utils.Dictionary;
import com.by.evgeny.selection.committee.writer.XmlWriter;

public class Exit implements Command {

    @Override
    public void execute() {
        var xmlEnrolleesWriter = new XmlWriter<Enrollees>();
        try {
            xmlEnrolleesWriter.write(SingletonEnrollees.getInstance(), "enrollees.xml");
        }
        catch (XmlException e) {
            System.out.println(e.getMessage());
        }

        var xmlSpecialitiesWriter = new XmlWriter<Specialities>();
        try {
            xmlSpecialitiesWriter.write(SingletonSpecialities.getInstance(), "specialities.xml");
        }
        catch (XmlException e) {
            System.out.println(e.getMessage());
        }

        var xmlDictionaryWriter = new XmlWriter<Dictionary>();
        try {
            xmlDictionaryWriter.write(DataValidator.getDictionary(), "dictionary.xml");
        }
        catch (XmlException e) {
            System.out.println(e.getMessage());
        }

        var xmlFacultiesWriter = new XmlWriter<Faculties>();
        try {
            xmlFacultiesWriter.write(SingletonFaculties.getInstance(), "faculties.xml");
        }
        catch (XmlException e) {
            System.out.println(e.getMessage());
        }
    }
}
