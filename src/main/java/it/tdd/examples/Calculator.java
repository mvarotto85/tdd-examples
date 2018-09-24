package it.tdd.examples;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Calculator {
    private static String NUMBER_SEPARATOR = ",";

    public static Integer add(String expression) {
        if (StringUtils.isEmpty(expression) )
            return 0;

        return Arrays.stream(expression.split(NUMBER_SEPARATOR))
                .map(Calculator::convertToInt)
                .reduce((a,b) -> a + b).orElse(0);
    }

    private static Integer convertToInt(String value) {
        return Integer.parseInt(value);
    }


}
