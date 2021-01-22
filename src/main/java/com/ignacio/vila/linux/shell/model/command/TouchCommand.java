package com.ignacio.vila.linux.shell.model.command;

import com.ignacio.vila.linux.shell.exception.StringMaxLengthException;
import com.ignacio.vila.linux.shell.model.directory.File;
import com.ignacio.vila.linux.shell.validation.StringMaxLengthValidation;

public class TouchCommand extends DirectoryCommand {
    private String[] parameters;

    @Override
    public void execute() {
        String fileName = parameters[1];

        try {
            new StringMaxLengthValidation().validate(fileName);

            CURRENT_DIRECTORY.createFile(new File(fileName));
        } catch (StringMaxLengthException e) {
            System.out.println("File name cannot have more than 100 characters");
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
