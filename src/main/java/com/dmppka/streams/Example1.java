package com.dmppka.streams;

import com.dmppka.streams.domain.Gender;
import com.dmppka.streams.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Example1 {
    public static void main(String[] args) {
        List<Person> people = asList(
                new Person("Steve", 42, Gender.MALE),
                new Person("Jessica", 30, Gender.FEMALE),
                new Person("Alex", 46, Gender.MALE),
                new Person("Kate", 25, Gender.FEMALE),
                new Person("Mike", 31, Gender.MALE));

        // Finding names of men sorted by age without streams
        List<Person> result = new ArrayList<>();
        for (Person person: people) {
            if (person.getGender() == Gender.MALE) {
                result.add(person);
            }
        }

        Collections.sort(result, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        });

        List<String> names = new ArrayList<>();
        for (Person person: result) {
            names.add(person.getName());
        }

        for (String name: names) {
            System.out.println(name);
        }

        // Same with streams
        people.stream()
                .filter(p -> Gender.MALE.equals(p.getGender()))
                .sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
                .map(Person::getName)
                .forEach(System.out::println);
    }
}
