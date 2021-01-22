package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.model.directory.Directory;

public interface Command {
    void execute();

    void addParameters(String[] parameters);

    void addRootDirectory(Directory directory);
}
