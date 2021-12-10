package main.java.by.bsuir.wt.three.server.command.impl;

import main.java.by.bsuir.wt.three.server.command.Command;
import main.java.by.bsuir.wt.three.server.command.exception.CommandException;
import main.java.by.bsuir.wt.three.server.model.AuthType;
import main.java.by.bsuir.wt.three.server.service.ServiceFactory;

public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.UNAUTH);
        return "Bye bye!";
    }
}
