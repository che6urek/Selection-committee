package com.by.evgeny.selection.committee.migration;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.exceptions.DataBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SpecialityMigration {

    private static final Logger logger = LogManager.getLogger(SpecialityMigration.class);

    private static final String TABLE = "specialities";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE + " (id, name, places, enrolled) VALUES (?,?,?,?);";

    private Connection dbConnection;

    public SpecialityMigration(Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<Speciality> specialities) {
        AtomicInteger counter = new AtomicInteger();
        for (Speciality speciality : specialities) {
            try {
                saveSpeciality(speciality);
                counter.getAndIncrement();
            } catch (Exception e) {
                logger.debug(e);
            }
        }

        System.out.println(counter + " specialities migrated");
        return counter.get();
    }

    private void saveSpeciality(Speciality speciality) throws DataBaseException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, speciality.getId());
            statement.setString(2, speciality.getName());
            statement.setInt(3, speciality.getPlaces());
            statement.setInt(4, speciality.getEnrolled());
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
