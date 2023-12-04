package org.example.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage {

    public static void save(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true))){
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("dfsdfs");
        }
    }
}
