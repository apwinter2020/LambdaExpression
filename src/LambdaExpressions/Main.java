package LambdaExpressions;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    static void print(String value, StringConverter converter) {
        System.out.println(converter.convert(value));
    }

    static void print(String value, IntegerConverter converter) {
        System.out.println(converter.convert(value));
    }

    static void print(Double first, Double second, ArithmeticOperation operation) {
        System.out.println(operation.convert(first,second));
    }

    public static void main(String[] args) {
        StringConverter toLower = new StringConverter() {
            @Override
            public String convert(String value) {
                return value.toLowerCase();
            }
        };

        StringConverter toUpper = new StringConverter() {
            @Override
            public String convert(String value) {
                return value.toUpperCase();
            }
        };

        print(
                "Salaam",
                new StringConverter() {
                    @Override
                    public String convert(String value) {
                        return value.substring(0, 2);
                    }
                }
        );

        print(
                "Salaam",
                toLower
        );

        print(
                "Salaam",
                toUpper
        );

        print(
                "3534",
                (String string) -> Integer.parseInt(string)
        );

        print("Salaam", (String a) -> a.toUpperCase());

        StringConverter covnerter = (String string) -> {
            int a = 0;
            return string.toLowerCase();
        };

        Double firstDouble = 1.345345;
        Double secondDouble = 345.345;

        print(firstDouble, secondDouble, (a, b) -> a + b);
        print(firstDouble, secondDouble, (a, b) -> a * b);

        double pow = 2;
        print(firstDouble, secondDouble, (a, b) -> Math.pow(a + b, pow));
//        pow=3;
    }
}

interface StringConverter {
    String convert(String value);

    default void print(String value) {
        System.out.println(value);
    }
}

interface IntegerConverter {
    Integer convert(String value);

    default void print(String value) {
        System.out.println(value);
    }
}

interface ArithmeticOperation {
    Double convert(double a, double b);
}
