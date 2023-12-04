package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String db = "src/main/resources/users.db";
        String jdbcUrl = "jdbc:sqlite:" + db;

        try (Connection connection = DriverManager.getConnection(jdbcUrl)){
            UserRepository repository = new UserRepository(connection);

            //repository.findByName("Anton' or 1=1 --").forEach(System.out::println);
            //repository.findByName("Anton").forEach(System.out::println);

            User user = new User();
            //user.setId(5);
            user.setFirstName("user_name2");
            user.setLastName("last_name2");
            user.setBirthDate("birth_date2");
            user.setLastAccessTime("last_access2");
            user.setActive(false);

            //repository.create(user);

            System.out.println("User with id 10:");
            repository.findById(10).ifPresent(System.out::println);
        }
    }
}
