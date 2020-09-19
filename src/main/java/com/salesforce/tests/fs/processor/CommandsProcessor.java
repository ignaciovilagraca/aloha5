package com.salesforce.tests.fs.processor;

import com.salesforce.tests.fs.exception.QuitException;
import com.salesforce.tests.fs.model.command.Command;

import java.util.List;

public class CommandsProcessor {
    public void execute(List<Command> commands) {
        try {
            commands.forEach(Command::execute);
        } catch (QuitException ignored) {
        }
    }
}
