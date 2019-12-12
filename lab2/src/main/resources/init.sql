CREATE DATABASE IF NOT EXISTS epam_lab;
USE epam_lab;

CREATE TABLE IF NOT EXISTS
    faculties
(
    id              INT(11) PRIMARY KEY NOT NULL,
    name            VARCHAR(64),
);

CREATE TABLE IF NOT EXISTS
    specialities
(
    id              INT(11) PRIMARY KEY NOT NULL,
    name            VARCHAR(64),
    FOREIGN KEY     (facultyId) REFERENCES faculties (id) ON DELETE RESTRICT,
    places          INT(11),
    enrolled        INT(11)
);

CREATE TABLE IF NOT EXISTS
    students
(
    id              INT(11) PRIMARY KEY NOT NULL,
    name            VARCHAR(64),
    surname         VARCHAR(64),
    patronomic      VARCHAR(64),
    gender          ENUM('MALE', 'FEMALE'),
    FOREIGN KEY (specialityId) REFERENCES specialities (id) ON DELETE RESTRICT,
    totalMark       INT(11),
    ticketNo        INT(11) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS
    enrollees
(
    id              INT(11) PRIMARY KEY NOT NULL,
    name            VARCHAR(64),
    surname         VARCHAR(64),
    patronomic      VARCHAR(64),
    gender          ENUM('MALE', 'FEMALE'),
    FOREIGN KEY (specialityId) REFERENCES specialities (id) ON DELETE RESTRICT,
    schoolMark      INT(11),
    ctMark1         INT(11),
    ctMark2         INT(11),
    ctMark3         INT(11),
    medicalClearance TINYINT(1)
);
