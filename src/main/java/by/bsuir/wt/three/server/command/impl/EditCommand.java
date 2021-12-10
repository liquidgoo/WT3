package main.java.by.bsuir.wt.three.server.command.impl;

import main.java.by.bsuir.wt.three.server.command.Command;
import main.java.by.bsuir.wt.three.server.command.exception.CommandException;
import main.java.by.bsuir.wt.three.server.model.AuthType;
import main.java.by.bsuir.wt.three.server.service.ServiceFactory;

public class EditCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 4) throw new CommandException("Invalid syntax EDIT");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER)
            return "Should be MANAGER";

        int id;
        try {
            id = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException ignored) {
            return "Invalid id";
        }

        if (!ServiceFactory.getInstance().getCaseService().containsCase(id))
            return "No such case";

        ServiceFactory.getInstance().getCaseService().editCase(id, arguments[2], arguments[3]);
        return "Success";
    }
}
