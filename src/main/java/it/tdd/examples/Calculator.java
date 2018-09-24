package it.tdd.examples;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public static Integer add(String expression) {
        return StringUtils.isEmpty(expression) ? 0 : null;
    }
}
