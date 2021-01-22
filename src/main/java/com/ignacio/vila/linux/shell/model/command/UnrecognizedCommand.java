package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.model.directory.Directory;

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
