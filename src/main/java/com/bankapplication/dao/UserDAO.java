package com.bankapplication.dao;


import com.bankapplication.model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserDAO implements DaoConnector<User>{

        @Override
        public String tableName() {
            return "bankapplication.user";
        }


        @Override
        public List<String> columnNames() {
            return Arrays.asList("user_id", "username", "full_name", "password", "email");
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
    }

