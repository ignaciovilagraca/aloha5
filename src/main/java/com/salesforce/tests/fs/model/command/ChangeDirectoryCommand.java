package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.exception.DirectoryNotFoundException;

public class ChangeDirectoryCommand extends DirectoryCommand {
    private String[] parameters;

    @Override
    public void execute() {
        try {
            CURRENT_DIRECTORY = CURRENT_DIRECTORY.updateCurrentDirectoryOrThrowException(parameters[1]);
        } catch (DirectoryNotFoundException e) {
            System.out.println("Directory not found");
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
