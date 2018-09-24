package it.tdd.examples;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class Calculator {
    public static final int MAX_SUPPORTED_INPUT_VALUE = 1000;
    private static final String SEPARATOR_DECLARATION_TOKEN = "//";
    private static String[] NUMBER_SEPARATOR = {",","\n"};
    private static String INTERNAL_SEPARATOR = "SEPARATOR_FOR_INTERNAL_PORPOUSE_" + UUID.randomUUID() + "_SEPARATOR_END";


    public static Integer add(String expression) {
        if (StringUtils.isEmpty(expression) )
            return 0;

        String originalExp = expression + "";

        final String customSeparator = extractCustomSeparators(expression);

        Optional.ofNullable(customSeparator)
                .ifPresent(s -> NUMBER_SEPARATOR = Stream.concat(Arrays.stream(NUMBER_SEPARATOR), Stream.of(s)).toArray(String[]::new));


        expression = expression.replace("//"+ customSeparator,"");

        for (String s : NUMBER_SEPARATOR) {
            expression = expression.replace(s, INTERNAL_SEPARATOR);
        }

        return Arrays.stream(expression.split(INTERNAL_SEPARATOR))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Calculator::convertToInt)
                .peek(Calculator::checkNotNegative)
                .filter(n -> n < MAX_SUPPORTED_INPUT_VALUE)
                .reduce((a,b) -> a + b)
                .orElse(0);
    }

    private static String extractCustomSeparators(String expression) {
        String firstLine = Arrays.stream(expression.split("\n")).findFirst().orElse("");
        if (firstLine.startsWith(SEPARATOR_DECLARATION_TOKEN)){
            return firstLine.substring(SEPARATOR_DECLARATION_TOKEN.length());
        }
        return null;
    }

    private static void checkNotNegative(Integer n) throws NegativeNumberException {
        if (n < 0)
            throw new NegativeNumberException();

    }

    private static Integer convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        }catch (Exception e){
            System.out.println("Error converting value!");
            return 0;
        }
    }



}
