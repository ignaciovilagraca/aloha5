package com.salesforce.tests.fs.factory;

import com.salesforce.tests.fs.model.command.*;
import com.salesforce.tests.fs.model.directory.Directory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsFactory {

    private final Map<String, Class<?>> commandsByString = new HashMap<String, Class<?>>() {{
            put("quit", QuitCommand.class);
            put("pwd", PwdCommand.class);
            put("ls", LsCommand.class);
            put("mkdir", MkdirCommand.class);
            put("cd", ChangeDirectoryCommand.class);
            put("touch", TouchCommand.class);
    }};

    public List<Command> build(List<String> inputs) {
        List<Command> commands = new ArrayList<>();
        Directory directory = new Directory("root");

        inputs.forEach(input -> {
            String[] parsedInputs = input.split(" ");

            Command command;
            Class<?> c = commandsByString.getOrDefault(parsedInputs[0], UnrecognizedCommand.class);
            try {
                command = (Command) c.getConstructor().newInstance();
            } catch (Exception e) {
                command = new UnrecognizedCommand();
            }

            command.addParameters(parsedInputs);
            command.addRootDirectory(directory);

            commands.add(command);
        });

        return commands;
    }
}
