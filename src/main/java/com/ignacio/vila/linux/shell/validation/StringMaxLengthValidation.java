package com.ignacio.vila.linux.shell.validation;

import com.ignacio.vila.linux.shell.exception.StringMaxLengthException;

public class StringMaxLengthValidation {

    public void validate(String string) {
        if (string.length() > 100) {
            throw new StringMaxLengthException();
        }
    }
}
