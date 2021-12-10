package main.java.by.bsuir.wt.three.server.command.impl;

import main.java.by.bsuir.wt.three.server.model.Case;
import main.java.by.bsuir.wt.three.server.command.Command;
import main.java.by.bsuir.wt.three.server.command.exception.CommandException;
import main.java.by.bsuir.wt.three.server.model.AuthType;
import main.java.by.bsuir.wt.three.server.service.ServiceFactory;

import java.util.List;

public class ViewCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) == AuthType.UNAUTH)
            return "Should be authenticated";

        var cases = ServiceFactory.getInstance().getCaseService().getAll();
        return toOutput(cases);
    }

    private static String toOutput(List<Case> cases) {
        var resultBuilder = new StringBuilder();
        resultBuilder.append("[\n");
        for (var _case : cases) {
            resultBuilder.append("\t").append(_case.toString()).append("\n");
        }
        resultBuilder.append("]");
        return resultBuilder.toString();
    }
}
