package com.dmppka.streams;

import com.dmppka.streams.domain.Gender;
import com.dmppka.streams.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

public class Example5 {
    public static void main(String[] args) {
        List<Person> people = asList(
                new Person("Steve", 42, Gender.MALE),
                new Person("Jessica", 30, Gender.FEMALE),
                new Person("Alex", 46, Gender.MALE),
                new Person("Kate", 25, Gender.FEMALE),
                new Person("Mike", 31, Gender.MALE));

        // Grouping people by gender
        Map<Gender, List<Person>> grouped = people.stream()
                .collect(groupingBy(Person::getGender));

        printResult(grouped);

        // Doing the same without streams
        grouped = new HashMap<>();

        for (Person person: people) {
            Gender gender = person.getGender();
            if (!grouped.containsKey(gender)) {
                grouped.put(gender, new ArrayList<>());
            }
            grouped.get(gender).add(person);
        }

        printResult(grouped);
    }

    public static void printResult(Map<Gender, List<Person>> result) {
        result.entrySet().stream()
                .forEach(entry -> {
                    Gender gender = entry.getKey();
                    List<Person> listOfPeople = entry.getValue();

                    System.out.println(gender);
                    listOfPeople.stream()
                            .map(Person::getName)
                            .forEach(System.out::println);
                });
    }
}
