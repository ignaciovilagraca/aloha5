package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.exception.QuitException;
import com.salesforce.tests.fs.model.directory.Directory;

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
