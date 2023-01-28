package br.com.uemg.autopecas.controller;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class ConnectionFactory {

    public DataSource dataSource;

    private static final String URL = "jdbc:mysql://localhost:3306/pdv";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /*public ConnectionFactory() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASSWORD);

        //cpds.setMaxPoolSize(10);
        this.dataSource = cpds;
    }*/
    public final Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
        //return this.dataSource.getConnection();
    }

}
