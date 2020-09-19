package com.salesforce.tests.fs.validation;

import com.salesforce.tests.fs.exception.StringMaxLengthException;

public class StringMaxLengthValidation {

    public void validate(String string) {
        if (string.length() > 100) {
            throw new StringMaxLengthException();
        }
    }
}
