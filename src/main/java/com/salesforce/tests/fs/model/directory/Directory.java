package com.salesforce.tests.fs.model.directory;

import com.salesforce.tests.fs.exception.DirectoryNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    List<File> files;
    List<Directory> directories;
    Directory parentDirectory;

    String name;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
    }

    public void createFile(File file) {
        files.add(file);
    }

    public void createDirectory(Directory directory) {
        directory.parentDirectory = this;
        directories.add(directory);
    }

    public List<String> present() {
        List<String> content = new ArrayList<>();
        directories.forEach(folder -> content.add(folder.toString()));
        files.forEach(file -> content.add(file.toString()));
        return content;
    }

    @Override
    public String toString() {
        return "/" + name;
    }

    public String pathToRoot() {
        return parentDirectory == null ? this.toString() : parentDirectory.pathToRoot() + this.toString();
    }

    public Directory findCurrentFolderOrThrowException(String newDirectory) {
        return directories.stream().filter(d -> newDirectory.equals(d.name)).findAny().orElseThrow(DirectoryNotFoundException::new);
    }
}