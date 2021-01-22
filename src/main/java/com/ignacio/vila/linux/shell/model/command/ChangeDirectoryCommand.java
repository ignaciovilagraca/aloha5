package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.exception.DirectoryNotFoundException;

public class ChangeDirectoryCommand extends DirectoryCommand {
    private String[] parameters;

    @Override
    public void execute() {
        try {
            String newDirectory = parameters[1];
            CURRENT_DIRECTORY = "..".equals(newDirectory)
                    ? CURRENT_DIRECTORY.getParentDirectory()
                    : CURRENT_DIRECTORY.getSubDirectoryOrThrowException(newDirectory);
        } catch (DirectoryNotFoundException e) {
            System.out.println("Directory not found");
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
