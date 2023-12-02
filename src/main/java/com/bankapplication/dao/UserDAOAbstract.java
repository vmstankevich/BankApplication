package com.bankapplication.dao;


import com.bankapplication.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserDAOAbstract extends DaoAbstractConnector<User> {

        private final static String tableName = "bankapplication.user";
        private final static List<String> columnNames = Arrays.asList("user_id", "username", "full_name", "password", "email");

    public UserDAOAbstract() {
        super(tableName, columnNames);
    }


    @Override
        public PreparedStatement process(PreparedStatement ps, User user) throws SQLException {
            int i = 0;
            ps.setInt(++i, user.getUserId());
            ps.setString(++i, user.getUsername());
            ps.setString(++i, user.getFullName());
            ps.setString(++i, user.getPassword());
            ps.setString(++i, user.getEmail());
            return ps;
        }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        String username = resultSet.getString("full_name");
        String fullName = resultSet.getString("full_name");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");

        return new User(userId, username, fullName, password, email);
    }
}

