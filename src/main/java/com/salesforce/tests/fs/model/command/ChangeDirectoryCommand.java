package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.exception.DirectoryNotFoundException;

public class ChangeDirectoryCommand extends DirectoryCommand {
    private String[] parameters;

    @Override
    public void execute() {
        try {
            String newDirectory = parameters[1];
            CURRENT_DIRECTORY = "..".equals(newDirectory)
                    ? CURRENT_DIRECTORY.goToParentDirectory()
                    : CURRENT_DIRECTORY.updateCurrentDirectoryOrThrowException(newDirectory);
        } catch (DirectoryNotFoundException e) {
            System.out.println("Directory not found");
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
