package com.by.evgeny.selection.committee.migration;

import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.exceptions.DataBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EnrolleMigration {

    private static final Logger logger = LogManager.getLogger(FacultyMigration.class);

    private static final String TABLE = "enrollees";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE +
            " (id, name, surname, patronomic, gender, specialityId, schoolMark, ctMark1, ctMark2, ctMark3, medicalClearance)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?);";

    private Connection dbConnection;

    public EnrolleMigration(Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<Enrolle> enrollees) {
        AtomicInteger counter = new AtomicInteger();
        for (Enrolle enrolle : enrollees) {
            try {
                saveEnrolle(enrolle);
                counter.getAndIncrement();
            } catch (Exception e) {
                logger.debug(e);
            }
        }

        System.out.println(counter + " enrollees migrated");
        return counter.get();
    }

    private void saveEnrolle(Enrolle enrolle) throws DataBaseException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, enrolle.getId());
            statement.setString(2, enrolle.getPersonalData().getName());
            statement.setString(3, enrolle.getPersonalData().getSurname());
            statement.setString(4, enrolle.getPersonalData().getPatronymic());
            statement.setString(5, enrolle.getPersonalData().getGender().toString());
            statement.setInt(6, enrolle.getSpecialtyId());
            statement.setInt(7, enrolle.getSchoolMark());
            statement.setInt(8, enrolle.getCtMarks()[0]);
            statement.setInt(9, enrolle.getCtMarks()[1]);
            statement.setInt(10, enrolle.getCtMarks()[2]);
            statement.setBoolean(11, enrolle.isMedicalClearance());
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            logger.error(e);
            throw new DataBaseException(e.getMessage(), e);
        }
    }
}
