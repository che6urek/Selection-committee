package com.by.evgeny.selection.committee.command.common;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.Page;
import com.by.evgeny.selection.committee.parser.StudentSaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ShowStudentsCommand implements Command {

    private final Logger logger = LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest request) {

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        Properties prop = new Properties();
        List srudents = new ArrayList();
        try (InputStream input = new FileInputStream("src/main/resources/conf.properties")) {
            prop.load(input);
            String xmlDataFileName = prop.getProperty("data.xmlFileName");

            StudentSaxParser studentParser = new StudentSaxParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(studentParser);
            xmlReader.parse(new InputSource(xmlDataFileName));
            studentParser.getStudents();
        } catch (IOException | SAXException e) {
            logger.error(e.getMessage());
        }

        int rows = srudents.size();

        if (currentPage * recordsPerPage >= rows) {
            request.setAttribute("srudents", srudents.subList((currentPage - 1) * recordsPerPage, rows));
        } else {
            request.setAttribute("srudents", srudents.subList((currentPage - 1) * recordsPerPage, currentPage * recordsPerPage));
        }

        int nOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return new Page(Page.STUDENTS_PAGE_PATH, false);
    }
}
