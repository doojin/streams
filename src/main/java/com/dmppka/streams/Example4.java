package com.dmppka.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Example4 {
    public static void main(String[] args) {
        // Generating list of ints from 10 to 15
        List<Integer> numbersFrom10To15 = IntStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());

        numbersFrom10To15.forEach(System.out::println);

        // Generating list via builder
        numbersFrom10To15 = IntStream.builder()
                .add(10)
                .add(11)
                .add(12)
                .add(13)
                .add(14)
                .add(15)
                .build()
                .boxed()
                .collect(Collectors.toList());

        numbersFrom10To15.forEach(System.out::println);

        // Concatenating two streams into one
        IntStream stream1 = IntStream.builder()
                .add(10)
                .add(11)
                .build();
        IntStream stream2 = IntStream.rangeClosed(12, 15);
        numbersFrom10To15 = IntStream.concat(stream1, stream2)
                .boxed()
                .collect(Collectors.toList());

        numbersFrom10To15.forEach(System.out::println);

        // Generating stream via "iterate" method
        numbersFrom10To15 = IntStream.iterate(10, number -> number + 1)
                .limit(6)
                .boxed()
                .collect(Collectors.toList());

        numbersFrom10To15.forEach(System.out::println);

        // Default value for empty stream
        IntStream nonEmptyStream = IntStream.rangeClosed(10, 15);
        int result = nonEmptyStream.max().orElse(169);
        System.out.println(result);

        IntStream emptyStream = IntStream.empty();
        result = emptyStream.max().orElse(169);
        System.out.println(result);

        // DoubleStream
        List<Double> doubleList = DoubleStream.iterate(100, n -> n + 0.1)
                .limit(11)
                .boxed()
                .collect(Collectors.toList());

        doubleList.forEach(System.out::println);
    }
}
