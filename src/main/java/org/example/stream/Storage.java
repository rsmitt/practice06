package org.example.stream;

import java.io.IOException;

@FunctionalInterface
public interface Storage {
    void save(String message) throws IOException;
}
