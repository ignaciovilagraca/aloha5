package com.salesforce.tests.fs.presenter;

import com.salesforce.tests.fs.model.directory.Directory;

import java.util.List;

public class DirectoryPresenter {
    public void present(Directory directory) {
        List<String> outputs = directory.present();
        outputs.forEach(System.out::println);
    }
}
