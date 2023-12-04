package org.example.stream;

import org.example.serialization.Department;
import org.example.serialization.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Storage storage = message -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))){
                writer.write(message);
            }
        };

        Predicate<Integer> oldEmployee = integer -> integer > 60;
        Function<Integer, String> convert = integer -> integer + "$";
        System.out.println(convert.apply(10));

        Consumer<String> printer = message -> System.out.println("city: " + message);
        printer.accept("hello world");

        Supplier<Department> employeeSupplier = () -> new Department("Sales", "+798989878");
        System.out.println(employeeSupplier.get());

        //Predicate<Double> doublePredicate = d -> d > 10;
        DoublePredicate doublePredicate = d -> d > 10;

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Moscow");
        cities.add("Minsk");

        FileStorage storage1 = new FileStorage();

        //cities.stream()

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        Integer integers = stream
                .map(item -> item * 2)
                .filter(item -> item >= 10)
                .peek(item -> System.out.println("Debug item: " + item))
                .map(item -> item * 10).findFirst().orElseThrow(RuntimeException::new);

        System.out.println(integers);
    }
}
