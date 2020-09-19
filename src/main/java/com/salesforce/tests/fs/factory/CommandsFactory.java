package com.salesforce.tests.fs.factory;

import com.salesforce.tests.fs.model.command.*;
import com.salesforce.tests.fs.model.directory.Directory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsFactory {

    Map<String, Class<?>> commandsByString;

    public List<Command> build(List<String> inputs) {
        initMap();
        Directory directory = createFolder();

        List<Command> commands = new ArrayList<>();

        inputs.forEach(input -> {
            String[] parsedInputs = input.split(" ");

            Command command;
            Class<?> c = commandsByString.getOrDefault(parsedInputs[0], UnrecognizedCommand.class);
            try {
                Constructor<?> cons = c.getConstructor();
                command = (Command) cons.newInstance();
            } catch (Exception e) {
                command = new UnrecognizedCommand();
            }

            command.addParameters(parsedInputs);
            command.addRootDirectory(directory);

            commands.add(command);
        });

        return commands;
    }

    private Directory createFolder() {
        return new Directory("root");
    }

    private void initMap() {
        commandsByString = new HashMap<>();
        commandsByString.put("quit", QuitCommand.class);
        commandsByString.put("pwd", PwdCommand.class);
        commandsByString.put("ls", LsCommand.class);
        commandsByString.put("mkdir", MkdirCommand.class);
        commandsByString.put("cd", ChangeDirectoryCommand.class);
        commandsByString.put("touch", TouchCommand.class);
    }
}
