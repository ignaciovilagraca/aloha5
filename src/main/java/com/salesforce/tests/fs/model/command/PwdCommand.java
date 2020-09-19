package com.salesforce.tests.fs.model.command;

public class PwdCommand extends DirectoryCommand {

    @Override
    public void execute() {
        System.out.println(CURRENT_DIRECTORY.pathToRoot());
    }

    @Override
    public void addParameters(String[] parameters) {

    }
}
