package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.model.directory.Directory;

public abstract class DirectoryCommand implements Command {
    protected static Directory CURRENT_DIRECTORY;

    @Override
    public void addRootDirectory(Directory directory) {
        CURRENT_DIRECTORY = directory;
    }
}
