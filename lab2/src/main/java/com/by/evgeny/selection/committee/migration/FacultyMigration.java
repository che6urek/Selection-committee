package com.by.evgeny.selection.committee.migration;

import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.exceptions.DataBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FacultyMigration {

    private static final Logger logger = LogManager.getLogger(FacultyMigration.class);

    private static final String TABLE = "faculties";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE + " (id, name) VALUES (?,?);";

    private Connection dbConnection;

    public FacultyMigration(Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<Faculty> faculties) {
        AtomicInteger counter = new AtomicInteger();
        for (Faculty faculty : faculties) {
            try {
                saveFaculty(faculty);
                counter.getAndIncrement();
            } catch (Exception e) {
                logger.debug(e);
            }
        }

        System.out.println(counter + " faculties migrated");
        return counter.get();
    }

    private void saveFaculty(Faculty faculty) throws DataBaseException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, faculty.getId());
            statement.setString(2, faculty.getName());
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
