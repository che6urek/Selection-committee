package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;
import com.by.evgeny.selection.committee.writer.XmlWriter;

public class Exit implements Command {

    @Override
    public void execute(){
        var xmlWriter = new XmlWriter<Enrollees>();
        try {
            xmlWriter.write(SingletonEnrollees.getInstance(), "enrollees.xml");
        }
        catch (XmlException e){
            System.out.println(e.getMessage());
        }
    }
}
