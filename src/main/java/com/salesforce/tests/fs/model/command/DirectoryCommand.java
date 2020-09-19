package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.model.directory.Directory;

public abstract class DirectoryCommand implements Command {
    protected static Directory CURRENT_DIRECTORY;

    @Override
    public void addRootDirectory(Directory directory) {
        CURRENT_DIRECTORY = directory;
    }
}
