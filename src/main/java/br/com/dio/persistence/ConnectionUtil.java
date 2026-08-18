package br.com.dio.persistence;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException{
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost/bootcamp");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "root");
        return DriverManager.getConnection(url, user, password);
    }
}
