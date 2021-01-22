package com.ignacio.vila.linux.shell.model.directory;

public class File {
    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
