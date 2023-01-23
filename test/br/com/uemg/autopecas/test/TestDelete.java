/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author gustavo
 */
public class TestDelete {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.getConnection()) {
            /*
        Statement statement = connection.createStatement();
             */
            String sql = "DELETE FROM Usuarios WHERE idUsuario > ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, 5);//(índice SQL, valor)

                statement.execute();

                System.out.println("Registros deletados:" + statement.getUpdateCount());
            }
        }
    }
}
