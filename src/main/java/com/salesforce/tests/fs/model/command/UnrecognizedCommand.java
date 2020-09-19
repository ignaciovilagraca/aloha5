package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.model.directory.Directory;

public class UnrecognizedCommand implements Command {

    private static final String UNRECOGNIZED_COMMAND = "Unrecognized command";

    @Override
    public void execute() {
        System.out.println(UNRECOGNIZED_COMMAND);
    }

    @Override
    public void addParameters(String[] parameters) {

    }

    @Override
    public void addRootDirectory(Directory directory) {

    }
}
