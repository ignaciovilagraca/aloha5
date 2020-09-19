package com.salesforce.tests.fs.model.command;

import com.salesforce.tests.fs.presenter.DirectoryPresenter;

public class LsCommand extends DirectoryCommand {

    @Override
    public void execute() {
        new DirectoryPresenter().present(CURRENT_DIRECTORY);
    }

    @Override
    public void addParameters(String[] parameters) {

    }


}
