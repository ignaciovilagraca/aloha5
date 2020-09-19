package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.model.directory.Directory;

public interface Command {
    void execute();

    void addParameters(String[] parameters);

    void addRootDirectory(Directory directory);
}
