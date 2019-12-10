package com.by.evgeny.selection.committee.migration;

import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.exceptions.DataBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentMigration {

    private static final Logger logger = LogManager.getLogger(FacultyMigration.class);

    private static final String TABLE = "students";
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE +
            " (id, name, surname, patronomic, gender, speciality, totalMark, ticketNo)" +
            " VALUES (?,?,?,?,?,?,?,?);";

    private Connection dbConnection;

    public StudentMigration(Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    public int migrate(ArrayList<Student> students) {
        AtomicInteger counter = new AtomicInteger();
        for (Student student : students) {
            try {
                saveStudent(student);
                counter.getAndIncrement();
            } catch (Exception e) {
                logger.debug(e);
            }
        }

        System.out.println(counter + " students migrated");
        return counter.get();
    }

    private void saveStudent(Student student) throws DataBaseException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getPersonalData().getName());
            statement.setString(3, student.getPersonalData().getSurname());
            statement.setString(4, student.getPersonalData().getPatronymic());
            statement.setString(5, student.getPersonalData().getGender().toString());
            statement.setString(6, student.getSpecialtyName());
            statement.setInt(7, student.getTotalMark());
            statement.setInt(8, student.getTicketNo());
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
