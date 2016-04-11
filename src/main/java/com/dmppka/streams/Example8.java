package com.dmppka.streams;

import com.dmppka.streams.domain.Developer;
import com.dmppka.streams.domain.ProgrammingLanguage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Example8 {
    public static void main(String[] args) {
        List<Integer> numbers1 = asList(1, 2, 3);
        List<Integer> numbers2 = asList(4, 5);

        List<int[]> listPairs = numbers1.stream()
                .flatMap(number1 -> numbers2.stream()
                            .map(number2 -> new int[]{number1, number2})
                ).collect(toList());

        listPairs.forEach(pair -> System.out.println(String.format("%s - %s", pair[0], pair[1])));

        // Developers & Programming languages
        List<Developer> developers = asList(
                new Developer("Marc", asList(new ProgrammingLanguage("Python"), new ProgrammingLanguage("Java"))),
                new Developer("Santa", asList(new ProgrammingLanguage("JavaScript"), new ProgrammingLanguage("Python"))),
                new Developer("Alex", asList(new ProgrammingLanguage("PHP"), new ProgrammingLanguage("Java")))
        );

        developers.stream()
                .map(Developer::getLanguages)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);

    }
}
