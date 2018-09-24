package it.tdd.examples;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public static Integer add(String expression) {
        if (StringUtils.isEmpty(expression) )
            return 0;

        return Integer.parseInt(expression);
    }


}
