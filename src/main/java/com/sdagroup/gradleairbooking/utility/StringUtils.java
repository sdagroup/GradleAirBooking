package com.sdagroup.gradleairbooking.utility;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan Alexander on 10/01/2019.
 */
public class StringUtils {
    // split operation for the description
    public static List<String> splitStringByComma(final String param) {
        if (param == null) {
            throw new IllegalStateException("Param should not be empty");
        }

        String[] params = param.split(",");
        return Arrays.asList(params);
    }
}
