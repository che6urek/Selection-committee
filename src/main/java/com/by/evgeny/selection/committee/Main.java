package com.by.evgeny.selection.committee;

import com.by.evgeny.selection.committee.utils.DataValidator;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.entity.documents.AcademicCertificate;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.documents.MedicalCertificate;
import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.writer.XmlEnrolleesWrite;
import com.by.evgeny.selection.committee.exceptions.XmlException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /* TODO data validation
    *       architecture
    *       UI
    *       javadoc
    *       serialization*/

    public static void main(String[] args) {
        Enrollees enrollees = fillEnrollees();
        Specialities specs = fillSpecs();
        System.out.println(enrollees);
        try {
            XmlEnrolleesWrite.Write(enrollees, "enrollees.xml");
        }
        catch (XmlException e){
            System.out.println("error");
        }
        specs.Enroll(enrollees);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while(!str.equals("0"))
        {
            System.out.println(DataValidator.checkName(str));
            str = in.nextLine();
        }
        System.out.println("end");
    }

    private static Specialities fillSpecs() {
        Specialities specs = new Specialities();
        specs.add(new Speciality("SWIT", "KSaN", 3, new String[] {"Russian", "Physics", "Math"}, 7510));
        specs.add(new Speciality("CS", "KSaN", 4, new String[] {"Russian", "English", "Math"}, 7535));
        specs.add(new Speciality("111", "KSaN", 4, new String[] {"Russian", "English", "Math"}, 0));
        return specs;
    }

    private static Enrollees fillEnrollees()
    {
        Enrollees en = new Enrollees();
        var ac = new AcademicCertificate(new int[] {10, 9, 8});
        var mc = new MedicalCertificate(true);
        for(int i = 5; i > 0; i--)
        {
            ArrayList<CTCertificate> ct = new ArrayList<CTCertificate>();
            ct.add(new CTCertificate("Russian", 95 - i % 95));
            ct.add(new CTCertificate("Math", 95 - i % 95));
            ct.add(new CTCertificate("Physics", 95 - i % 95));
            String name = Integer.toString(i);
            PersonalData pd = new PersonalData(name, name, name);
            en.add(new Enrolle(pd, "SWIT", ct, ac, mc));
        }
        for(int i = 5; i > 0; i--)
        {
            ArrayList<CTCertificate> ct = new ArrayList<CTCertificate>();
            ct.add(new CTCertificate("Russian", 95 - i % 95));
            ct.add(new CTCertificate("Math", 95 - i % 95));
            ct.add(new CTCertificate("English", 95 - i % 95));
            String name = Integer.toString(i + 1000);
            PersonalData pd = new PersonalData(name, name, name);
            en.add(new Enrolle(pd, "CS", ct, ac, mc));
        }
        ArrayList<CTCertificate> ct = new ArrayList<CTCertificate>();
        ct.add(new CTCertificate("Russian", 100));
        ct.add(new CTCertificate("Math", 100));
        ct.add(new CTCertificate("Biology", 100));
        String name = "---";
        PersonalData pd = new PersonalData(name, name, name);
        en.add(new Enrolle(pd, "CS", ct, ac, new MedicalCertificate(false)));
        Enrolle lul = new Enrolle(pd, "---", ct, ac, new MedicalCertificate(false));
        en.update(1, lul);
        name = "+++";
        pd = new PersonalData(name, name, name);
        en.add(new Enrolle(pd, "SWIT", ct, ac, mc));
        return en;
    }

}
