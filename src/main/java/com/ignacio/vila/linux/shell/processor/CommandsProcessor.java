package com.ignacio.vila.linux.shell.processor;

import com.ignacio.vila.linux.shell.exception.QuitException;
import com.ignacio.vila.linux.shell.model.command.Command;

import java.util.List;

public class CommandsProcessor {
    public void execute(List<Command> commands) {
        try {
            commands.forEach(Command::execute);
        } catch (QuitException ignored) {
        }
    }
}
