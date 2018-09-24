package it.tdd.examples;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.UUID;

public class Calculator {
    private static String[] NUMBER_SEPARATOR = {",","\n"};
    private static String INTERNAL_SEPARATOR = "SEPARATOR_FOR_INTERNAL_PORPOUSE_" + UUID.randomUUID() + "_SEPARATOR_END";


    public static Integer add(String expression) {
        if (StringUtils.isEmpty(expression) )
            return 0;

        for (String s : NUMBER_SEPARATOR) {
            expression = expression.replaceAll(s, INTERNAL_SEPARATOR);
        }

        return Arrays.stream(expression.split(INTERNAL_SEPARATOR))
                .map(Calculator::convertToInt)
                .reduce((a,b) -> a + b)
                .orElse(0);
    }

    private static Integer convertToInt(String value) {
        return Integer.parseInt(value);
    }



}
