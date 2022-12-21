package org.zipcodes.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator {

    private static final String LU_REGEX = "^L-[0-9]{4}$";
    private static final Pattern LU_PATTERN = Pattern.compile(LU_REGEX);


    public static String validate(String code) {
        Matcher matcher = LU_PATTERN.matcher(code);
        if (matcher.matches()) {
            return code;
        }
        throw new IllegalArgumentException("Invalid zipcode - " + code);
    }

}
