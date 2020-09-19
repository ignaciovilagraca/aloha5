package com.salesforce.tests.fs.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputsReader {
    public List<String> read(Scanner scanner) {
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            inputs.add(input);
        }

        return inputs;
    }
}
