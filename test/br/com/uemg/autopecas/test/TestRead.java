/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author gustavo
 */
public class TestRead {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        /*
        Statement statement = connection.createStatement();
         */
        try (Connection connection = factory.getConnection()) {
            /*
            Statement statement = connection.createStatement();
            */
            String sql = "SELECT codigo, nome, senha FROM Usuario";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println("id nº " + result.getInt("codigo") + " nome completo " + result.getNString("nome"));
            }
            /**/
        }
    }

}
