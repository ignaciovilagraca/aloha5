package com.ignacio.vila.linux.shell.presenter;

import com.ignacio.vila.linux.shell.model.directory.Directory;

import java.util.List;

public class DirectoryPresenter {
    public void present(Directory directory) {
        List<String> outputs = directory.present();
        outputs.forEach(System.out::println);
    }

    public void presentRecursively(Directory directory) {
        List<String> outputs = directory.presentRecursively();
        outputs.forEach(System.out::println);
    }
}
