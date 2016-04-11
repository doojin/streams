package com.dmppka.streams;

import com.dmppka.streams.domain.Trader;
import com.dmppka.streams.domain.Transaction;

import java.util.List;
import java.util.function.BinaryOperator;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class Example6 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        // What are all the unique cities where the traders work?
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // Find all traders from Cambridge and sort them by name
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(comparing(Trader::getName))
                .forEach(trader -> System.out.println(trader.getName()));

        // Return a string of all traders' names sorted alphabetically
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .reduce("", (name1, name2) -> String.format("%s %s", name1, name2)));

        // Are any traders based in Milan?
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> "Milan".equals(trader.getCity())));

        // Print all transactions' values from the traders living in Cambridge
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // What's the highest value of all the transactions?
        System.out.println(transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(0, Integer::max));

        // Find the transaction with smallest value
        transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }
}
