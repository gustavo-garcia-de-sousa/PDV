/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteUsuario {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.getConnection()) {

            String sql = "INSERT INTO Usuario (nome, senha) VALUES (?, ?);";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                List<Usuario> usuarios = new ArrayList<Usuario>();

                usuarios.add(new Usuario("GUSTAVO", "123"));

                statement.setString(1, usuarios.get(0).getNome());
                statement.setString(2, usuarios.get(0).getSenha());

                statement.execute();
            }
        }
    }

}
