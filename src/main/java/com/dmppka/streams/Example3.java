package com.dmppka.streams;

import com.dmppka.streams.domain.Gender;
import com.dmppka.streams.domain.Person;

import java.util.List;

import static java.util.Arrays.asList;

public class Example3 {
    public static void main(String[] args) {
        List<Person> people = asList(
                new Person("Steve", 42, Gender.MALE),
                new Person("Jessica", 30, Gender.FEMALE),
                new Person("Alex", 46, Gender.MALE),
                new Person("Kate", 25, Gender.FEMALE),
                new Person("Mike", 31, Gender.MALE));

        // Calculating the sum of ages
        int totalAge = people.stream()
                .reduce(0, (age, person) -> age + person.getAge(), (age1, age2) -> age1 + age2);

        System.out.println(totalAge);

        // Another way
        totalAge = people.stream()
                .map(Person::getAge)
                .reduce(0, (age1, age2) -> age1 + age2);

        System.out.println(totalAge);

        // One more way
        totalAge = people.stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println(totalAge);

        // And another one way
        totalAge = people.stream()
                .reduce(0, (age, person) -> age + person.getAge(), Math::addExact);

        System.out.println(totalAge);

        // Result of numbers' multiplication
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int result = numbers.stream()
                .reduce(1, (number1, number2) -> number1 * number2);

        System.out.println(result);
    }
}
