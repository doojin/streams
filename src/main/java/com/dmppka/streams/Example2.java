package com.dmppka.streams;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Getting result of multiplication of first two even numbers by ten
        List<Integer> result = numbers.stream()
                .filter(number -> {
                    System.out.println(String.format("Filtering number: %s", number));
                    return number % 2 == 0;
                })
                .map(number -> {
                    System.out.println(String.format("Multiplying number %s by ten", number));
                    return number * 10;
                })
                .limit(2)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
