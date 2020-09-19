package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.presenter.DirectoryPresenter;

public class LsCommand extends DirectoryCommand {

    private String[] parameters;

    @Override
    public void execute() {
        DirectoryPresenter presenter = new DirectoryPresenter();
        if (parameters.length > 1 && "-r".equals(parameters[1])) {
            presenter.presentRecursively(CURRENT_DIRECTORY);
        } else {
            presenter.present(CURRENT_DIRECTORY);
        }
    }

    @Override
    public void addParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
