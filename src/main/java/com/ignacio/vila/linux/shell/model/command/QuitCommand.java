package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.exception.QuitException;
import com.ignacio.vila.linux.shell.model.directory.Directory;

public class QuitCommand implements Command {
    @Override
    public void execute() {
        throw new QuitException();
    }

    @Override
    public void addParameters(String[] parameters) {

    }

    @Override
    public void addRootDirectory(Directory directory) {

    }
}
