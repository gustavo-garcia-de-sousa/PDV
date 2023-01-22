/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author gustavo
 */
public class TesteCreate {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();
        /*
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO Usuarios ("
                + "Tipo, NomeCompleto, CPF, Senha, Email) VALUES ("
                + "'VENDEDOR', 'NEIDE', '12365498710','123', 'neide@gmail.com')", Statement.RETURN_GENERATED_KEYS);
         */
        Statement statement = connection.prepareStatement("INSERT INTO Usuarios ("
                + "Tipo, NomeCompleto, CPF, Senha, Email) VALUES ("
                + "'VENDEDOR', 'NEIDE', '12365498710','123', 'neide@gmail.com')", Statement.RETURN_GENERATED_KEYS);
        
             
        
        ResultSet result = statement.getGeneratedKeys();

        while (result.next()) {

            System.out.println("Registro nº " + result.getInt(1));
        }
    }

}
