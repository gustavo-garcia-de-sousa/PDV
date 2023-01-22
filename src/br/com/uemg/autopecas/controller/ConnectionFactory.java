/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/dbestoque";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public final Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
