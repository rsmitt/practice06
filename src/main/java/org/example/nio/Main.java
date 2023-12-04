package org.example.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/../main/resources/file.txt");
        System.out.println("path = " + path);
        System.out.println("is file = " + path.toFile().isFile());
        System.out.println("is parent = " + path.getParent());
        System.out.println("normalize = " + path.normalize());
        System.out.println("absolute = " + path.toAbsolutePath());

        //Files.copy(Paths.get("name.txt"), Paths.get("src/main/resources/", "name.txt"));
        //Files.deleteIfExists(Paths.get("name.txt"));
        System.out.println(Files.size(Paths.get("name.txt")));

        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);

        try (Stream<String> stream = Files.lines(path)){
            long lineWithM = stream.filter(line -> line.startsWith("M")).count();
            System.out.println("Line count: " + lineWithM);
        }

        Files.walk(path.getParent()).forEach(System.out::println);
        //Files.lines(path).filter(line -> line.startsWith("M")).count();


        System.out.println(LocalDateTime.now());
    }
}
