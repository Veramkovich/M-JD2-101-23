package by.it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EShopDataSource {

    private static EShopDataSource dataSource;
    private EShopDataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

    }

    private Connection getEShopConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eshop",
                "user",
                "user");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new EShopDataSource();
        }
        return dataSource.getEShopConnection();
    }

}
