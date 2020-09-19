package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.exception.StringMaxLengthException;
import com.salesforce.tests.fs.model.directory.File;
import com.salesforce.tests.fs.validation.StringMaxLengthValidation;

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
