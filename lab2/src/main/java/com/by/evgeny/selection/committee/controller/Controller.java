package com.by.evgeny.selection.committee.controller;
import com.by.evgeny.selection.committee.entity.SelectionCommittee;
import com.by.evgeny.selection.committee.migration.EnrolleMigration;
import com.by.evgeny.selection.committee.migration.FacultyMigration;
import com.by.evgeny.selection.committee.migration.SpecialityMigration;
import com.by.evgeny.selection.committee.migration.StudentMigration;
import com.by.evgeny.selection.committee.singleton.DataBase;
import com.by.evgeny.selection.committee.utils.LoadingData;

public class Controller {

    public static void main(String[] args) {

        var selectionCommittee = new SelectionCommittee();
        var loadingData = new LoadingData();

        try {
            selectionCommittee = loadingData.loadDataFromXml("src/main/resources/SelectionCommittee.xml");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            var facultyMigration = new FacultyMigration(DataBase.getInstance().getConnection());
            var specialityMigration = new SpecialityMigration(DataBase.getInstance().getConnection());
            var studentMigration = new StudentMigration(DataBase.getInstance().getConnection());
            var enrolleMigration = new EnrolleMigration(DataBase.getInstance().getConnection());


            facultyMigration.migrate(selectionCommittee.getFaculties());
            specialityMigration.migrate(selectionCommittee.getSpecialities());
            studentMigration.migrate(selectionCommittee.getStudents());
            enrolleMigration.migrate(selectionCommittee.getEnrollees());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

