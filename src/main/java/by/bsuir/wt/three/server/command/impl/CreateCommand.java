package main.java.by.bsuir.wt.three.server.command.impl;

import main.java.by.bsuir.wt.three.server.command.Command;
import main.java.by.bsuir.wt.three.server.command.exception.CommandException;
import main.java.by.bsuir.wt.three.server.model.AuthType;
import main.java.by.bsuir.wt.three.server.service.ServiceFactory;

public class CreateCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 3) throw new CommandException("CREATE invalid syntax");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER)
            return "Should be MANAGER";

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
