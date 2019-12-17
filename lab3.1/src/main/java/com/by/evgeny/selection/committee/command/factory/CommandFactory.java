package com.by.evgeny.selection.committee.command.factory;


import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.CommandType;
import com.by.evgeny.selection.committee.command.common.HomePageCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    private final Logger logger = LogManager.getLogger();

    public Command getCommand(HttpServletRequest req) {
        Command currCommand = new HomePageCommand();
        String command = req.getParameter("command");
        try {
            String commandTypeValue = command.toUpperCase();
            CommandType currentType = CommandType.getCommand(commandTypeValue);
            currCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
           logger.error(e.getMessage());
        }
        return currCommand;
    }
}
