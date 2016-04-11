package com.dmppka.streams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Example7 {
    public static void main(String[] args) {
        // Streams vs Parallel streams
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        long now = new Date().getTime();

        numbers.stream().forEach(Example7::operation);

        now = new Date().getTime() - now;
        System.out.println(now);
        now = new Date().getTime();

        numbers.parallelStream().forEach(Example7::operation);

        now = new Date().getTime() - now;
        System.out.println(now);
    }

    private static int operation(int arg) {
        for (int i = 0; i < 100000; i++) {
            arg *= 10;
            arg /= 10;
        }
        return arg;
    }
}
