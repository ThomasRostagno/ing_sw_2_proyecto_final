package com.ingsof2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FloatValidatorRegex {

        private static final String FLOAT_PATTERN =
                "[0-9]{0,9}(\\.[0-9]{1,2})?$";


        private static final Pattern pattern = Pattern.compile(FLOAT_PATTERN);

        public static boolean isValid(final String floatNumber) {
            Matcher matcher = pattern.matcher(floatNumber);

            return matcher.matches();
        }
    }
