package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.validation.StringMaxLengthValidation;
import com.ignacio.vila.linux.shell.exception.DirectoryAlreadyExistsException;
import com.ignacio.vila.linux.shell.exception.StringMaxLengthException;
import com.ignacio.vila.linux.shell.model.directory.Directory;

public class MkdirCommand extends DirectoryCommand {
    private String[] parameters;

    @Override
    public void execute() {
        String directoryName = parameters[1];

        try {
            new StringMaxLengthValidation().validate(directoryName);

            CURRENT_DIRECTORY.createDirectory(new Directory(directoryName));
        } catch (StringMaxLengthException e) {
            System.out.println("Directory name cannot have more than 100 characters");
        } catch (DirectoryAlreadyExistsException e) {
            System.out.println("Directory already exists");
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
