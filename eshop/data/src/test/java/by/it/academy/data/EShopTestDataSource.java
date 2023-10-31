package by.it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EShopTestDataSource extends EShopDataSource {

    private static EShopTestDataSource dataSource;

    protected EShopTestDataSource() throws ClassNotFoundException {
        super();
    }

    @Override
    protected Connection getEShopConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eshop_test",
                "user",
                "user");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new EShopTestDataSource();
        }
        return dataSource.getEShopConnection();
    }


}
