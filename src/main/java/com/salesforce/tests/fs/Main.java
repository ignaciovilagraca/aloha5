package com.salesforce.tests.fs;

import com.salesforce.tests.fs.factory.CommandsFactory;
import com.salesforce.tests.fs.model.command.Command;
import com.salesforce.tests.fs.processor.CommandsProcessor;
import com.salesforce.tests.fs.reader.InputsReader;

import java.util.List;
import java.util.Scanner;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new InputsReader().read(scanner);

        List<Command> commands = new CommandsFactory().build(inputs);

        new CommandsProcessor().execute(commands);
    }
}
