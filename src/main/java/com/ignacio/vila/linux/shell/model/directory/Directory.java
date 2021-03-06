package com.ignacio.vila.linux.shell.model.directory;

import com.ignacio.vila.linux.shell.exception.DirectoryNotFoundException;
import com.ignacio.vila.linux.shell.exception.DirectoryAlreadyExistsException;

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
        if (this.directories.stream().anyMatch(d -> d.name.equals(directory.name))) {
            throw new DirectoryAlreadyExistsException();
        }

        directory.parentDirectory = this;
        directories.add(directory);
    }

    public List<String> present() {
        List<String> content = new ArrayList<>();
        directories.forEach(directory -> content.add(directory.toString()));
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

    public Directory getSubDirectoryOrThrowException(String newDirectory) {
        return directories.stream().filter(d -> newDirectory.equals(d.name)).findAny().orElseThrow(DirectoryNotFoundException::new);
    }

    public Directory getParentDirectory() {
        return parentDirectory == null ? this : parentDirectory;
    }

    public List<String> presentRecursively() {
        List<String> content = new ArrayList<>();
        content.add(this.pathToRoot());
        files.forEach(file -> content.add(file.toString()));
        directories.forEach(directory -> content.addAll(directory.presentRecursively()));
        return content;
    }
}
