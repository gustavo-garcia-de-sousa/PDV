/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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

        connection.setAutoCommit(false);//desligando o controle transacional default

        //pré compilando a QUERY para evitar SQL INJECTION
        /*
            statement.setString(1, "VENDEDOR");//(índice SQL, valor)
            statement.setString(2, "LEONARDO");
            statement.setString(3, "555666777-20");
            statement.setString(4, "123");
            statement.setString(5, "contato@leonardo.com");
            statement.execute();
         */
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Usuarios ("
                + "Tipo, NomeCompleto, CPF, Senha, Email) VALUES ("
                + "?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            /*
                statement.setString(1, "VENDEDOR");//(índice SQL, valor)
                statement.setString(2, "LEONARDO");
                statement.setString(3, "555666777-20");
                statement.setString(4, "123");
                statement.setString(5, "contato@leonardo.com");
                
                statement.execute();
                
             *///criei um método para facilitar na sintaxe SQL
            add("VENDEDOR", "JP", "12345697801", "123", "contato@cedan.com", statement);
            add("VENDEDOR", "AH", "12345697801", "123", "contato@henrique.com", statement);
            add("VENDEDOR", "GG", "12345697801", "123", "contato@garcia.com", statement);

            connection.commit();//autorizando a transação do SQL

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("ROLLBACK EXECUTADO"); //roll back = ação da transação desfeita

        }

    }

    public static void add(String Tipo, String NomeCompleto, String CPF, String Senha, String Email, PreparedStatement statement) throws SQLException {

        statement.setString(1, Tipo);//(índice SQL, valor)
        statement.setString(2, NomeCompleto);
        statement.setString(3, CPF);
        statement.setString(4, Senha);
        statement.setString(5, Email);

        //simulando um erro pra testar o roll back
        if (Senha.equals("123")) {
            throw new RuntimeException("Não foi possível adicionar produto");
        }

        statement.execute();

        try (ResultSet result = statement.getGeneratedKeys()) {

            while (result.next()) {

                System.out.println("Registro nº " + result.getInt(1));
            }
        }

    }

}
