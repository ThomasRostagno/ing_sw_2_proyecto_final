package com.ingsof2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorRegex {

    private static final String DATE_PATTERN =
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);

       return matcher.matches();
    }
}
