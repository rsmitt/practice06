package org.example.database;

import java.util.Optional;

public interface Database {

    void create(User user);
    Optional<User> findById(int id);
    //...
}
