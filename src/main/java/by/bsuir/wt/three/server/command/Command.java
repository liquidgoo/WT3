package main.java.by.bsuir.wt.three.server.command;

import main.java.by.bsuir.wt.three.server.command.exception.CommandException;

public interface Command {
    String execute(Object caller, String request) throws CommandException;
}
