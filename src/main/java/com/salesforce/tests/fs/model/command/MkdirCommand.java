package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.exception.DirectoryAlreadyExistsException;
import com.salesforce.tests.fs.exception.StringMaxLengthException;
import com.salesforce.tests.fs.model.directory.Directory;
import com.salesforce.tests.fs.validation.StringMaxLengthValidation;

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
