package com.bankapplication;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection() {
        Yaml yaml = new Yaml();
        try (InputStream inputstream = getClass().getResourceAsStream("/config.yml")) {
            Map<String, Object> data = yaml.load(inputstream);
            Map<String, Object> databaseConfig = (Map<String, Object>) data.get("database");
            url = (String) databaseConfig.get("url");
            username = (String) databaseConfig.get("username");
            password = (String) databaseConfig.get("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}




