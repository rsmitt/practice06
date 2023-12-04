package org.example.database;

import java.util.Optional;

public class OracleUserRepository implements Database{

    @Override
    public void create(User user) {

    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }
}
