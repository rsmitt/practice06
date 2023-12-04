package org.example.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Database{

    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(User user) {
        String sql = "INSERT INTO users (first_name, last_name, birth_date, last_access_time, active)" +
                " values(?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            //statement.setInt(1, user.getId());
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getBirthDate());
            statement.setString(4, user.getLastAccessTime());
            statement.setBoolean(5, user.isActive());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("sql exception", e);
        }
    }

    public Optional<User> findById(int id) {
        String sql = "select * from users where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return Optional.empty();
                }

                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBirthDate(resultSet.getString("birth_date"));
                user.setLastAccessTime(resultSet.getString("last_access_time"));
                user.setActive(resultSet.getBoolean("active"));

                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("sql exception", e);
        }
    }


    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        String sql = "select * from users where first_name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setBirthDate(resultSet.getString("birth_date"));
                    user.setLastAccessTime(resultSet.getString("last_access_time"));
                    user.setActive(resultSet.getBoolean("active"));

                    users.add(user);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("sql exception", e);
        }
        return users;
    }

}
