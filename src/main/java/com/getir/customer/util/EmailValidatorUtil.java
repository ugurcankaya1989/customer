package com.getir.customer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorUtil {
    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isNotValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
